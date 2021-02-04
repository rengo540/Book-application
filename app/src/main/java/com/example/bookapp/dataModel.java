package com.example.bookapp;

import java.util.ArrayList;

public class dataModel {
     String  img ;
     String name ;
     //String [] Authar ;
     String description;
     String publisher ;
     String publishedDate;
     int pageCount ;
     String  authar;
     float rating;

public dataModel (){}
    public dataModel(String img, String name ,String  authar,String description,float rating) {
        this.img = img;
        this.name = name;
        this.authar = authar;
        this.publisher=publisher;
        this.description=description;
        this.rating=rating;

    }

    public dataModel(String img, String name ,String  authar,String description) {
        this.img = img;
        this.name = name;
        this.authar = authar;
        this.publisher=publisher;
        this.description=description;
    }


    public dataModel(String description) {
        this.description=description;

    }


    public dataModel(String img, String name, String description, String publisher, String publishedDate, int pageCount, String authar) {
        this.img = img;
        this.name = name;
        this.description = description;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.pageCount = pageCount;
        this.authar = authar;
    }

    public float getRating() {
        return rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setAuthar(String authar) {
        this.authar = authar;
    }

    public String getAuthar() {
        return authar;
    }

    public String getDescription() {
        return description;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

}

