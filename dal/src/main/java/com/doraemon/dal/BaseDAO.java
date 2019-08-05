package com.doraemon.dal;


import org.jooq.DAO;
import org.jooq.TableRecord;

/**
 * @author wl
 */
public interface BaseDAO<R extends TableRecord<R>, P, T> extends DAO {
}
