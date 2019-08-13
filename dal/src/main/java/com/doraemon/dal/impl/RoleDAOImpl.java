package com.doraemon.dal.impl;

import com.doraemon.dal.RoleDAO;
import com.doraemon.data.gen.Tables;
import com.doraemon.data.gen.tables.pojos.Role;
import com.doraemon.data.gen.tables.records.RoleRecord;
import org.jooq.Configuration;
import org.jooq.Table;
import org.springframework.stereotype.Repository;

/**
 * @author tubei
 */
@Repository
public class RoleDAOImpl extends BaseDAOImpl<RoleRecord, Role, Integer> implements RoleDAO {


  protected RoleDAOImpl(Configuration configuration) {
    super(Tables.ROLE, Role.class, configuration);
  }

  @Override
  protected Integer getId(Role object) {
    return object.getId();
  }
}
