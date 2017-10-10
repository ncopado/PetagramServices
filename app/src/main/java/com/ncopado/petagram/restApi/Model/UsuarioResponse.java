package com.ncopado.petagram.restApi.Model;

/**
 * Created by ncopado on 07/10/17.
 */

public class UsuarioResponse {

    public  String InstagramId;

    public  String Token;

    public UsuarioResponse() {
    }

    public UsuarioResponse(String instagramId, String token) {
        InstagramId = instagramId;
        Token = token;
    }

    public String getInstagramId() {
        return InstagramId;
    }

    public void setInstagramId(String instagramId) {
        InstagramId = instagramId;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
