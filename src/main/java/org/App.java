package org;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    @Autowired
    private CustomerRepository repository;

    public App(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getGreeting() {
        Customer mark = new Customer("Mark", "Davids");
        repository.save(mark);
        Iterable<Customer> customers = repository.findAll();
        return customers.toString();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        App app = context.getBean(App.class);
        System.out.println(app.getGreeting());
    }
}
