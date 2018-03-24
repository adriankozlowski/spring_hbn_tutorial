package com.example.demo.controllers;

import com.example.demo.classes.SessionClass;
import com.example.demo.model.Test;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyController {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SessionClass sessionClass;


    @GetMapping("/index")
    public String getList(){

//        sessionClass.setCounter(sessionClass.getCounter() + 1);
        return "index";
    }

    @GetMapping("/i")
    public String gett() {
        sessionClass.setCounter(sessionClass.getCounter() + 1);
        return "index";
    }

    @PostMapping(value = "/add", produces = "application/json")
    @ResponseBody
    public Test add(@ModelAttribute Test test, @RequestParam("plik") MultipartFile file) {

        return test;
    }
}
