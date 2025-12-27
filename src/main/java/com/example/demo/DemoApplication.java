package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;
import org.springframework.boot.web.context.WebServerInitializedEvent;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @EventListener
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("✅ Application running on port: " + event.getWebServer().getPort());
    }
}
