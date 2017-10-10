package com.ncopado.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ncopado.petagram.adapter.PetAdaptador;
import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.pojo.Pet;

import java.util.ArrayList;

public class FavouritePEt extends AppCompatActivity {


    ArrayList<Pet> lstPet;
    private RecyclerView listPet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_pet);

        listPet=(RecyclerView) findViewById(R.id.rvFavouritePet);

        LinearLayoutManager llm=new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listPet.setLayoutManager(llm);

        GetFavouritePet();
        InicializarAdaptador();
    }

    private void GetFavouritePet() {


        PetRepository petRepository=new PetRepository(this);
         lstPet= petRepository.getTopPets();

    }

    public  void InicializarAdaptador(){
        PetAdaptador adaptador=new PetAdaptador(lstPet,this,1);
        listPet.setAdapter(adaptador);
    }
}
