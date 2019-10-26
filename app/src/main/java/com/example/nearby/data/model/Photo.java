package com.example.nearby.data.model;

public class Photo {
    public String suffix;
    public String prefix;
    public Integer width;
    public Integer height;

    public Photo(String suffix, String prefix, Integer width, Integer height) {
        this.suffix = suffix;
        this.prefix = prefix;
        this.width = width;
        this.height = height;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPhotoUrl() {
        return prefix + width + 'x' + height + suffix;
    }
}
