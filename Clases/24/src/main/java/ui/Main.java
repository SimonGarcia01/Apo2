package ui;

import util.Counter;
import util.FunctionalInterfaceExample;
import util.Printer;
import util.Work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter("Counter 1");
//        c1.start();

        //createThread();

        for(int i = 0; i < 10; i++){
            Work work = new Work("Work1");
            Thread t1 = new Thread(work);
            t1.start();
        }

        FunctionalInterfaceExample interfaceExample1 = new FunctionalInterfaceExample() {
            @Override
            public void onHello() {
                System.out.println("hello from the previous version to lambdas");
            }
        };

        FunctionalInterfaceExample interfaceExample = () -> {
            System.out.println("Hello from functional interface.");
        };

        interfaceExample.onHello();
        interfaceExample1.onHello();

        Thread t2 = new Thread( () -> {
            System.out.println("Lambda");
        });

        t2.start();

        if(t2.isAlive()){
            t2.start();
        }

        ExecutorService pool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            System.out.println("Execute: " + i);
            pool.execute( () -> {
                System.out.println("hello");
            });
        }


        Counter c2 = new Counter("Counter 2");
//        c2.start();


    }

    public static void createThread(){
        for(int i = 0; i < 100; i++){
            try{
                System.out.println("Hello from main" + i);

                //Executes a new thread with a defined task in a static method
                new Thread(Printer::printMessage).start();
                Thread.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
