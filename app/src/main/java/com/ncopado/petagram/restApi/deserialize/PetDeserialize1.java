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
 * Created by ncopado on 28/09/17.
 */

public class PetDeserialize1 implements JsonDeserializer<PetResponse>{


    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson=new Gson();
        PetResponse petResponse=gson.fromJson(json,PetResponse.class);
        JsonArray responseData= json.getAsJsonObject().getAsJsonArray("data");

        petResponse.setPets(deserializeData1(responseData));

        return petResponse;
    }


        private ArrayList<Pet> deserializeData1(JsonArray responseData){
            ArrayList<Pet> pets=new ArrayList<>();

            for (int i = 0; i <responseData.size() ; i++) {

                JsonObject userJsonData=responseData.get(i).getAsJsonObject();

                //JsonObject userJsonData=petResponDataObject.getAsJsonObject(JsonKeys.USER);
                String id=userJsonData.get(JsonKeys.USER_ID).getAsString();






                Pet pet =new Pet();
                pet.setIdInstagram(id);



                pets.add(pet);



            }


            return  pets;

        }


}
