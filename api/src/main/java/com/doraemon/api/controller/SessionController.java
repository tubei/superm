package com.doraemon.api.controller;

import com.doraemon.data.gen.tables.pojos.User;
import com.doraemon.api.vo.ApiResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 登录登出，抽象为对 session 资源的操作
 *
 * @author tubei
 */
@RestController
@RequestMapping("/session")
public class SessionController {

  @PostMapping
  @RequiresGuest
  public ApiResult<?> createSession(@RequestParam @Valid @NotNull String username,
                                    @RequestParam @Valid @NotNull String password) {
    UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
    Subject subject = SecurityUtils.getSubject();
    if (!subject.isAuthenticated()) {
      subject.login(token);
    }
    return new ApiResult<>((User) subject.getPrincipal());
  }
}
