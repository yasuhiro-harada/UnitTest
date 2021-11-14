package com.testDB;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import scala.Console;

public class SuperClass{

    public int superA = 0;
    public int superB = 0;


    public String GetA(){
        return "SuperClassA";
    }
    private String GetB(){
        return "SuperClassB";
    }
    public String GetE(){

        String aaa = GetB();

        Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            Console.println(field.getName());
        }

        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            Console.println(method.getName());
        }

        return aaa + "SuperClassC";
    }
}
