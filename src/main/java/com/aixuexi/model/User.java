package com.aixuexi.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuao on 2018/11/19.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6309285186522625503L;

    private long id;
    private Integer age;
    private String name;
    private Integer sex;
    private Integer deleted;
    private EnumColor enumColor;
    private Boolean man;

    private List<Role> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public EnumColor getEnumColor() {
        return enumColor;
    }

    public void setEnumColor(EnumColor enumColor) {
        this.enumColor = enumColor;
    }

    public Boolean getMan() {
        return man;
    }

    public void setMan(Boolean man) {
        this.man = man;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", age=").append(age);
        sb.append(", name='").append(name).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", deleted=").append(deleted);
        sb.append(", enumColor=").append(enumColor);
        sb.append(", man=").append(man);
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
