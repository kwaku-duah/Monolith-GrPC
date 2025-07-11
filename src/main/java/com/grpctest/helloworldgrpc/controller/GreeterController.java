package com.grpctest.helloworldgrpc.controller;

import com.grpctest.helloworldgrpc.client.GreeterClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreeterController {
    private final GreeterClient greeterClient;

    public GreeterController(GreeterClient greeterClient) {
        this.greeterClient = greeterClient;
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return greeterClient.sayHello(name);
    }
}
