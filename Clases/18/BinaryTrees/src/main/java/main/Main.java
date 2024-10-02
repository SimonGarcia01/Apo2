package main;

import structures.BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree<Integer> integerTree = new BinarySearchTree<>();

        integerTree.add(50);
        integerTree.add(40);
//        integerTree.add(30);
        integerTree.add(45);
//        integerTree.add(35);
//        integerTree.add(43);

        System.out.println(integerTree.inOrder());

        integerTree.delete(35);

        System.out.println(integerTree.inOrder());

//        System.out.println("Left of the root of the tree");
//        System.out.println(integerTree.getRoot().getLeft());

//        integerTree.add(40);
//        System.out.println("root's left");
//        System.out.println(integerTree.getRoot().getLeft().getValue());
//
//        integerTree.add(60);
//        integerTree.add(55);
//        integerTree.add(30);
//        System.out.println("root's left");
//        System.out.println(integerTree.getRoot().getLeft().getValue());
    }
}
