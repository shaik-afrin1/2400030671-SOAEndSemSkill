package com.example.driver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Value("${server.port}")
    private String port;

    @GetMapping
    public String getDrivers() {
        System.out.println("Request received by Driver Service on port: " + port);
        return "Driver Service running on port: " + port;
    }
}
