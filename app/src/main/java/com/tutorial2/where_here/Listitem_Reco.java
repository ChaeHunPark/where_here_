package com.tutorial2.where_here;

public class Listitem_Reco {
    private String title;
    private String intro;

    public Listitem_Reco(String title, String intro){
        this.title = title;
        this.intro = intro;
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
}
