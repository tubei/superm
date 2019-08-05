package com.doraemon.api;

import com.doraemon.service.HelloService;
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

  @Resource
  private HelloService helloService;

  @GetMapping("/hello/world")
  public String helloWorld() {
    System.out.println(222222);
    return helloService.helloWorld();
  }
}
