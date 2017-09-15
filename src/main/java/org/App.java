package org;

import com.netflix.servo.monitor.Counter;
import com.netflix.servo.monitor.Monitors;
import com.netflix.servo.monitor.Stopwatch;
import com.netflix.servo.monitor.Timer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {

    @Autowired
    private CustomerRepository repository;

    private final Counter createdCusomers = Monitors.newCounter("createdCustomers");

    public App(CustomerRepository repository) {
        this.repository = repository;
    }

    public String getGreeting() {
        Customer mark = new Customer("Mark", "Davids");
        repository.save(mark);
        createdCusomers.increment();
        Iterable<Customer> customers = repository.findAll();
        return customers.toString();
    }

    public static void main(String[] args) {
        Timer latency = Monitors.newTimer("latency");
        Stopwatch stopwatch = latency.start();
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        App app = context.getBean(App.class);
        Logger log = context.getBean(Logger.class);
        log.info(app.getGreeting());
        stopwatch.stop();
    }
}
