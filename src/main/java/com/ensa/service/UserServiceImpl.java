package com.ensa.service;

import com.ensa.model.Note;
import com.ensa.model.User;
import com.ensa.repository.NoteRepository;
import com.ensa.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private NoteRepository noteRepository;


    @Override
    public User createUser(String imageUrl, String email) {
        User user = new User(email, imageUrl);
        if(userRepository.findByemailLike(email) == null) {
            return userRepository.save(user);
        }else {
            return null;
        }
    }

    @Override
    public User addNote(String email, String title, String content) {
        User user = userRepository.findByemailLike(email);

        if(user == null)
            return null;

        Note note = new Note(title,content);
        note = noteRepository.save(note);
        user.addNote(note);
        return userRepository.save(user);
    }

    @Override
    public User getUser(String email) {
       return  userRepository.findByemailLike(email);
    }

    @Override
    public void deleteUser(String email) {
        User user  = userRepository.findByemailLike(email);
        userRepository.delete(user);
    }
}
