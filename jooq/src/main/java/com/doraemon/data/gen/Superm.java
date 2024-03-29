/*
 * This file is generated by jOOQ.
 */
package com.doraemon.data.gen;


import com.doraemon.data.gen.tables.Tresource;
import com.doraemon.data.gen.tables.Trole;
import com.doraemon.data.gen.tables.TroleResource;
import com.doraemon.data.gen.tables.Tuser;
import com.doraemon.data.gen.tables.TuserRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Superm extends SchemaImpl {

    private static final long serialVersionUID = -316639853;

    /**
     * The reference instance of <code>superm</code>
     */
    public static final Superm SUPERM = new Superm();

    /**
     * The table <code>superm.resource</code>.
     */
    public final Tresource RESOURCE = com.doraemon.data.gen.tables.Tresource.RESOURCE;

    /**
     * The table <code>superm.role</code>.
     */
    public final Trole ROLE = com.doraemon.data.gen.tables.Trole.ROLE;

    /**
     * The table <code>superm.role_resource</code>.
     */
    public final TroleResource ROLE_RESOURCE = com.doraemon.data.gen.tables.TroleResource.ROLE_RESOURCE;

    /**
     * The table <code>superm.user</code>.
     */
    public final Tuser USER = com.doraemon.data.gen.tables.Tuser.USER;

    /**
     * The table <code>superm.user_role</code>.
     */
    public final TuserRole USER_ROLE = com.doraemon.data.gen.tables.TuserRole.USER_ROLE;

    /**
     * No further instances allowed
     */
    private Superm() {
        super("superm", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Tresource.RESOURCE,
            Trole.ROLE,
            TroleResource.ROLE_RESOURCE,
            Tuser.USER,
            TuserRole.USER_ROLE);
    }
}
