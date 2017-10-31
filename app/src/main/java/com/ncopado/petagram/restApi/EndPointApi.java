package com.ncopado.petagram.restApi;



import com.ncopado.petagram.restApi.Model.PetResponse;
import com.ncopado.petagram.restApi.Model.ResponseLike;
import com.ncopado.petagram.restApi.Model.UsuarioResponse;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by ncopado on 25/09/17.
 */

public interface EndPointApi {

    @GET
    Call<PetResponse> getRecemtMedia(@Url String url);

    @GET
    Call<PetResponse> getId(@Url String url);


    @FormUrlEncoded
    @POST(ConstantRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registroTokenID(@Field("token") String token,@Field("userId") String userId);



    @POST(ConstantRestApi.KEY_MEDIA)
    Call<ResponseLike> registrarLike(@Path("mediaId") String mediaId);

    @FormUrlEncoded
    @POST(ConstantRestApi.KEY_POST_SAVE_LIKES)
    Call<ResponseLike>saveinfoLike(@Field("id_foto_instagram") String id_foto_instagram,@Field("id_usuario_instagram") String id_usuario_instagram,@Field("id_dispositivo") String id_dispositivo);

}
