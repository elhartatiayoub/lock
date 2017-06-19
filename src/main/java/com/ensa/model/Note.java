package com.ensa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Note implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note() {
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
