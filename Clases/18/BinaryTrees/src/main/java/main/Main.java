package main;

import structures.BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree<Integer> integerTree = new BinarySearchTree<>();

        integerTree.add(50);
        System.out.println("Root of the tree");
        System.out.println(integerTree.getRoot().getValue());

        integerTree.add(40);
        System.out.println("root's left");
        System.out.println(integerTree.getRoot().getLeft().getValue());

        integerTree.add(60);
        integerTree.add(55);
        integerTree.add(30);
        System.out.println("root's left");
        System.out.println(integerTree.getRoot().getLeft().getValue());
    }
}
