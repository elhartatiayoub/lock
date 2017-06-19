package com.ensa.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String email;

    private String imageUrl;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Note> notes;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public User(String email, String imageUrl) {
        this.email = email;
        this.imageUrl = imageUrl;
        this.notes = new ArrayList<>();
    }

    public User() {
        notes = new ArrayList<>();
    }

    public void addNote(Note note){
        if (notes != null) {
            this.notes.add(note);
        } else {
            this.notes = new ArrayList<>();
            this.notes.add(note);
        }
    }
}
