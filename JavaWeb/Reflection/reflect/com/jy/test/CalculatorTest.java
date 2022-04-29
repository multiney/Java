package com.jy.test;


import com.jy.junit.Calculator;
import org.junit.*;
import org.testng.Assert;
//import org.testng.annotations.Test;

public class CalculatorTest {


    @Before
    public void init() {
        System.out.println("init");
    }

    @After
    public void close() {
        System.out.println("close");
    }

    @Test
    public void testAdd() {
        Calculator c = new Calculator();
        int res = c.add(1, 2);
        System.out.println(res);
        Assert.assertEquals(res, 3);
    }

    @Test
    public void testSub() {
        Calculator c = new Calculator();
        int res = c.sub(1, 2);
        Assert.assertEquals(res, -1);
    }
}
