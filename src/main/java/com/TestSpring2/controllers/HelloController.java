package com.TestSpring2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  
  @GetMapping("/")
  public String hello() {
    return "Hello!";
  }
  
  @PostMapping("/")
  public String helloName(@RequestBody String name) {
    return "Hello " + name + "!";
  }
}
