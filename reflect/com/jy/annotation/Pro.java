package com.jy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述需要执行的类名，和方法名
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {

    String className();
    String methodName();
}


/*
        //其实就是在内存中生成了一个注解接口的子类实现对象
public class ProImpl implements Pro {
    public String className() {
        return "com.jy.domain.person";
    }
    public String methodName() {
        return "eat";
    }
}
 */