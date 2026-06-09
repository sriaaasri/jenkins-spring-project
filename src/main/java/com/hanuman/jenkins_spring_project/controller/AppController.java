package com.hanuman.jenkins_spring_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage(){
        return ResponseEntity.ok("Hi welcome to spring boot!");
    }

}
