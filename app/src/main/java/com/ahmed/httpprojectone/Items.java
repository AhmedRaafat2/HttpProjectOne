package com.ahmed.httpprojectone;

public class Items  {

    private  int image_id;
    private  String name,like;

    public Items(int image_id, String name, String like) {
        this.image_id = image_id;
        this.name = name;
        this.like = like;
    }

    public int getImage_id() {
        return image_id;
    }

    public String getName() {
        return name;
    }

    public String getLike() {
        return like;
    }
}
