package com.campaingup.memu.entity;

import javax.persistence.*;

@Entity
@Table(name = "Device")
public class Device {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String guid;

    @Column
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
