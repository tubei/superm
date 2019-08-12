package com.doraemon.api.controller;

import com.doraemon.biz.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wl
 */
@RestController
@RequestMapping("/api")
public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping("/hello/world")
  public String helloWorld() {
    System.out.println(222222);
    return helloService.helloWorld();
  }
}
