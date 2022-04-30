package com.jy.reflect;

import com.jy.domain.Person;

public class ReflectDemo01 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class aClass = Class.forName("com.jy.domain.Person");
        System.out.println(aClass);

        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        Person person = new Person();
        Class<? extends Person> aClass1 = person.getClass();
        System.out.println(aClass1);
    }

}
