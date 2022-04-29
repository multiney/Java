package com.jy.reflect;

import com.jy.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo2 {

    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;

/*        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("--------------------");
        Field nickname = personClass.getField("nickname");
        Person p = new Person();
        Object value = nickname.get(p);
        System.out.println(value);
        nickname.set(p, "jy");
        System.out.println(p);

        System.out.println("------------------");
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "qianjy");
        System.out.println(p);*/


        System.out.println("---------------");

        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Person qianjy = constructor.newInstance("qianjy", 25);
        System.out.println(qianjy);

        Object o = personClass.newInstance();
        System.out.println(o);


        Method eat_method = personClass.getMethod("eat");
        Person p1 = new Person();
        eat_method.invoke(p1);

        System.out.println("-----------");
        Method eat_method1 = personClass.getMethod("eat", String.class);
        eat_method1.invoke(p1, "fish");


        System.out.println("-------------");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
        }
    }
}
