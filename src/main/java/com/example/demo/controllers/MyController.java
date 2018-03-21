package com.example.demo.controllers;

import com.example.demo.model.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {


    @Autowired
    private SessionFactory sessionFactory;

    @GetMapping("/")
    public String getList(){
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
        try {
            Test abstractEntity = new Test();
//		abstractEntity.setAdded(new Date().toString());
//		abstractEntity.setModified(new Date().toString());
            session.save(abstractEntity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return "index";
    }
}
