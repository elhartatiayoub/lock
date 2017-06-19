package com.ensa.controller;

import com.ensa.model.User;
import com.ensa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class ApplicationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method=POST)
    public ResponseEntity<User> createUser(@RequestParam("email") String email, @RequestParam("imageUrl") String imageUrl){
        User user = userService.createUser(imageUrl,email);
        if (user == null){
            return new ResponseEntity<>(UNAUTHORIZED);
        }
        return new ResponseEntity<>(user, OK);
    }

    @RequestMapping(value = "/get", method=GET)
    public ResponseEntity<User> getUser(@RequestParam("email") String email){
        User user =  userService.getUser(email);
        if (user == null){
            return new ResponseEntity<>(UNAUTHORIZED);
        }
        return new ResponseEntity<>(user, OK);
    }

    @RequestMapping(value = "/addNote", method=POST)
    public ResponseEntity<User> addNote(@RequestParam("email") String email, @RequestParam("title") String title, @RequestParam("content") String content){
        User user = userService.addNote(email,title,content);
        if( user == null){
            return new ResponseEntity<>(UNAUTHORIZED);
        }
        return new ResponseEntity<>(user, OK);
    }

    @RequestMapping(value= "/delete", method = DELETE)
    public ResponseEntity deleteUser(@RequestParam("email") String email){
        userService.deleteUser(email);
        return new ResponseEntity(OK);
    }
}
