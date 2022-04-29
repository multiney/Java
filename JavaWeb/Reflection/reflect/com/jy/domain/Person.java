package com.jy.domain;

public class Person {

    private String name;
    private int age;

    public String nickname;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

/*    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    public void eat() {
        System.out.println("eat!");
    }


    public void eat(String food) {
        System.out.println("eat" + food);
    }
}
