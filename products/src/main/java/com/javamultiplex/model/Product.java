package com.javamultiplex.model;

/**
 * @author Rohit Agarwal on 21/01/21 7:13 pm
 * @copyright www.javamultiplex.com
 */
public class Product {
    private int id;
    private String name;
    private Provider provider;
    private int providerId;

    public Product() {
    }

    public Product(int id, String name, int providerId) {
        this.id = id;
        this.name = name;
        this.providerId = providerId;
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }
}
