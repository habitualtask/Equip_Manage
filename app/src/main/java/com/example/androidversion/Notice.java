package com.example.androidversion;

public class Notice {
    String notice;          //공지사항
    String name;            //등록인
    String date;            //등록날짜
    String content;         //등록내용

    public Notice(String notice,String name,String date,String content) {
        this.notice = notice;
        this.name = name;
        this.date = date;
        this.content = content;
    }
    public String getNotice() {
        return notice;
    }
    public void setNotice(String notice) {
        this.notice = notice;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
