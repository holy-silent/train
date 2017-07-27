package com.unicom.model;

public class Coure {
    private String id;
    private String name;

    public Coure() {
    }

    public Coure(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Coure(String name) {
        this.name = name;
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
}
