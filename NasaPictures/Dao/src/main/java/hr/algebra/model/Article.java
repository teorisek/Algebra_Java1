/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.algebra.model;

/**
 *
 * @author trisek
 */
public final class Article {

    private int id;
    private String title;
    private String link;
    private String description;
    private String picturePath;
    private String category;

    public Article() {
    }
    
    public Article(String title, String link, String description, String picturePath, String category) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.picturePath = picturePath;
        this.category = category;
    }
    
    public Article(int id, String title, String link, String description, String picturePath, String category) {
        this(title, link, description, picturePath, category);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getCategory() {
        return category;
    }



    @Override
    public String toString() {
        return id + " - " + title;
    }
    
}

