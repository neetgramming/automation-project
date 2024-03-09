package com.neetgramming.data;

import java.util.List;

public class Pet {
    private long id;
    private String name;
    private String status;
    private List<String> tags;

    public Pet(String name, String status, List<String> tags) {
        this.name = name;
        this.status = status;
        this.tags = tags;
    }

    public Pet(long id, String name, String status, List<String> tags) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}