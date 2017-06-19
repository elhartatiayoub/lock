package com.ensa.service;

import com.ensa.model.User;

public interface UserService {

    User createUser(String imageUrl, String email);

    User addNote(String email, String title, String content);

    User getUser(String email);

    void deleteUser(String email);
}
