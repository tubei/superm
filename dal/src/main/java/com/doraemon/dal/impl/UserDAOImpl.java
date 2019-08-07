package com.doraemon.dal.impl;

import com.doraemon.data.gen.Tables;
import com.doraemon.data.gen.tables.pojos.User;
import com.doraemon.data.gen.tables.records.UserRecord;
import org.jooq.Configuration;
import org.jooq.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author wl
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<UserRecord, User, Integer> implements UserDAO {

  @Autowired
  public UserDAOImpl(Configuration configuration) {
    super(Tables.USER, User.class, configuration);
  }

  @Override
  protected Integer getId(User object) {
    return object.getId();
  }
}
