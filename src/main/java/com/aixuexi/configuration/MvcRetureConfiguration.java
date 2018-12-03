package com.aixuexi.configuration;

import com.aixuexi.util.JsonReturnHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * Created by liuao on 2018/11/19.
 */
@Configuration
//@ComponentScan(basePackages = {"com.aixuexi.configuration"},useDefaultFilters = true)
//@EnableWebMvc
public class MvcRetureConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public JsonReturnHandler jsonReturnHandler(){
        return new JsonReturnHandler();//初始化json过滤器
    }
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        returnValueHandlers.add(jsonReturnHandler());
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/public/");
//    }


//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix(null);
//        viewResolver.setSuffix(null);
//
//        registry.viewResolver(viewResolver);
//        registry.order(1);
//    }

}
