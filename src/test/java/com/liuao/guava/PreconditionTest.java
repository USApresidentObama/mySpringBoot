package com.liuao.guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

public class PreconditionTest {

    @Test
    public void testCheckNull() {
        byte[] bytes = "123".getBytes();
        for (byte b : bytes) {
            System.out.println(b);
        }

    }
}
