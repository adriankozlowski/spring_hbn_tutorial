package com.example.demo;

import com.example.demo.classes.PrototypeClass;
import com.example.demo.classes.RequestScopedBean;
import com.example.demo.model.Test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.context.WebApplicationContext;

import javax.sql.DataSource;
import java.util.Properties;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;


@SpringBootApplication
//@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.99.100:3306/inheritance?createDatabaseIfNotExist=true");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.example.demo.model" });
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put(AvailableSettings.SHOW_SQL, "true");
        properties.put(AvailableSettings.STATEMENT_BATCH_SIZE, "20");
        properties.put(AvailableSettings.HBM2DDL_AUTO, "create");
        properties.put(AvailableSettings.CURRENT_SESSION_CONTEXT_CLASS, "org.springframework.orm.hibernate5.SpringSessionContext");
        return properties;
    }

//    @Bean
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//        return txManager;
//    }


    @Bean
    public Object object(SessionFactory sessionFactory) {
        final Session currentSession = sessionFactory.openSession();
        final Test test = new Test();
        test.setName("Asdfasdf");
        currentSession.save(test);
        return new Object();
    }

    @Bean()
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RequestScopedBean getRequestScopedBean() {
        return new RequestScopedBean();
    }

    @Bean
    @Scope(scopeName = SCOPE_PROTOTYPE)
    public PrototypeClass getPrototypeClass() {
        return new PrototypeClass();
    }
}
