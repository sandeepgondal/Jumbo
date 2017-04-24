package com.sandy.designpattern.structural.facade;

/**
 * Created by gondals on 24/08/16.
 */
public class MainClass {

    public static void main(String[] args) {
        System.out.println("Hello Facade");

        SpendFacade spendFacade = new SpendFacadeImpl();
        System.out.println(spendFacade.getTotalSpend());
    }

}
