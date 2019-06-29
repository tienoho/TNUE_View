package com.sad.utils;

public class InfoBean {

    private String title,author,imprint,year;

    public InfoBean(String title, String author, String imprint, String year) {
        this.title = title;
        this.author = author;
        this.imprint = imprint;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImprint() {
        return imprint;
    }

    public void setImprint(String imprint) {
        this.imprint = imprint;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
