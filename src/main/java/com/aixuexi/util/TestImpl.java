package com.aixuexi.util;

import com.aixuexi.annotation.ControllerSecureVisit;
import com.aixuexi.annotation.LockKey;
import com.aixuexi.model.User;
import org.springframework.stereotype.Component;

@Component
public class TestImpl implements UtilTest{

    @Override
    @ControllerSecureVisit()
    public void send(@LockKey(keyField = "id") Integer id, String name) {
//        System.out.println(id);
    }
}
