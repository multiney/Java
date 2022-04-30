package com.jy.annotation;

import com.jy.junit.Calculator1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 主方法执行后，会自动执行被检测的所有方法（加了check注解的方法），判断方法是否异常，记录到文件中
 */
public class TestCheck {

    public static void main(String[] args) throws IOException {
        //创建计算器对象
        Calculator1 c = new Calculator1();
        //2.获取字节码文件对象
        Class<? extends Calculator1> cClass = c.getClass();
        //3.获取所有方法
        Method[] methods = cClass.getMethods();
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        int num = 0;


        for (Method method : methods) {
            //4.判断方法上是否有Check注解
            if (method.isAnnotationPresent(Check.class)) {
                //5.有的话，执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //6.捕获异常
                    //记录到文件中
                    ++num;
                    bw.write(method.getName() + " 方法出现异常！");
                    bw.newLine();
                    bw.write("异常的名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("--------------------");
                    bw.newLine();
                }

            }
        }
        bw.write("本次一共出现" + num + " 处异常");
        bw.flush();
        bw.close();
    }
}
