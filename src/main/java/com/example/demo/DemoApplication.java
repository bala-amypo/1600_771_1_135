package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DemoApplication.class);

        Map<String, Object> props = new HashMap<>();
        props.put("server.port", "9002"); // change port here
        app.setDefaultProperties(props);

        app.run(args);
    }
}
