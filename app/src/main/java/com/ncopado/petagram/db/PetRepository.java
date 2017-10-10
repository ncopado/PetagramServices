package com.ncopado.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.ncopado.petagram.R;
import com.ncopado.petagram.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by ncopado on 17/09/17.
 */

public class PetRepository {
    private static final  int RATING=1;
    private Context context;

    public PetRepository(Context context) {
        this.context = context;
    }


    public  void cargaInicial(){

        DataBase dataBase=new DataBase(context);
        insertPets(dataBase);
    }


    public ArrayList<Pet> getPets(){

        ArrayList<Pet> pets;
        DataBase dataBase=new DataBase(context);

        pets=dataBase.getAllPets();

        if(pets.size()==0){
            cargaInicial();
            pets=dataBase.getAllPets();
        }


        return  pets;
    }

    public  void  insertPets(DataBase dataBase){

        ContentValues pet1=new ContentValues();
        pet1.put(dbConstants.COLUMN_PET_NAME,"LOLA");
        pet1.put(dbConstants.COLUMN_PET_PHOTO, R.drawable.pet1);

        dataBase.insertPet(pet1);


        ContentValues pet2=new ContentValues();
        pet2.put(dbConstants.COLUMN_PET_NAME,"RON");
        pet2.put(dbConstants.COLUMN_PET_PHOTO, R.drawable.pet2);

        dataBase.insertPet(pet2);

        ContentValues pet3=new ContentValues();
        pet3.put(dbConstants.COLUMN_PET_NAME,"TACHA");
        pet3.put(dbConstants.COLUMN_PET_PHOTO, R.drawable.pet3);

        dataBase.insertPet(pet3);


        ContentValues pet4=new ContentValues();
        pet4.put(dbConstants.COLUMN_PET_NAME,"UNO");
        pet4.put(dbConstants.COLUMN_PET_PHOTO, R.drawable.pet4);

        dataBase.insertPet(pet4);


        ContentValues pet5=new ContentValues();
        pet5.put(dbConstants.COLUMN_PET_NAME,"SIBORG");
        pet5.put(dbConstants.COLUMN_PET_PHOTO, R.drawable.pet5);

        dataBase.insertPet(pet5);


        ContentValues userId=new ContentValues();
        userId.put(dbConstants.COLUMN_USER_ID,"6068305501");




        dataBase.insertIdInstagram(userId);

    }


    public void  insertRating(Pet pet){
        DataBase dataBase=new DataBase(context);

        ContentValues contentValues=new ContentValues();
        contentValues.put(dbConstants.COLUMN_PET_LIKES_ID_PET,pet.getId());
        contentValues.put(dbConstants.COLUMN_PET_LIKES_NUMERO,RATING);
        dataBase.insertRating(contentValues);



    }

    public int getRatingPet(Pet pet){
        DataBase dataBase=new DataBase(context);

        return dataBase.getRatingPet(pet);

    }

    public ArrayList<Pet> getTopPets(){

        DataBase dataBase=new DataBase(context);



        return  dataBase.getTopFivePets();
    }

    public String getUserIdInstagram(){

        DataBase dataBase=new DataBase(context);

        return  dataBase.getUserIdInstagram();

    }


    public void  insertUserId(String userId){
        DataBase dataBase=new DataBase(context);





        ContentValues contentValues=new ContentValues();
        contentValues.put(dbConstants.COLUMN_USER_ID,userId);

        dataBase.insertIdInstagram(contentValues);



    }


    public void existDb() {
    }
}
