package com.ncopado.petagram.db;

/**
 * Created by ncopado on 17/09/17.
 */

public final class dbConstants {

    public static final String DATABASE_NAME="dbPetagram";

    public static final int DATABASE_VERSION=2;

    public static final String TABLE_PETS="PETS";

    public static final String COLUMN_PET_ID="Pet_Id";
    public static final String COLUMN_PET_NAME="Name";
    public static final String COLUMN_PET_PHOTO="Photo";


    public static final String TABLE_LIKES_PETS="PETS_LIKES";
    public static final String COLUMN_PET_LIKES_ID="Pet_Likes_Id";
    public static final String COLUMN_PET_LIKES_ID_PET="Pet_Id";
    public static final String COLUMN_PET_LIKES_NUMERO="Likes";



    public static final String TABLE_USER="INSTAGRAM";
    public static final String COLUMN_USER_ID="userId";






}
