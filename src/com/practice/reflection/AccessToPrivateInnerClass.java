package com.practice.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AccessToPrivateInnerClass {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        int num = 6;
        Outer obj = new Outer();
        Outer.InnerPrivate aPrivate = obj.new InnerPrivate();

        Method[] declaredMethods = aPrivate.getClass().getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method declaredMethod = declaredMethods[i];
            declaredMethod.setAccessible(true);
            String invoke = (String) declaredMethod.invoke(aPrivate, num);
            System.out.println(invoke);
        }
    }

    static class Outer {
        private class InnerPrivate {
            private String powerof(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }//end of Inner
}
