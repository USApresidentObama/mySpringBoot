package com.aixuexi.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuao on 2018/11/19.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6309285186522625503L;

    private Integer id;
    private Integer age;
    private String name;
    private Integer sex;
    private Integer deleted;

    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", deleted=" + deleted +
                ", roles=" + roles +
                '}';
    }
}
