package com.example.demo;

import com.example.demo.model.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.ServletContextApplicationContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
			public SessionFactory sessionFactory() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Test.class);
//		configuration.addAnnotatedClass(TwoWheeler.class);
//		configuration.addAnnotatedClass(FourWheeler.class);
		configuration.configure();
		StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties())
				.build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

	@Bean
    public Object object(SessionFactory sessionFactory){
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        session.save(new Test());
        transaction.commit();
        return new Object();
    }

}
