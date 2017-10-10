package com.ncopado.petagram.pojo;

/**
 * Created by ncopado on 25/09/17.
 */

public class PetApi {

    private  int Id;
    private  String IdInstagram;
    private  String Name;
    private  int Reiting;
    private  int Photo;
    private  String UrlPhoto;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getPhoto() {
        return Photo;
    }

    public String getIdInstagram() {
        return IdInstagram;
    }

    public void setIdInstagram(String idInstagram) {
        IdInstagram = idInstagram;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public String getUrlPhoto() {
        return UrlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        UrlPhoto = urlPhoto;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getReiting() {
        return Reiting;
    }

    public void setReiting(int reiting) {
        Reiting = reiting;
    }



/*public Pet(String name, int reiting, s photo) {
        Name = name;
        Reiting = reiting;
        Photo = photo;
    }*/



}
