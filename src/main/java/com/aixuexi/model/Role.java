package com.aixuexi.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by liuao on 2018/11/19.
 */
@Data
public class Role {

    private Integer id;
    private String roleName;
    private Integer roleType;
    private Integer deleted;


}
