package ui;

import controller.TechWare;

public class Main {
    private TechWare controller;

    public Main() {
        this.controller = new TechWare();
    }

    public static void main(String[] args) {
        Main main = new Main();

        //To Add all the products
//        main.controller.addProduct("Laptop", 5800000,10);
//        main.controller.addProduct("SmartPhone", 4499999,40);
//        main.controller.addProduct("Tablet", 1499999,50);
//        main.controller.addProduct("Monitor", 1249999,30);
//        main.controller.addProduct("Teclado", 199900,100);
//        main.controller.addProduct("Mouse", 79900,150);
//        main.controller.addProduct("Impresora", 499900,25);
//        main.controller.addProduct("MemoriaUSB", 39900,500);
//        main.controller.addProduct("Cámara", 2249999,20);
//        main.controller.addProduct("Smartwatch",999900,30);
//
//        main.controller.save();


        main.controller.load();
        System.out.println(main.controller.getproducts().toString());

        System.out.println("Searching for SmartPhone: ");
        System.out.println(main.controller.getproducts().search("SmartPhone"));

        System.out.println("Searching for nonexistent product: ");
        System.out.println(main.controller.getproducts().search("xd"));





    }
}
