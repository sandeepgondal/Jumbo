package com.sandy.designpattern.creational.builder;

/**
 * Created by gondals on 24/08/16.
 */
public class Pizza {

    private Base base;
    private Sauce sauce;
    private Toppings toppings;

    public static class PizzaBuilder {
        private Base base;
        private Sauce sauce;
        private Toppings toppings;

        PizzaBuilder setBase(Base base) {
            this.base = base;
            return this;
        }

        PizzaBuilder setSauce(Sauce sauce) {
            this.sauce  = sauce;
            return this;
        }

        PizzaBuilder setToppings(Toppings toppings) {
            this.toppings = toppings;
            return this;
        }

        Pizza build() {
            Pizza pizza = new Pizza();
            pizza.base = base;
            pizza.sauce = sauce;
            pizza.toppings = toppings;
            return pizza;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        if (base != null)
            output.append(base.toString() + " ");
        if (sauce != null)
            output.append(sauce.toString() + " ");
        if (toppings != null)
            output.append(toppings.toString());


        return output.toString();
    }
}
