package com.ncopado.petagram;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.restApi.EndPointApi;
import com.ncopado.petagram.restApi.Model.UsuarioResponse;
import com.ncopado.petagram.restApi.adapter.UsuarioRestApiAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ncopado on 09/10/17.
 */

public class NotificationIDTokenService  extends   FirebaseInstanceIdService {


    private static String result="";
    public  static String GetIDDevices(){

        return FirebaseInstanceId.getInstance().getToken();


    }








}
