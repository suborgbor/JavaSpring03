package com.example.users_app.controllers;

import com.example.users_app.domain.User;
import com.example.users_app.services.DataProcessingService;
import com.example.users_app.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() { return service.getDataProcessingService().getRepository().getUsers(); }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user)
    {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    @PostMapping("/param")
    public String userAddFromParam(@RequestParam(required = false) String name,
                                   @RequestParam(required = false) int age,
                                   @RequestParam(required = false) String email)
    {
        service.processRegistration(name,age,email);
        return "User added from param!";
    }
}
