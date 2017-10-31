package com.ncopado.petagram.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.ncopado.petagram.db.PetRepository;
import com.ncopado.petagram.pojo.Pet;
import com.ncopado.petagram.R;
import com.ncopado.petagram.restApi.ConstantRestApi;
import com.ncopado.petagram.restApi.EndPointApi;
import com.ncopado.petagram.restApi.Model.PetResponse;
import com.ncopado.petagram.restApi.Model.ResponseLike;
import com.ncopado.petagram.restApi.Model.UsuarioResponse;
import com.ncopado.petagram.restApi.adapter.RestApiAdapter;
import com.ncopado.petagram.restApi.adapter.UsuarioRestApiAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like"+pet.getImgId().toString(), Toast.LENGTH_SHORT).show();
                holder.tvRating.setText( Integer.toString(  pet.getReiting()+1));





                SaveLike(pet.getImgId().toString(),pet.getIdInstagram().toString());

            }




        });



        Picasso.with(activity)
                .load(pet.getUrlPhoto())
                .placeholder(R.drawable.icons8_dog_bone_48color)
                .into(holder.petPhoto);


        holder.tvRating.setText( Integer.toString(  pet.getReiting()));



    }





    private void SaveLike(final String imgId, final String instagramId) {





        RestApiAdapter restApiAdapter=new RestApiAdapter();
        Gson gson=restApiAdapter.gsonDeserialize();

        EndPointApi endPointApi=restApiAdapter.getConnectionRestApiInstagram(gson);

        Call<ResponseLike> responseCall=endPointApi.registrarLike(imgId);
        responseCall.enqueue(new Callback<ResponseLike>() {
            @Override
            public void onResponse(Call<ResponseLike> call, Response<ResponseLike> response) {

                ResponseLike petResponse=response.body();
                Toast.makeText(activity,"OK",Toast.LENGTH_LONG).show();


                String  tokenDevice = FirebaseInstanceId.getInstance().getToken();


                UsuarioRestApiAdapter restApiAdapter=new UsuarioRestApiAdapter();
                EndPointApi endpoints=restApiAdapter.establecerConexionRestApi();
                Call<ResponseLike> responseLikeCall =endpoints.saveinfoLike(imgId,instagramId,tokenDevice);
                responseLikeCall.enqueue(new Callback<ResponseLike>() {
                    @Override
                    public void onResponse(Call<ResponseLike> call, Response<ResponseLike> response) {
                        ResponseLike petResponse=response.body();
                    }

                    @Override
                    public void onFailure(Call<ResponseLike> call, Throwable t) {
                        Log.e("xxx",t.toString());
                    }
                });

            }

            @Override
            public void onFailure(Call<ResponseLike> call, Throwable t) {
                Toast.makeText(activity,"No se pudo conectar",Toast.LENGTH_LONG).show();
                Log.e("xxx",t.toString());


            }
        });
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

            btnLike=itemView.findViewById(R.id.btnLike);

        }
    }
}
