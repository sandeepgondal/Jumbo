package com.sandy.core.annotation;

import java.lang.reflect.Field;

/**
 * Created by gondals on 29/08/16.
 *
 * Creating an object by using its annotated values.
 */
public class MainClass {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MyClass myClassObj = getMyClass();
        System.out.println("User is " + myClassObj.getName() + " Address is " + myClassObj.getAddress() + " Pin is " + myClassObj.getPin());
    }

    private static MyClass getMyClass() throws InstantiationException, IllegalAccessException {
        Class<MyClass> myClass = MyClass.class;
        Field[] declaredFields = myClass.getDeclaredFields();

        MyClass myClassObj = myClass.newInstance();

        for (Field field : declaredFields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(MyColumnAnnotation.class)) {
                MyColumnAnnotation annotation = field.getAnnotation(MyColumnAnnotation.class);
                System.out.println("Setting value for field - " + field.getName() + " with annotation values " + annotation.value() + " " + annotation.type());
                if ("name".equals(field.getName())) {
                    field.set(myClassObj, "Sandeep " + annotation.type());
                } else if ("address".equals(field.getName())) {
                    field.set(myClassObj, "Warje " + annotation.type());
                }
            } else {
                if ("pin".equals(field.getName())) {
                    field.setInt(myClassObj, 411058);
                }
            }
        }
        return myClassObj;
    }

}
