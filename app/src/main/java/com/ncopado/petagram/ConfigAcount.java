package com.ncopado.petagram;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.pojo.Pet;
import com.ncopado.petagram.restApi.ConstantRestApi;
import com.ncopado.petagram.restApi.EndPointApi;
import com.ncopado.petagram.restApi.Model.PetResponse;
import com.ncopado.petagram.restApi.Model.UsuarioResponse;
import com.ncopado.petagram.restApi.adapter.RestApiAdapter;
import com.ncopado.petagram.restApi.adapter.UsuarioRestApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfigAcount extends AppCompatActivity {

    private Button button;
   private  String id;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_acount);

        this.context=this;

        button = (Button) findViewById(R.id.btnSave);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser(view);
            }
        });


    }

    public void saveUser(View v) {


        TextView textView = (TextView) findViewById(R.id.etUsuario);


        getUserIdByFullName(textView.getText().toString());






    }


    public void enviarTokenRegistro(String token,String id){

        UsuarioRestApiAdapter restApiAdapter=new UsuarioRestApiAdapter();
        EndPointApi endpoints=restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall=endpoints.registroTokenID(token,id);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse=response.body();
                Log.d("ID FIREBASE",usuarioResponse.getInstagramId());
                Log.d("TOKEN FIREBASE",usuarioResponse.getToken());

            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });


    }


    public void getUserIdByFullName(String name) {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.gsonGetInfoUSerDeserialize();

        EndPointApi endPointApi = restApiAdapter.getConnectionRestApiInstagram(gson);


        Call<PetResponse> responseCall = endPointApi.getId(ConstantRestApi.getUrlSearchUser(name));
        responseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                ArrayList<Pet> pets;
                 pets = petResponse.getPets();

                id=pets.get(0).getIdInstagram();

                PetRepository petRepository = new PetRepository(context);
                petRepository.insertUserId(id);

                String  token = FirebaseInstanceId.getInstance().getToken();
                enviarTokenRegistro(token,id);


            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(getBaseContext(), "No se pudo conectar", Toast.LENGTH_LONG).show();
                Log.e("xxx", t.toString());


            }
        });

    }
}
