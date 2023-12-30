package com.example.tes1sanpham;

public class Product {
    private int id;
    private String name;
    private String image;
    private float price;

    public Product(int id, String name, String image, float price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }
    public Product(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
