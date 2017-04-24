package com.sandy.core.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by gondals on 09/08/16.
 */
public class MainReflection extends SampleClass {

    public static void main(String[] args) throws InstantiationException {
        new MainReflection().execute();
    }

    private void execute() throws InstantiationException {
        System.out.println("Hello Reflection");

        try {
            Class<?> aClass = Class.forName("com.sandy.core.reflection.SampleClass");

            SampleClass o = (SampleClass) aClass.newInstance();

            Field age = aClass.getDeclaredField("age");
            System.out.println("Private field: " + age.getName() + " " + age.toString());
            age.setAccessible(true);
            age.setInt(o, 120);

            Field name = aClass.getField("name");
            System.out.println("Public field: " + name.getName() + " " + name.toString());

            Method greet = aClass.getMethod("greet");
            greet.invoke(o);

            Method getAge = aClass.getDeclaredMethod("getAge");
            getAge.setAccessible(true);
            System.out.println(getAge.invoke(o));

            String str = "Sandeep";
            str.intern();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
