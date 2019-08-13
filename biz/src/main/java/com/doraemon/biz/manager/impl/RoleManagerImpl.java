package com.doraemon.biz.manager.impl;

import com.doraemon.biz.manager.RoleManager;
import com.doraemon.dal.RoleDAO;
import com.doraemon.dal.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tubei
 */
@Component
public class RoleManagerImpl implements RoleManager {

  private final RoleDAO roleDAO;

  private final UserRoleDAO userRoleDAO;

  public RoleManagerImpl(RoleDAO roleDAO, UserRoleDAO userRoleDAO) {
    this.roleDAO = roleDAO;
    this.userRoleDAO = userRoleDAO;
  }

  @Transactional(rollbackFor = Exception.class)
  @Override
  public void delete(Integer id) {
    roleDAO.deleteById(id);
    userRoleDAO.deleteByRoleId(id);
  }
}
