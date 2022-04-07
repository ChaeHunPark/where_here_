package com.tutorial2.where_here.Adapter;

public class List_Reco {
    private String image;
    private String title;
    private String rating;


    public List_Reco(String image, String title, String rating) {
        this.image = image;
        this.title = title;
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) { this.image = image; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }
}