package com.unicom.model;

public class CoureSel {
    private String id;
    private String name;
    private String status;

    public CoureSel() {
    }

    public CoureSel(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public CoureSel(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
