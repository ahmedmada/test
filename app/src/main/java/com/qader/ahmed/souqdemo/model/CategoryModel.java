package com.qader.ahmed.souqdemo.model;

/**
 * Created by Ahmed AbdElQader on 24-Jun-18.
 */

public class CategoryModel {

    int id,parent;
    String name,image;

    public CategoryModel(int id, int parent, String name, String image) {
        this.id = id;
        this.parent = parent;
        this.name = name;
        this.image = image;
    }

    public CategoryModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
