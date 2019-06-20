package com.campaingup.memu.object;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Device {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    private String guid;
    private String time;

    public Device() {

    }

    public Device(int id, String guid, String time) {
        this.id = id;
        this.guid = guid;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getGuid() {
        return guid;
    }

    public String getTime() {
        return time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }




}
