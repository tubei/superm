package com.doraemon.dal.impl;

import com.doraemon.dal.BaseDAO;
import com.doraemon.data.gen.tables.pojos.User;
import com.doraemon.data.gen.tables.records.UserRecord;

/**
 * @author wl
 */
public interface UserDAO extends BaseDAO<UserRecord, User, Integer> {
  /**
   * @param username phone number or email, unique
   * @return user pojo
   */
  User fetchByUsername(String username);
}
