package com.ncopado.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ncopado.petagram.adapter.PageAdapter;
import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.fragment.FragmentLista;
import com.ncopado.petagram.fragment.FragmentProfile;
import com.ncopado.petagram.restApi.EndPointApi;
import com.ncopado.petagram.restApi.Model.UsuarioResponse;
import com.ncopado.petagram.restApi.adapter.UsuarioRestApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {




    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        tabLayout=(TabLayout) findViewById(R.id.tabLayout);

        viewPager=(ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_favourites,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mFavourite:
                Intent intent=new Intent(this,FavouritePEt.class);
                startActivity(intent);
                break;
            case R.id.mContact:
                Intent intentMcontact=new Intent(this,Contact.class);
                startActivity(intentMcontact);
                break;

            case R.id.mAbout:
                Intent intentMaboutUs=new Intent(this,AboutUs.class);
                startActivity(intentMaboutUs);
                break;
            case R.id.mConfigAcount:
                Intent intentConfigAcount=new Intent(this,ConfigAcount.class);
                startActivity(intentConfigAcount);
                break;
            case R.id.mNotificaciones:
                PetRepository petRepository=new PetRepository(this);
                String id=petRepository.getUserIdInstagram();

                enviarTokenRegistro(NotificationIDTokenService.GetIDDevices(),id);

                break;



        }


        return super.onOptionsItemSelected(item);
    }


    private  ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments=new ArrayList<>();

        fragments.add(new FragmentLista());
        fragments.add(new FragmentProfile());


        return  fragments;
    }


    private void  setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_home);

        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_profile);


    }



    public  void enviarTokenRegistro(String token,String id) {

        UsuarioRestApiAdapter restApiAdapter=new UsuarioRestApiAdapter();
        EndPointApi endpoints=restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall=endpoints.registroTokenID(token,id);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse=response.body();
                Log.d("ID FIREBASE",usuarioResponse.getInstagramId());
                Log.d("TOKEN FIREBASE",usuarioResponse.getToken());



                Toast.makeText(MainActivity.this, "Se guardo el Device y el Usuario con exito", Toast.LENGTH_SHORT)
                        .show();





            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });



    }
}
