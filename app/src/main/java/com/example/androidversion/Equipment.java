package com.example.androidversion;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Equipment {
    private String list_title;
    private String list_desc;
    private Integer list_image;

    public Equipment(){}
    public Equipment(Integer list_image,String list_title, String list_desc){
        this.list_image=list_image;
        this.list_title=list_title;
        this.list_desc=list_desc;
    }

    public Integer getList_image() {
        return list_image;
    }

    public String getList_title(){
        return list_title;
    }
    public String getList_desc(){
        return list_desc;
    }

    public void setList_image(Integer list_image){
        this.list_image=list_image;
    }
    public void setList_title(String list_title){
        this.list_title=list_title;
    }
    public void setList_desc(String list_desc) {
        this.list_desc = list_desc;
    }
}