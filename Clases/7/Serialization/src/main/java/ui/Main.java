package ui;

import controller.PersonController;

//import java.io.File;

public class Main {

    private PersonController controller;

    public Main(){
        controller = new PersonController();
    }

    public static void main(String[] args){

        Main main = new Main();
        main.controller.createPerson("heehee", 50, "123123");
        main.controller.createPerson("aloha", 2, "44");
        main.controller.createPerson("wepa", -1, "99999");
        System.out.println(main.controller.getPeople());

        main.controller.save();

        main.controller.clearList();
        System.out.println(main.controller.getPeople());

        main.controller.load();
        System.out.println(main.controller.getPeople());

        /*
        File projectDir = new File(System.getProperty("user.dir"));

        System.out.println("Variable project: " + projectDir);
        System.out.println("Variable absolute path: " + projectDir.getAbsolutePath());
        System.out.println("Variable relative path: " + projectDir.getPath());
        System.out.println("Variable name: " + projectDir.getName());

        File data = new File(projectDir + "\\src\\main\\data");
        System.out.println(data.exists());
        data.mkdir();
        System.out.println(data.exists());
         */
    }
}
