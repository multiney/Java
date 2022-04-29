## JDK中预定义的注解

* @Override:
* @Deprecated: 表示该注解标注的内容已经过时
* @SuppressWarning: 压制警告
  * @SuppressWarning("all")

## 自定义注解

* 格式

``` java
public @interface MyAnno {

}
```

* 本质： 就是一个接口，该接口默认继承Annotation接口

`public interface MyAnno extends java.lang.annotation.Annotation {}`

* 属性：接口中能定义的成员方法
  * 要求：
    * 属性的返回值类型
      * 基本数据类型
      * String
      * 枚举
      * 注解
      * 以上类型的数组
    * 定义了属性，在使用时需要给属性赋值
      * 如果定义属性时，使用default关键字给属性默认初始值，则使用注解时，可不进行属性的赋值，
      * 如果只有一个属性需要赋值，并且属性的名称是value，则value可省略，直接写值；
      * 数组赋值时，值使用{}包裹，如果数组中只有一个值，则{}可被忽略。
* 元注解：用于描述注解的注解
  * @Target：描述注解能够作用的位置
    * ElementType取值：
      * TYPE
      * FIELD
      * METHOD
  * @Retention：描述注解被保留的阶段
    * @Retention(RetentionPolicy.RUNTIME)：当前被描述的注解，会保留到class字节码中，并被jvm读取到，SOURCE不会到字节码中，CLASS表示不会被jvm读取到
  * @Documented：描述注解是否被抽取到api文档中
  * @Inherited：表示父类的注解是否被子类继承

* 在程序使用（解析）注解：获取注解中定义的属性值
      1. 获取注解定义的位置的对象 (Class, Method, Field)
      2. 获取指定的注解
         1. getAnnotation(Class)
      3. 调用注解中的抽象方法获取配置的属性值
      4. 