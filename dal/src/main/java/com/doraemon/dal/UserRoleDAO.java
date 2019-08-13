package com.doraemon.dal;

/**
 * @author tubei
 */
public interface UserRoleDAO {
  /**
   * delete user_role relation by role id
   */
  int deleteByRoleId(Integer roleId);
}
