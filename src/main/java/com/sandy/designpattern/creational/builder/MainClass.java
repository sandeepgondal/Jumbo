package com.sandy.designpattern.creational.builder;

/**
 * Created by gondals on 24/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello Builder");

        Pizza pizza1 = new Pizza.PizzaBuilder()
                .setBase(new Base())
                .setSauce(new Sauce())
                .setToppings(new Toppings())
                .build();
        Pizza pizza2 = new Pizza.PizzaBuilder()
                .setBase(new Base())
                .setToppings(new Toppings())
                .build();

        System.out.println(pizza1.toString());
        System.out.println(pizza2.toString());
    }

}
