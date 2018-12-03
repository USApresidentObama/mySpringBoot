package com.aixuexi.model;

import java.io.Serializable;

/**
 * Created by liuao on 2018/11/19.
 */
public class Role implements Serializable{
    private static final long serialVersionUID = 300018250815655845L;

    private Integer id;
    private String roleName;
    private Integer roleType;
    private Integer deleted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleType=" + roleType +
                ", deleted=" + deleted +
                '}';
    }
}
