package com.doraemon.api.controller;

import com.doraemon.api.vo.ApiResult;
import com.doraemon.data.gen.tables.pojos.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping
  public ApiResult<?> getSession(){
    Subject subject = SecurityUtils.getSubject();
    Object principal = subject.getPrincipal();
    return new ApiResult<>(principal);
  }

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

  /**
   * delete session to login out
   */
  @DeleteMapping
  @RequiresAuthentication
  public ApiResult<?> delete() {
    Subject subject = SecurityUtils.getSubject();
    if (subject.isAuthenticated()) {
      subject.logout();
    }
    return ApiResult.ok();
  }
}
