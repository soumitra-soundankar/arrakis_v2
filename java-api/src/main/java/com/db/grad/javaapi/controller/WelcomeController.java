package com.db.grad.javaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

  @GetMapping("/")
  public String getWelcome() {
    return "All APIs are Up and Running.";
  }

}
