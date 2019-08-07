package com.doraemon.dal.impl;

import com.doraemon.dal.BaseDAO;
import com.doraemon.data.tables.pojos.User;
import com.doraemon.data.tables.records.UserRecord;

/**
 * @author wl
 */
public interface UserDAO extends BaseDAO<UserRecord, User, Integer> {
}
