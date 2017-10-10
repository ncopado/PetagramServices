package com.ncopado.petagram.fragment;

import com.ncopado.petagram.adapter.PageAdapter;
import com.ncopado.petagram.adapter.PetAdaptador;
import com.ncopado.petagram.pojo.Pet;

import java.util.ArrayList;

/**
 * Created by ncopado on 19/09/17.
 */

public interface IFragmentLista {

    public void CreateLinearLayoutVertical();

    public PetAdaptador CreateAdapter(ArrayList<Pet> pets);

    public void AdaptadorRv(PetAdaptador petAdaptador);


}
