package com.javamultiplex.model;

/**
 * @author Rohit Agarwal on 21/01/21 7:21 pm
 * @copyright www.javamultiplex.com
 */
public class Provider {
    private int id;
    private String name;

    public Provider() {
    }

    public Provider(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
