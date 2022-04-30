package annotation;

public @interface MyAnno {

    int age() default 12;
    String name() default "qianjy";
    int value();
    Person p();
    MyAnno2 anno2();

    String[] strs();
}
