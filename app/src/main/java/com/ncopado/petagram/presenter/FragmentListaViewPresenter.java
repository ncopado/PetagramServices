package com.ncopado.petagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.fragment.IFragmentLista;
import com.ncopado.petagram.pojo.Pet;
import com.ncopado.petagram.restApi.ConstantRestApi;
import com.ncopado.petagram.restApi.EndPointApi;
import com.ncopado.petagram.restApi.Model.PetResponse;
import com.ncopado.petagram.restApi.adapter.RestApiAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ncopado on 19/09/17.
 */

public class FragmentListaViewPresenter implements  IFragmentListaViewPresenter {

    private IFragmentLista iFragmentLista;
    private Context context;
    private PetRepository petRepository;
    private ArrayList<Pet> lstPet;
    private ArrayList<Pet> pets;
    public String userId="";



    public FragmentListaViewPresenter(IFragmentLista iFragmentLista, Context context) {
        this.iFragmentLista=iFragmentLista;
        this.context=context;


        getPets();
        getMediaRecent();




    }

    @Override
    public void getPets() {


        PetRepository petRepository=new PetRepository(context);

        lstPet=   petRepository.getPets();

        ShowPets();

    }

    @Override
    public void ShowPets() {

        iFragmentLista.AdaptadorRv(iFragmentLista.CreateAdapter(lstPet));
        iFragmentLista.CreateLinearLayoutVertical();

    }


    public  void  getUserIdInstagram(){
        PetRepository petRepository=new PetRepository(context);
        userId= petRepository.getUserIdInstagram();

    }


    @Override
    public void showData() {
        iFragmentLista.AdaptadorRv(iFragmentLista.CreateAdapter(pets));
        iFragmentLista.CreateLinearLayoutVertical();
    }

    @Override
    public void getMediaRecent() {
        RestApiAdapter restApiAdapter=new RestApiAdapter();
        Gson gson=restApiAdapter.gsonDeserialize();

        EndPointApi endPointApi=restApiAdapter.getConnectionRestApiInstagram(gson);


        PetRepository petRepository=new PetRepository(context);
        String id=petRepository.getUserIdInstagram();


        Call<PetResponse> responseCall=endPointApi.getRecemtMedia(ConstantRestApi.getIdInstagram(id));
        responseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse=response.body();
                pets=petResponse.getPets();
                showData();
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(context,"No se pudo conectar",Toast.LENGTH_LONG).show();
                Log.e("xxx",t.toString());


            }
        });
    }
}
