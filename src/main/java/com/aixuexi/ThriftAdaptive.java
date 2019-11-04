package com.aixuexi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;

public class ThriftAdaptive implements AdaptiveTest {
    @Override
    public String echo(String msg, URL url) {
        return "thrift";
    }
}
