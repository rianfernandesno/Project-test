package com.yui.projectApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/usuarios")
    public ResponseEntity<String> exibe(){
        return ResponseEntity.ok().body("Hello");
    }
}
