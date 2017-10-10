package com.ncopado.petagram.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.pojo.Pet;
import com.ncopado.petagram.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ncopado on 02/09/17.
 */

public class PetAdaptador extends RecyclerView.Adapter<PetAdaptador.PetViewHolder> {


    ArrayList<Pet> lstPet;
    Activity activity;
    int type;
    View view;
    public PetAdaptador(ArrayList<Pet> lstPet,Activity activity,int type) {
        this.lstPet = lstPet;

        this.activity=activity;
        this.type=type;
    }

    public PetAdaptador(ArrayList<Pet> pets, FragmentActivity activity) {

        this.lstPet = pets;

        this.activity=activity;

        this.type=1;

    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(type==1){
             view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_list_api,parent,false);
        }
        else
        {
             view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_list_profile,parent,false);
        }



        return new PetViewHolder(view,type);
    }

    @Override
    public void onBindViewHolder(final PetViewHolder holder, int position) {

        final  Pet pet=lstPet.get(position);

        /*holder.petPhoto.setImageResource(pet.getPhoto());


        if(type==1) {
            holder.tvName.setText(pet.getName());
            holder.btnLike.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    PetRepository petRepository=new PetRepository(activity);
                    petRepository.insertRating(pet);

                    holder.tvRating.setText(String.valueOf(petRepository.getRatingPet(pet)));



                    Toast.makeText(activity, "Diste like", Toast.LENGTH_SHORT).show();
                }


            });
        }


        holder.tvRating.setText( Integer.toString(  pet.getReiting()));
        */

        Picasso.with(activity)
                .load(pet.getUrlPhoto())
                .placeholder(R.drawable.icons8_dog_bone_48color)
                .into(holder.petPhoto);


        holder.tvRating.setText( Integer.toString(  pet.getReiting()));



    }

    @Override
    public int getItemCount() {
        return lstPet.size();
    }

    public  static  class PetViewHolder extends ViewHolder {

        private ImageView petPhoto;
        private TextView tvName;
        private TextView tvRating;
        private ImageButton btnLike;

        public PetViewHolder(View itemView,int type) {
            super(itemView);


            petPhoto=(ImageView) itemView.findViewById(R.id.petphoto);


            tvRating=(TextView) itemView.findViewById(R.id.tvlikes);

        }
    }
}
