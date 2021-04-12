package com.aixuexi.aspect;

import com.aixuexi.annotation.ControllerSecureVisit;
import com.aixuexi.annotation.LockKey;
import com.liepin.common.other.NullUtil;
import com.liepin.common.other.StringUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerSecureVisitAspect {

    /**
     * 安全访问切点
     * */
    @Pointcut("@annotation(com.aixuexi.annotation.ControllerSecureVisit)")
    public void securePoint() {

    }

    @Around("securePoint()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 错误信息(当鉴权不通过时,此值不为空)
        String errorMsg = "";
        // 获取拦截的方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();
        String[] aa = methodSignature.getParameterNames();
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            parameter.getAnnotations();
        }
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            Annotation[] annotation1 = annotations[i];
            for (Annotation annotation : annotation1) {
                if(annotation.annotationType() == LockKey.class) {
                    System.out.println("aaaaaa");
                }
                LockKey lockKey = (LockKey) annotation;
                for (String field : lockKey.keyField()) {
                    System.out.println(field);
                }
            }
        }

        joinPoint.getTarget().getClass().getDeclaredFields();
        try {
        } catch (Exception e) {
        }
        method.invoke(joinPoint.getTarget(),joinPoint.getArgs());
        return null;
    }
}
