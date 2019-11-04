package com.aixuexi;

import com.alibaba.dubbo.common.URL;

public class DubboAdaptive implements AdaptiveTest {
    @Override
    public String echo(String msg, URL url) {
        return "dubbo";
    }
}
