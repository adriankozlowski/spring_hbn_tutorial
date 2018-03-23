package com.example.demo.controllers;

import com.example.demo.classes.PrototypeClass;
import com.example.demo.classes.RequestScopedBean;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyOtherController {


    @Autowired
    RequestScopedBean requestScopedBean;
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private PrototypeClass prototypeClass;


    @GetMapping("/index2")
    public String getList() {
        String name = prototypeClass.getName();
        System.out.println(name);
        String string = requestScopedBean.toString();
        return "index";
    }

}
