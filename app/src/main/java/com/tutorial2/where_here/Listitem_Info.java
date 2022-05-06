package com.tutorial2.where_here;

import android.graphics.drawable.Drawable;

public class Listitem_Info {
    private String title;
    private String intro;
    private int images;

    public Listitem_Info(String title, String intro, int images){
        this.title = title;
        this.intro = intro;
        this.images = images;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }
}
