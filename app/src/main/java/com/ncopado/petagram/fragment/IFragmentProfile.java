package com.ncopado.petagram.fragment;

import com.ncopado.petagram.adapter.PetAdaptador;
import com.ncopado.petagram.adapter.ProfileAdapter;
import com.ncopado.petagram.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by ncopado on 25/09/17.
 */

public interface IFragmentProfile {

    public  void configGridLayoutVertical();

    public ProfileAdapter createAdapter(ArrayList<Pet> pets) ;

    public void  startAdapterRv(ProfileAdapter petAdaptador);



}
