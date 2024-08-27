package ui;

import model.CarController;
import model.CarModelComparator;

import java.util.Collections;

public class Main {

    private CarController controller;

    public Main(){
        this.controller = new CarController();
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.controller.addCar("AAA000","Renault",1980);
        main.controller.addCar("BBB111","Honda",2007);
        main.controller.addCar("CCC222","Chevrolet",1980);
        main.controller.addCar("DDD333","Ford",1990);

        System.out.println(main.controller.getCars().get(0).compareTo(main.controller.getCars().get(1)));
        System.out.println(main.controller.getCars().get(0).compareTo(main.controller.getCars().get(2)));

        System.out.println("****************************");
        System.out.println(main.controller.getCars());

        //INTERNAL COMPARISON
        //To Collection  list of people must be given
        //The internal method (only one parameter) of sort, then the Class must have internal compareTo
        //The class must be "Comparable"

        System.out.println("INTERNAL COMPARISON");
        Collections.sort(main.controller.getCars());
        System.out.println(main.controller.getCars());

        //EXTERNAL COMPARISON
        //An external comparator must be defined
        //The comparator must have its comparison method defined inside
        //Sort will use comparator criteria to sort the list
        CarModelComparator comparator = new CarModelComparator();

        System.out.println("EXTERNAL COMPARISON");
        Collections.sort(main.controller.getCars(), comparator);
        System.out.println(main.controller.getCars());

    }

}
