/*
 * This file is generated by jOOQ.
 */
package com.doraemon.data.gen.tables.pojos;


import com.doraemon.data.enums.ResourceType;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class Resource implements Serializable {

    private static final long serialVersionUID = -417322533;

    private Integer      id;
    private String       name;
    private String       desc;
    private String       path;
    private ResourceType type;
    private Integer      parentId;

    public Resource() {}

    public Resource(Resource value) {
        this.id = value.id;
        this.name = value.name;
        this.desc = value.desc;
        this.path = value.path;
        this.type = value.type;
        this.parentId = value.parentId;
    }

    public Resource(
        Integer      id,
        String       name,
        String       desc,
        String       path,
        ResourceType type,
        Integer      parentId
    ) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.path = path;
        this.type = type;
        this.parentId = parentId;
    }

    public Integer getId() {
        return this.id;
    }

    public Resource setId(Integer id) {
        this.id = id;
        return this;
    }

    @NotNull
    @Size(max = 64)
    public String getName() {
        return this.name;
    }

    public Resource setName(String name) {
        this.name = name;
        return this;
    }

    @Size(max = 256)
    public String getDesc() {
        return this.desc;
    }

    public Resource setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    @Size(max = 256)
    public String getPath() {
        return this.path;
    }

    public Resource setPath(String path) {
        this.path = path;
        return this;
    }

    @NotNull
    public ResourceType getType() {
        return this.type;
    }

    public Resource setType(ResourceType type) {
        this.type = type;
        return this;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public Resource setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Resource (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(desc);
        sb.append(", ").append(path);
        sb.append(", ").append(type);
        sb.append(", ").append(parentId);

        sb.append(")");
        return sb.toString();
    }
}
