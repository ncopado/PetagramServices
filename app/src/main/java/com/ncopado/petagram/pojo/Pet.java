package com.ncopado.petagram.pojo;

/**
 * Created by ncopado on 02/09/17.
 */

public class Pet {




    private  int Id;
    private  String IdInstagram;
    private  String Name;
    private  int Reiting;
    private  int Photo;
    private  String UrlPhoto;
    private  String UrlPhotoProfile;

    public String getUrlPhotoProfile() {
        return UrlPhotoProfile;
    }

    public void setUrlPhotoProfile(String urlPhotoProfile) {
        UrlPhotoProfile = urlPhotoProfile;
    }

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

    public Pet() {

    }

    public Pet(String name, int reiting, int photo) {
        Name = name;
        Reiting = reiting;
        Photo = photo;
    }

    public Pet(String name, int reiting, String photo,String profilePicture) {
        Name = name;
        Reiting = reiting;
        UrlPhoto = photo;
        UrlPhotoProfile=profilePicture;
    }


}
