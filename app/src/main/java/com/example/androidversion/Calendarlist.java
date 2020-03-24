package com.example.androidversion;

public class Calendarlist {
    private String title;           //일정이름
    private String time;            //시간
    private String regist;          //등록인
    private String participant;     //참가대상
    private String detail;          //설명(시간대와 무슨 일정인지에 대한 간략한 사항)

    public Calendarlist(String title, String time, String regist, String participant, String detail){
        this.title=title;
        this.time=time;
        this.regist=regist;
        this.participant=participant;
        this.detail=detail;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getRegist() {
        return regist;
    }

    public String getParticipant() {
        return participant;
    }

    public String getDetail() {
        return detail;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setRegist(String regist) {
        this.regist = regist;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}