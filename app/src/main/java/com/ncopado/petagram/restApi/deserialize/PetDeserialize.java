package com.ncopado.petagram.restApi.deserialize;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ncopado.petagram.pojo.Pet;
import com.ncopado.petagram.restApi.JsonKeys;
import com.ncopado.petagram.restApi.Model.PetResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by ncopado on 25/09/17.
 */

public class PetDeserialize implements JsonDeserializer<PetResponse> {

    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();
        PetResponse petResponse=gson.fromJson(json,PetResponse.class);
        JsonArray responseData= json.getAsJsonObject().getAsJsonArray("data");

        petResponse.setPets(deserializeData(responseData));

        return petResponse;

    }

    private ArrayList<Pet> deserializeData(JsonArray responseData){
        ArrayList<Pet> pets=new ArrayList<>();

        for (int i = 0; i <responseData.size() ; i++) {

            JsonObject petResponDataObject=responseData.get(i).getAsJsonObject();

            JsonObject userJsonData=petResponDataObject.getAsJsonObject(JsonKeys.USER);
            String id=userJsonData.get(JsonKeys.USER_ID).getAsString();
            String fullName=userJsonData.get(JsonKeys.USER_FULLNAME).getAsString();
            String profilePicture=userJsonData.get(JsonKeys.USER_PROFILE_PICTURE).getAsString();



            JsonObject  imgJson =petResponDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject  stdResolution =imgJson.getAsJsonObject(JsonKeys.MEDIA_STANDAR_RESOLUTION);
            String urlFoto=stdResolution.get(JsonKeys.MEDIA_URL).getAsString();


            JsonObject  likesJson =petResponDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes=likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();


            Pet pet =new Pet();
            pet.setIdInstagram(id);
            pet.setName(fullName);
            pet.setUrlPhoto(urlFoto);
            pet.setReiting(likes);
            pet.setUrlPhotoProfile(profilePicture);


            pets.add(pet);



        }


        return  pets;

    }







}
