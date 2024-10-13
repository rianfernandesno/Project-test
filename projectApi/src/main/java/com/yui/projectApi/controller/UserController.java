package com.yui.projectApi.controller;

import com.yui.projectApi.entities.User;
import com.yui.projectApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = service.save(user);
        return ResponseEntity.ok(newUser);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody  User updateUser){
        User user = service.update(id, updateUser);
        return ResponseEntity.ok(user);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
