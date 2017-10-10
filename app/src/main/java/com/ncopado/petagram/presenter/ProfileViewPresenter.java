package com.ncopado.petagram.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.fragment.IFragmentProfile;
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
 * Created by ncopado on 25/09/17.
 */

public class ProfileViewPresenter implements  IProfileViewPresenter {

    private IFragmentProfile iFragmentProfile;
    private Context context;
    private ArrayList<Pet> pets;

    public String userId="";


    public ProfileViewPresenter(IFragmentProfile iFragmentProfile, Context context) {

        this.iFragmentProfile=iFragmentProfile;
        this.context=context;

        getMediaRecent();


    }

    @Override
    public void showData() {
        iFragmentProfile.startAdapterRv(iFragmentProfile.createAdapter(pets));

        iFragmentProfile.configGridLayoutVertical();


    }

    public  void  getUserIdInstagram(){
        PetRepository petRepository=new PetRepository(context);
        userId= petRepository.getUserIdInstagram();

    }


    @Override
    public void getMediaRecent() {

        RestApiAdapter restApiAdapter=new RestApiAdapter();
        Gson gson=restApiAdapter.gsonDeserialize();

        EndPointApi endPointApi=restApiAdapter.getConnectionRestApiInstagram(gson);

       // Call<PetResponse> responseCall=endPointApi.getRecemtMedia(ConstantRestApi.URL_GET_RECENT_MEDIA_USER);


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
