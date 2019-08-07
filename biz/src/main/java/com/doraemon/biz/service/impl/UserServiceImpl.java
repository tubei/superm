package com.doraemon.biz.service.impl;

import com.doraemon.dal.impl.UserDAO;
import com.doraemon.data.gen.tables.pojos.User;
import com.doraemon.biz.service.UserService;
import org.springframework.stereotype.Service;

import static com.doraemon.data.gen.Tables.USER;

/**
 * @author wl
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserDAO userDAO;

  public UserServiceImpl(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  @Override
  public User getByName(String username) {
    return userDAO.fetchOne(USER.USERNAME, username);
  }
}
