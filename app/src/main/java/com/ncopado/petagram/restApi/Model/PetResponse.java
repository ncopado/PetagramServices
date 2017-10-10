package com.ncopado.petagram.restApi.Model;

import com.ncopado.petagram.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by ncopado on 25/09/17.
 */

public class PetResponse {

    ArrayList<Pet> pets;

    public ArrayList<Pet> getPets() {
        return this.pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}
