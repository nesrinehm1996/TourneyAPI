package com.tourney.api.controllers;

import com.tourney.api.models.User;
import com.tourney.api.viewmodels.LoginVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tourney.api.services.UserService;
import com.tourney.api.viewmodels.UserVM;

import java.util.UUID;

// TODO: 17/09/2019 Use VPN connection to connect database!!!!!!!!!!!!!!!!!!!!
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService service;

    @RequestMapping("")
    public String index(){
        return "Deze URL's zijn beschikbaar: /getUser , /addUser , /login , /createTournament";
    }

    @PostMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestBody UserVM getUser) {
        User user = setUser(getUser);
        service.get(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody UserVM addUser){
        User user = setUser(addUser);
        service.create(user);
        return ResponseEntity.ok().body("User added");
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserVM loginUser){

        User user = new User(loginUser.getEmail(), loginUser.getPassword());

        boolean succes = service.login(user);

        if(succes){
//            final String uuid = UUID.randomUUID().toString().replace("-", "");
//            user.setToken(uuid);
            user.setToken("qwerty");
            return ResponseEntity.ok().body(user);
        }
        else {
            user = null;
            return ResponseEntity.status(401).body(user);
        }
    }

    private User setUser(UserVM user){
        User entityUser = new User();
        try{
            entityUser.setEmail(user.getEmail());
            entityUser.setPassword(user.getPassword());
            entityUser.setFirstName(user.getFirstName());
            entityUser.setLastName(user.getLastName());
            entityUser.setAge(user.getAge());
            entityUser.setToken(user.getToken());
        }
        catch(Exception ex){
            throw ex;
        }
        return entityUser;
    }
}
