package com.example.demo.controllers;

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

    @GetMapping("/index")
    public String getList(){
        String string = requestScopedBean.toString();
        return "index";
    }

    @GetMapping("/i")
    public String gett() {
        String s = requestScopedBean.toString();
        return "index";
    }
}
