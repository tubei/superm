package com.doraemon.service.impl;

import com.doraemon.dal.impl.UserDAO;
import com.doraemon.dal.impl.UserDAOImpl;
import com.doraemon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wl
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDAO userDAO;
}
