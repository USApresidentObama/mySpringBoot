package com.aixuexi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI("dubbo")
public interface AdaptiveTest {
    @Adaptive
    public String echo(String msg, URL url);
}
