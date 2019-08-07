/*
 * This file is generated by jOOQ.
 */
package com.doraemon.data.gen.tables;


import com.doraemon.data.gen.Indexes;
import com.doraemon.data.gen.Keys;
import com.doraemon.data.gen.Superm;
import com.doraemon.data.gen.tables.records.RoleResourceRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class TroleResource extends TableImpl<RoleResourceRecord> {

    private static final long serialVersionUID = -2114054941;

    /**
     * The reference instance of <code>superm.role_resource</code>
     */
    public static final TroleResource ROLE_RESOURCE = new TroleResource();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RoleResourceRecord> getRecordType() {
        return RoleResourceRecord.class;
    }

    /**
     * The column <code>superm.role_resource.role_id</code>. role id
     */
    public final TableField<RoleResourceRecord, Integer> ROLE_ID = createField("role_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "role id");

    /**
     * The column <code>superm.role_resource.resource_id</code>. resource id
     */
    public final TableField<RoleResourceRecord, Integer> RESOURCE_ID = createField("resource_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "resource id");

    /**
     * The column <code>superm.role_resource.create_time</code>. 创建时间
     */
    public final TableField<RoleResourceRecord, LocalDateTime> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "创建时间");

    /**
     * The column <code>superm.role_resource.update_time</code>. 更新时间
     */
    public final TableField<RoleResourceRecord, LocalDateTime> UPDATE_TIME = createField("update_time", org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.LOCALDATETIME)), this, "更新时间");

    /**
     * Create a <code>superm.role_resource</code> table reference
     */
    public TroleResource() {
        this(DSL.name("role_resource"), null);
    }

    /**
     * Create an aliased <code>superm.role_resource</code> table reference
     */
    public TroleResource(String alias) {
        this(DSL.name(alias), ROLE_RESOURCE);
    }

    /**
     * Create an aliased <code>superm.role_resource</code> table reference
     */
    public TroleResource(Name alias) {
        this(alias, ROLE_RESOURCE);
    }

    private TroleResource(Name alias, Table<RoleResourceRecord> aliased) {
        this(alias, aliased, null);
    }

    private TroleResource(Name alias, Table<RoleResourceRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> TroleResource(Table<O> child, ForeignKey<O, RoleResourceRecord> key) {
        super(child, key, ROLE_RESOURCE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Superm.SUPERM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.ROLE_RESOURCE_UQX_ROLE_RESOURCE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RoleResourceRecord>> getKeys() {
        return Arrays.<UniqueKey<RoleResourceRecord>>asList(Keys.KEY_ROLE_RESOURCE_UQX_ROLE_RESOURCE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TroleResource as(String alias) {
        return new TroleResource(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TroleResource as(Name alias) {
        return new TroleResource(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TroleResource rename(String name) {
        return new TroleResource(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public TroleResource rename(Name name) {
        return new TroleResource(name, null);
    }
}