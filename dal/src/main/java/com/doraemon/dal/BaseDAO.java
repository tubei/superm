package com.doraemon.dal;


import org.jooq.DAO;
import org.jooq.TableRecord;
import org.jooq.UpdatableRecord;

/**
 * @author wl
 */
public interface BaseDAO<R extends UpdatableRecord<R>, P, T> extends DAO<R, P, T> {
}
