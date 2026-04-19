package com.example.model;

public class tasks {
    private int id;
    private String name;
    private boolean isDone;

    public tasks(int id,String name, boolean isDone){
        this.id = id;
        this.name = name;
        this.isDone = isDone;
    }
    public int getId() {
        return id;
    }
    public void getDone(boolean isDone) {
        this.isDone = isDone;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
}
