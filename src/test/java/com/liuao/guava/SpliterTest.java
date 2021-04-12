package com.liuao.guava;

import com.google.common.base.Splitter;
import org.junit.Test;

public class SpliterTest {



    @Test
    public void testSpliter() {
        System.out.println(Splitter.on(",").splitToList("1,2,3,4,5,,,"));
        System.out.println("1,2,3,4, 5,,,".split(",").length);

        System.out.println(Splitter.on(",").limit(2).splitToList("1,2,3,4,5"));
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().splitToList("1,2,3,4, 5,,,"));
    }

    @Test
    public void testSpliterFix() {
        System.out.println(Splitter.fixedLength(2).splitToList("1234567"));
    }

}