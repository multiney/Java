package com.jy.reflect;

import annotation.MyAnno3;
import com.jy.annotation.Pro;
import com.jy.domain.Person;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

@Pro(className = "com.jy.domain.Student", methodName = "sleep")
public class ReflectTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
/*        Properties pro = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        Class<?> cls = Class.forName(className);
        Object o = cls.newInstance();

        Method method = cls.getMethod(methodName);
        method.invoke(o);*/

        //获取该类的字节码对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //获取注解对象
        //其实就是在内存中生成了一个注解接口的子类实现对象
        Pro anno = reflectTestClass.getAnnotation(Pro.class);
        //调用注解对象中的抽象方法，获取返回值
        String className = anno.className();
        String methodName = anno.methodName();

        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();
        Method method = aClass.getMethod(methodName);
        method.invoke(o);

    }
}
