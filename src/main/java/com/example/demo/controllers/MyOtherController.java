package com.example.demo.controllers;

import com.example.demo.classes.SessionClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyOtherController {


    @Autowired
    private SessionClass sessionClass;


    @GetMapping("/index2")
    public String getList() {
        sessionClass.setCounter(sessionClass.getCounter() + 1);
        System.out.println(sessionClass.getCounter());
        return "index";
    }

}
