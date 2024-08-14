package ui;

import Controller.PersonController;
import exceptions.PersonNegativeAgeException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    //Association
    //private PersonController controller;

    public static void main(String[] args){
        Scanner sk = new Scanner(System.in);

        //Dependency
        PersonController controller = new PersonController();

        System.out.println("Name: ");
        String name = sk.nextLine();

        System.out.println("ID: ");
        String id = sk.nextLine();

        System.out.println("Age: ");
        int age = sk.nextInt();

        try{
            controller.addPerson(name, id, age);
        } catch (PersonNegativeAgeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Name: ");
        name = sk.nextLine();

        System.out.println("ID: ");
        id = sk.nextLine();

        System.out.println("Age: ");
        age = sk.nextInt();

        controller.addPerson2(name, id, age);


//        try {
//            System.out.print("Value of a: ");
//            int a = sk.nextInt();
//
//            System.out.print("Value of a: ");
//            int b = sk.nextInt();
//
//            System.out.println(a/b);
//
//        } catch(InputMismatchException e){
//            System.out.println("Enter numeric values");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        } catch(ArithmeticException e) {
//            System.out.println("Can't divide by 0");
//        }

//        //Previous process
//        System.out.print("Value of a: ");
//        int a = sk.nextInt();
//
//        System.out.print("Value of a: ");
//        int b = sk.nextInt();
//
//        //Control block
//        try{
//            //Executable process
//            System.out.println(a/b);
//        } catch(ArithmeticException e) {
//
//            //Contingency
//            System.out.println("Can't divide by 0");
//
//            System.out.print("Value of a: ");
//            a = sk.nextInt();
//
//            System.out.print("Value of a: ");
//            b = sk.nextInt();
//
//            System.out.println(a/b);
        }
    }
