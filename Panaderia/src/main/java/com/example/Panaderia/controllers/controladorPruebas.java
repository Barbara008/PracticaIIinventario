package com.example.Panaderia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controladorPruebas {
    @GetMapping(value = "/")
    public String index(Model model){
        String saludo= "Hola mundo, estoy probando thymeleaf";
        model.addAttribute("saludo", saludo);
        return "index";
    }
}
