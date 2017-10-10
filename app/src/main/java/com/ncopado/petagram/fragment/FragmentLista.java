package com.ncopado.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.pojo.Pet;
import com.ncopado.petagram.adapter.PetAdaptador;
import com.ncopado.petagram.R;
import com.ncopado.petagram.presenter.FragmentListaViewPresenter;
import com.ncopado.petagram.presenter.IFragmentListaViewPresenter;

import java.util.ArrayList;

/**
 * Created by ncopado on 04/09/17.
 */

public class FragmentLista extends Fragment implements IFragmentLista {

    ArrayList<Pet> lstPet;
    private RecyclerView listPet;
    private IFragmentListaViewPresenter presenter;

    public FragmentLista() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_list,container,false);

        listPet=(RecyclerView) view.findViewById(R.id.rvPet);


        presenter=new FragmentListaViewPresenter(this,getContext());

        /*

        AddPet();
        InicializarAdaptador();
        */
        return view;
    }






    private void AddPet() {
      /*  lstPet=new ArrayList<Pet>();

        lstPet.add(new Pet("Lola",5,R.drawable.pet1));
        lstPet.add(new Pet("Lola",5,R.drawable.pet2));
        lstPet.add(new Pet("Lola",5,R.drawable.pet3));
        lstPet.add(new Pet("Lola",5,R.drawable.pet4));
        lstPet.add(new Pet("Lola",5,R.drawable.pet5));
        lstPet.add(new Pet("Lola",5,R.drawable.pet1));
        lstPet.add(new Pet("Lola",5,R.drawable.pet2));
        lstPet.add(new Pet("Lola",5,R.drawable.pet3));
        lstPet.add(new Pet("Lola",5,R.drawable.pet4));
        lstPet.add(new Pet("Lola",5,R.drawable.pet5));
        */

        PetRepository petRepository=new PetRepository(getContext());

        lstPet=   petRepository.getPets();





    }

    public  void InicializarAdaptador(){
        PetAdaptador adaptador=new PetAdaptador(lstPet,getActivity(),1);
        listPet.setAdapter(adaptador);
    }


    @Override
    public void CreateLinearLayoutVertical() {

        LinearLayoutManager llm=new LinearLayoutManager(getActivity());

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listPet.setLayoutManager(llm);

    }

    @Override
    public PetAdaptador CreateAdapter(ArrayList<Pet> pets) {

        PetAdaptador petAdaptador=new PetAdaptador(pets,getActivity());


        return petAdaptador;
    }

    @Override
    public void AdaptadorRv(PetAdaptador petAdaptador) {

            listPet.setAdapter(petAdaptador);
    }
}
