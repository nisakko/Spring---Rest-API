package com.example.api.models;

import java.util.ArrayList;
import java.util.List;

public class Bestseller {

    private String userId;
    private ArrayList<String> productIds = new ArrayList<>();
    private String personalizedType;

    public Bestseller(){

    }

    public Bestseller(String userId, ArrayList<String> productIds, String personalizedType) {
        this.userId = userId;
        this.productIds = productIds;
        this.personalizedType = personalizedType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getProductIds() {
        return productIds;
    }

    public void setProductIds(ArrayList<String> productIds) {
        this.productIds = productIds;
    }

    public String getPersonalizedType() {
        return personalizedType;
    }

    public void setPersonalizedType(String personalizedType) {
        this.personalizedType = personalizedType;
    }
}
