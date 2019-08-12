package com.doraemon.api.controller;

import com.doraemon.common.crypto.BCrypt;
import com.doraemon.dal.impl.UserDAO;
import com.doraemon.data.gen.tables.pojos.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.doraemon.api.vo.ApiResult;
/**
 * @author tubei
 */
@RestController
@RequestMapping("/user")
public class UserController {

  private final UserDAO userDAO;

  public UserController(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @PostMapping
  public ApiResult<?> register(@RequestParam String username, @RequestParam String password) {
    String gensalt = BCrypt.gensalt();
    String encodedPassword = BCrypt.hashpw(password, gensalt);
    User user = new User();
    user.setUsername(username).setPassword(encodedPassword);
    userDAO.insert(user);
    return ApiResult.ok();
  }
}
