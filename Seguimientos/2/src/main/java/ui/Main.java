package ui;

import controller.TechWareController;
import model.TechPriceAmountComparator;
import model.TechProductAmountPriceComparator;

import java.util.Collections;

public class Main {
    private TechWareController controller;

    public Main() {
        this.controller = new TechWareController();
    }

    public static void main(String[] args){
        Main main = new Main();

        main.controller.load();
        System.out.println("Original list");
        System.out.println(main.controller.getInventory());
        System.out.println("----------");

        System.out.println("Internal Comparison by Name using Collections");
        Collections.sort(main.controller.getInventory());
        System.out.println(main.controller.getInventory());
        System.out.println("----------");

        System.out.println("External Comparison by Price and amount using Collections");
        TechPriceAmountComparator comparator = new TechPriceAmountComparator();
        Collections.sort(main.controller.getInventory(), comparator);
        System.out.println(main.controller.getInventory());
        System.out.println("----------");

        System.out.println("External Comparison by Name, Amount and Price using Insertion Sort");
        TechProductAmountPriceComparator comparator1 = new TechProductAmountPriceComparator();
        main.controller.insertionSort(comparator1);
        System.out.println(main.controller.getInventory());
        System.out.println("----------");

    }
}
