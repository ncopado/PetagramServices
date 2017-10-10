package com.ncopado.petagram.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ncopado.petagram.restApi.ConstantRestApi;
import com.ncopado.petagram.restApi.EndPointApi;
import com.ncopado.petagram.restApi.Model.PetResponse;
import com.ncopado.petagram.restApi.deserialize.PetDeserialize;
import com.ncopado.petagram.restApi.deserialize.PetDeserialize1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ncopado on 25/09/17.
 */

public class RestApiAdapter {

    public EndPointApi getConnectionRestApiInstagram(Gson gson){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(ConstantRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return  retrofit.create(EndPointApi.class);
    }


    public Gson gsonDeserialize(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class,new PetDeserialize());

        return gsonBuilder.create();

    }

    public Gson gsonGetInfoUSerDeserialize(){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class,new PetDeserialize1());

        return gsonBuilder.create();

    }


}
