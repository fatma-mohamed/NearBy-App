package com.example.nearby.data.model;

public class Category {
    public String name;
    public String crossStreet;
    public Icon icon;

    public Category(String name, String crossStreet, Icon icon) {
        this.name = name;
        this.crossStreet = crossStreet;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
