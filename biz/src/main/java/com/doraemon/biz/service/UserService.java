package com.doraemon.biz.service;

import com.doraemon.data.gen.tables.pojos.User;

/**
 * @author wl
 */
public interface UserService {
  User getByName(String username);
}
