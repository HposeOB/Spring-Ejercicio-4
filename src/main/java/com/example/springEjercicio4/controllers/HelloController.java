package com.example.springEjercicio4.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${app.message}")
    String message;
    @GetMapping("/hola")
    public String saludo(){
        System.out.println(message);
        return "Hola mundo!!!!!";
    }


}
