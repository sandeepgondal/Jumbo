package com.sandy.dsalgo.array;

/**
 * Created by gondals on 13/08/16.
 */
public class TestMyArray {

    public static void main(String[] args) {
        System.out.println("Testing My Array");

        MyArray myArray = new MyArray(5);

        myArray.addValue(10);
        myArray.addValue(20);
        myArray.addValue(15);
        myArray.addValue(5);
        myArray.print();
        System.out.println("-------");

        myArray.updateValue(36, 2);
        myArray.print();
        System.out.println("-------");

        myArray.deleteValue(3);
        myArray.print();
        System.out.println("-------");

        myArray.insertValue(99, 3);
        myArray.print();
    }

}
