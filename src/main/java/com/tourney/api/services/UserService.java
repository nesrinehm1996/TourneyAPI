package com.tourney.api.services;

import com.tourney.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourney.api.repositories.UserRepository;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User get(User u){ return userRepository.findByEmail(u.getEmail()).get();}

    public void create(User u) {
        userRepository.save(u);
    }

    public boolean login(User u){
        boolean succes;

        User dbUser = get(u);

        if(u.getEmail() == dbUser.getEmail() && u.getPassword() == dbUser.getPassword()){
            succes = true;
        }
        else {
            succes = false;
        }

        return succes;
    }
}
