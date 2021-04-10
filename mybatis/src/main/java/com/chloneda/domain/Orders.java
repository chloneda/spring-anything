package com.chloneda.domain;

import java.util.Date;

public class Orders {
    private int id;
    private String note;
    private Date dateTime;
    private String number;
    private int userId;

    public Orders(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", dateTime=" + dateTime +
                ", number='" + number + '\'' +
                ", userId=" + userId +
                '}';
    }
}
