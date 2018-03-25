package com.example.demo.controllers;

import com.example.demo.model.Person;
import com.example.demo.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public String greetings(ModelMap map) {
        map.addAttribute("greeting", helloService.greetings());
        return "hello";
    }

    @PostMapping("/hello")
    @ResponseBody
    public Person submitForm(@ModelAttribute Person person) {

        return person;
    }
}
