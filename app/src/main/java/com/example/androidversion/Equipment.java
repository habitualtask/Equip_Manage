package com.example.androidversion;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Equipment {
    private String list_title;          //제품이름
    private String list_date;           //구매날짜
    private Integer list_image;         //제품사진
    private String list_price;          //구매가격
    private String list_serial;         //시리얼넘버
    private String list_company;        //제조사
    private String list_category;       //분류(장비,도서,기타)
    private String list_remark;         //비고
    private String list_state;          //대여상태(반남,연체,가능,불가,대여중)
    private String list_rent;           //대여일
    private String list_return;         //반납예정일
    private String list_dday;           //디데이

    public Equipment(Integer list_image,String list_title,String list_state,String list_rent,String list_return,String list_dday,String list_category,String list_company,String list_serial,String list_date,String list_price,String list_remark){
        this.list_image=list_image;
        this.list_title=list_title;
        this.list_state=list_state;
        this.list_category=list_category;
        this.list_company=list_company;
        this.list_serial=list_serial;
        this.list_date=list_date;
        this.list_price=list_price;
        this.list_remark=list_remark;
        this.list_rent=list_rent;
        this.list_return=list_return;
        this.list_dday=list_dday;
    }
    public Integer getList_image() {
        return list_image;
    }
    public String getList_title(){
        return list_title;
    }
    public String getList_state(){
        return list_state;
    }
    public String getList_date(){
        return list_date;
    }
    public String getList_price() {
        return list_price;
    }
    public String getList_serial() {
        return list_serial;
    }
    public String getList_company() {
        return list_company;
    }
    public String getList_category() {
        return list_category;
    }
    public String getList_remark() {
        return list_remark;
    }
    public String getList_rent(){
        return list_rent;
    }
    public String getList_return() {
        return list_return;
    }
    public String getList_dday() {
        return list_dday;
    }

    public void setList_category(String list_category) {
        this.list_category = list_category;
    }
    public void setList_company(String list_company) {
        this.list_company = list_company;
    }
    public void setList_state(String list_state) {
        this.list_state = list_state;
    }
    public void setList_price(String list_price) {
        this.list_price = list_price;
    }
    public void setList_serial(String list_serial) {
        this.list_serial = list_serial;
    }
    public void setList_image(Integer list_image){
        this.list_image=list_image;
    }
    public void setList_title(String list_title){
        this.list_title=list_title;
    }
    public void setList_date(String list_date) {
        this.list_date = list_date;
    }
    public void setList_remark(String list_remark) {
        this.list_remark = list_remark;
    }
    public void setList_rent(String list_rent) {
        this.list_rent = list_rent;
    }
    public void setList_return(String list_return) {
        this.list_return = list_return;
    }
    public void setList_dday(String list_dday) {
        this.list_dday = list_dday;
    }
}