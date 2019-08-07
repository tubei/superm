/*
 * This file is generated by jOOQ.
 */
package com.doraemon.data.gen.tables.records;


import com.doraemon.data.gen.tables.TroleResource;

import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.TableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RoleResourceRecord extends TableRecordImpl<RoleResourceRecord> implements Record4<Integer, Integer, LocalDateTime, LocalDateTime> {

    private static final long serialVersionUID = 622266904;

    /**
     * Setter for <code>superm.role_resource.role_id</code>. role id
     */
    public RoleResourceRecord setRoleId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>superm.role_resource.role_id</code>. role id
     */
    public Integer getRoleId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>superm.role_resource.resource_id</code>. resource id
     */
    public RoleResourceRecord setResourceId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>superm.role_resource.resource_id</code>. resource id
     */
    public Integer getResourceId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>superm.role_resource.create_time</code>. 创建时间
     */
    public RoleResourceRecord setCreateTime(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>superm.role_resource.create_time</code>. 创建时间
     */
    public LocalDateTime getCreateTime() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>superm.role_resource.update_time</code>. 更新时间
     */
    public RoleResourceRecord setUpdateTime(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>superm.role_resource.update_time</code>. 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row4<Integer, Integer, LocalDateTime, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return TroleResource.ROLE_RESOURCE.ROLE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return TroleResource.ROLE_RESOURCE.RESOURCE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field3() {
        return TroleResource.ROLE_RESOURCE.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<LocalDateTime> field4() {
        return TroleResource.ROLE_RESOURCE.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getRoleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getResourceId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component3() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime component4() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getRoleId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getResourceId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value3() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime value4() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleResourceRecord value1(Integer value) {
        setRoleId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleResourceRecord value2(Integer value) {
        setResourceId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleResourceRecord value3(LocalDateTime value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleResourceRecord value4(LocalDateTime value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RoleResourceRecord values(Integer value1, Integer value2, LocalDateTime value3, LocalDateTime value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RoleResourceRecord
     */
    public RoleResourceRecord() {
        super(TroleResource.ROLE_RESOURCE);
    }

    /**
     * Create a detached, initialised RoleResourceRecord
     */
    public RoleResourceRecord(Integer roleId, Integer resourceId, LocalDateTime createTime, LocalDateTime updateTime) {
        super(TroleResource.ROLE_RESOURCE);

        set(0, roleId);
        set(1, resourceId);
        set(2, createTime);
        set(3, updateTime);
    }
}
