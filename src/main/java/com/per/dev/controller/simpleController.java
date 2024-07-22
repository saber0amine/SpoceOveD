package com.per.dev.controller;


import com.per.dev.model.User;
import com.per.dev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class simpleController {

    @Autowired
    private UserRepository userRepository  ;
@GetMapping("/hello")
public String sayHello() {
    return "Welcome !";
}

@PostMapping("/addUser")
public String addUser(@RequestBody User user){
      userRepository.save(user)   ;
      return "User added successfully";
    }




}
