package com.liuao.guava;

import com.google.common.base.Joiner;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class JoinerTest {

    private final List<Integer> list = Arrays.asList(1,2,3,null);


    @Test
    public void testJoiner() {
       String result = Joiner.on(",").skipNulls().join(list);
        System.out.println(result);
    }

    @Test
    public void testJoinerUseDefalut() {
        String result = Joiner.on(",").useForNull("asd").join(list);
        System.out.println(result);
    }


}
