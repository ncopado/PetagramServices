package com.ncopado.petagram.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ncopado.petagram.R;
import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.pojo.Pet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ncopado on 25/09/17.
 */

public class ProfileAdapter  extends RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    ArrayList<Pet> lstPet;
    Activity activity;
    int type;
    View view;
    public ProfileAdapter(ArrayList<Pet> lstPet,Activity activity) {
        this.lstPet = lstPet;

        this.activity=activity;

    }

    public ProfileAdapter(ArrayList<Pet> pets, FragmentActivity activity) {

        this.lstPet = pets;

        this.activity=activity;



    }

    @Override
    public ProfileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_list_profile,parent,false);

        return new ProfileAdapter.ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileViewHolder holder, int position) {


        final  Pet pet=lstPet.get(position);


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

    public  static  class ProfileViewHolder extends RecyclerView.ViewHolder {

        private ImageView petPhoto;
        private TextView tvName;
        private TextView tvRating;
        private ImageButton btnLike;

        public ProfileViewHolder(View itemView) {
            super(itemView);


            petPhoto=(ImageView) itemView.findViewById(R.id.petphoto);

            /*if(type==1) {

                btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);
            }*/
            tvRating=(TextView) itemView.findViewById(R.id.tvReting);

        }
    }


}
