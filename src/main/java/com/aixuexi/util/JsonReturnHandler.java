package com.aixuexi.util;

import com.aixuexi.util.annotation.JSON;
import com.aixuexi.util.annotation.JSON2;
import com.aixuexi.util.annotation.JSONS;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * @author Huchuan Huang
 * @createTime 2017/3/8 下午5:15
 * @lastUpdater Huchuan Huang
 * @lastUpdateTime 2017/3/8 下午5:15
 * @note
 */

public class JsonReturnHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        //如果有自定义的JSON注解，就用这个Handler处理
        boolean hasJsonAnno = returnType.getMethodAnnotation(JSON.class) != null;
        return hasJsonAnno;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest) throws Exception {
        //设置最终的处理类，处理完不再去找下一个类进行处理
        mavContainer.setRequestHandled(true);

        //获得注解并执行filter方法 最后返回
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        Annotation[] annos = returnType.getMethodAnnotations();
        CustomerJsonSerializer jsonSerializer = new CustomerJsonSerializer();
        Arrays.asList(annos).forEach(a -> { // 解析注解，设置过滤条件
            if (a instanceof JSON) {
                JSON json = (JSON) a;
                jsonSerializer.filter(json.type(),json.include(),json.filter());
            } else if (a instanceof JSONS) { // 使用多重注解时，实际返回的是 @Repeatable(JSONS.class) 内指定的 @JSONS 注解
                JSONS jsons = (JSONS) a;
                Arrays.asList(jsons.value()).forEach(json -> {
                    jsonSerializer.filter(json.type(),json.include(),json.filter());
                });
            }else if(a instanceof JSON2) {
                JSON2 json = (JSON2) a;
                jsonSerializer.filter(json.type(),json.include(),json.filter());
            }
        });

        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        String json = jsonSerializer.toJson(returnValue);
        response.getWriter().write(json);
    }
}
