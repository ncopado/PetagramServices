package com.ncopado.petagram.restApi;

import android.content.Context;

import com.ncopado.petagram.db.PetRepository;

import java.net.PortUnreachableException;

/**
 * Created by ncopado on 25/09/17.
 */

public class ConstantRestApi {

    public static final  String VERSION="/v1/";
    public static final  String ROOT_URL="https://api.instagram.com" + VERSION;
    public static final  String ACCES_TOKEN="6068305501.531bf24.8f86cd2ebc9f47feb261ed7956ee6faa";
    public static final  String KEY_ACCESS_TOKEN="?access_token=";
    public static final  String KEY_GET_RECENT_MEDIA_USER="users/self/media/recent/";
    public static final  String URL_GET_RECENT_MEDIA_USER=KEY_GET_RECENT_MEDIA_USER+KEY_ACCESS_TOKEN+ACCES_TOKEN;


    //Key de api para obtener media recent by  userId
    public static   String KEY_GET_USER="users/";
    public static final  String KEY_GET_MEDIA="/media/recent/";
    public  static String getIdInstagram(String userInsta){
         String url= KEY_GET_USER+userInsta+KEY_GET_MEDIA+KEY_ACCESS_TOKEN+ACCES_TOKEN;

        return url;

    }

    //Key para obtener id de instagram
    public static String KEY_SEARCH_USER="users/search?q=";
    public static String KEY_SEARCH_TOKEN="&access_token=";
    public  static String getUrlSearchUser(String userName){

        String url=KEY_SEARCH_USER+userName+KEY_SEARCH_TOKEN+ACCES_TOKEN;

        return  url;

    }


    //root my server
    public static final String ROOT_URL_MYAPI="https://gentle-thicket-56327.herokuapp.com/";
    public  static  final  String KEY_POST_ID_TOKEN="registrar-usuario";





}
