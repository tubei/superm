package com.doraemon.dal.impl;

import com.doraemon.dal.UserRoleDAO;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.doraemon.data.gen.Tables.ROLE;
import static com.doraemon.data.gen.Tables.ROLE_RESOURCE;

/**
 * @author tubei
 */
@Repository
public class UserRoleDAOImpl implements UserRoleDAO {

  private final Configuration configuration;

  private final DSLContext dsl;

  public UserRoleDAOImpl(Configuration configuration) {
    this.configuration = configuration;
    this.dsl = configuration.dsl();
  }

  @Override
  public int deleteByRoleId(Integer roleId) {
    return dsl.deleteFrom(ROLE_RESOURCE)
        .where(ROLE_RESOURCE.ROLE_ID.eq(roleId))
        .execute();
  }
}
