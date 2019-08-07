package com.doraemon.service.impl;

import com.doraemon.dal.impl.UserDAO;
import com.doraemon.dal.impl.UserDAOImpl;
import com.doraemon.data.gen.Tables;
import com.doraemon.data.gen.tables.pojos.User;
import com.doraemon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
