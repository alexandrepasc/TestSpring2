package com.TestSpring2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
  
  @GetMapping("/var/{name}")
  public String helloParamName(@PathVariable("name") String name) {
    return "Hello var " + name + "!";
  }
  
  @GetMapping("/param")
  public String helloVarName(@RequestParam(value = "name", required = false, defaultValue = "burro") String name) {
    return "Hello param " + name + "!";
  }
}
