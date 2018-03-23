package com.example.demo.controllers;

import com.example.demo.classes.PrototypeClass;
import com.example.demo.classes.RequestScopedBean;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {


    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    RequestScopedBean requestScopedBean;
    @Autowired
    private PrototypeClass prototypeClass;


    @GetMapping("/index")
    public String getList(){
        String name = prototypeClass.getName();
        prototypeClass.setName("jakis name");
        System.out.println(name);
        String string = requestScopedBean.toString();
        return "index";
    }

    @GetMapping("/i")
    public String gett() {
        String name = prototypeClass.getName();
        System.out.println(name);
        String s = requestScopedBean.toString();
        return "index";
    }
}
