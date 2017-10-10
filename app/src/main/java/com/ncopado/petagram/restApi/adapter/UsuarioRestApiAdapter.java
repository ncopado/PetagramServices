package com.ncopado.petagram.restApi.adapter;

import com.ncopado.petagram.restApi.ConstantRestApi;
import com.ncopado.petagram.restApi.EndPointApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ncopado on 07/10/17.
 */

public class UsuarioRestApiAdapter {

    public EndPointApi establecerConexionRestApi(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ConstantRestApi.ROOT_URL_MYAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;

        return  retrofit.create(EndPointApi.class);
    }
}
