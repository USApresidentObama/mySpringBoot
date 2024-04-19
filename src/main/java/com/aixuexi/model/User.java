package com.aixuexi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuao on 2018/11/19.
 */
@Data
public class User implements Serializable {

    private Long id;
    private Integer age;
    private String name;
    private Integer sex;
    private Integer deleted;
    private Boolean man;

    private Role roles;


}
