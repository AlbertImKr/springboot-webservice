package com.springbootwebservice.web;


import com.springbootwebservice.web.dto.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponse helloDto(String name, int amount) {
        return new HelloResponse(name, amount);
    }
}
