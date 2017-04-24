package com.sandy.dsalgo.trees;

import java.util.Random;
import java.util.Set;

/**
 * Created by gondals on 14/08/16.
 */
public class AVLMain {

    public static void main(String[] args) {

        AVLTreeSet<Integer> tree = new AVLTreeSet<>();

        ((AVLTreeSet) tree).setShowRotations(true);

        int[] adds;

        System.out.println("============ EXAMPLE\n");
//        adds = new int[]{80, 40, 20, 30, 25, 35};
        adds = new int[]{30, 20, 25};
        for (int i : adds) {
            System.out.println("---------- add " + i);
            tree.add(i);
            ((AVLTreeSet) tree).reverseInorderOutput();
            System.out.println();
        }

//        System.out.println("============ EXAMPLE: sequential\n");
//        tree.clear();
//
//        adds = new int[]{10, 20, 30, 40, 50, 60, 70};
//        for (int i : adds) {
//            System.out.println("---------- add " + i);
//            tree.add(i);
//            ((AVLTreeSet) tree).reverseInorderOutput();
//            System.out.println();
//        }
//
//        System.out.println("============ EXAMPLE: random\n");
//        tree.clear();
//
//        Random rnd = new Random();
//        adds = new int[7];
//        for (int i = 0; i < adds.length; ++i) {
//            adds[i] = 1 + rnd.nextInt(50);
//        }
//        for (int i : adds) {
//            System.out.println("---------- add " + i);
//            tree.add(i);
//            ((AVLTreeSet) tree).reverseInorderOutput();
//            System.out.println();
//        }
    }

}
