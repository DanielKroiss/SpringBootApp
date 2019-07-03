package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired //Dependency Injection
    public UserRepository repository;

    @GetMapping(value = "/users", produces = "application/json") //convert List to JSON
    @ResponseBody
    public List<User> getUsers(@RequestParam(value = "firstName", required = false) String firstName){ //can be null if required is false
        List<User> users = new ArrayList<>();

        if(firstName == null){
            repository.findAll().forEach(users::add); //add all users to list
        } else {
            repository.findByFirstName(firstName).forEach(users::add);
        }

        return users;
    }
    @PostMapping(value = "/users", produces = "application/json") //convert List to JSON
    public ResponseEntity setUser(@RequestBody User user){ //get information from requestbody
        repository.save(user);
        return ResponseEntity.ok().build(); //204 no content
    }

    @PutMapping(path = "users", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public User updateUser(@RequestBody User user)  {
        return repository.save(user);
    }

    @DeleteMapping(path = "users/{userId}", produces = "application/json")
    public ResponseEntity deleteUser(@PathVariable Long userId) {
        repository.deleteById(userId);
        return ResponseEntity.ok().build();
    }

}


