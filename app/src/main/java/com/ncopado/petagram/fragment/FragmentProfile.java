package com.ncopado.petagram.fragment;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ncopado.petagram.R;
import com.ncopado.petagram.adapter.PetAdaptador;
import com.ncopado.petagram.adapter.ProfileAdapter;
import com.ncopado.petagram.pojo.Pet;
import com.ncopado.petagram.presenter.IProfileViewPresenter;
import com.ncopado.petagram.presenter.ProfileViewPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ncopado on 04/09/17.
 */

public class FragmentProfile extends Fragment implements IFragmentProfile {

    ArrayList<Pet> lstPet;
    private RecyclerView listPet;
    private IProfileViewPresenter presenter;
    View view;
    private  TextView textView;
    private ImageView imageView;

    public FragmentProfile() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_profile,container,false);

        listPet= view.findViewById(R.id.rvPetProfile);

        presenter =new ProfileViewPresenter(this,getContext());

        textView= view.findViewById(R.id.tvProfileName);

        imageView= view.findViewById(R.id.imgPet);

        return  view;
    }




    public  void InicializarAdaptador(){
        PetAdaptador adaptador=new PetAdaptador(lstPet,getActivity(),2);

        listPet.setAdapter(adaptador);
    }

    @Override
    public void configGridLayoutVertical() {

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);

        listPet.setLayoutManager(gridLayoutManager);
    }

    @Override
    public ProfileAdapter createAdapter(ArrayList<Pet> pets) {
        ProfileAdapter petAdaptador=new ProfileAdapter(pets,getActivity());

        getProfileData(pets);

        return  petAdaptador;
    }

    @Override
    public void startAdapterRv(ProfileAdapter petAdaptador) {

        listPet.setAdapter(petAdaptador);
    }

    public  void  getProfileData(ArrayList<Pet> pets){

        final  Pet pet=pets.get(0);

        textView.setText(pet.getName());


        Picasso.with(getContext())
                .load(pet.getUrlPhotoProfile())
                .placeholder(R.drawable.icons8_dog_bone_48color)
                .into(imageView);
    }





}
