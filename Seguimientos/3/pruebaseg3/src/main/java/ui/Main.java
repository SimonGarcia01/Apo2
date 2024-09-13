package ui;

import controller.CarController;

public class Main {

    private CarController controller;

    public Main(){
        this.controller = new CarController();
    }

    public static void main(String[] args) {
        Main main = new Main();

//        main.controller.addCar(123, "KKK");
//        main.controller.addCar(122, "Mazda");
//        main.controller.addCar(124, "Audi");

        System.out.println(main.controller.getCars().toString());
        main.controller.load();
        System.out.println(main.controller.getCars().toString());
        System.out.println(main.controller.getCars().search(122));

    }

}
