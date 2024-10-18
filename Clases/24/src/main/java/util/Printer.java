package util;

public class Printer {

    public static synchronized void printMessage(){
        System.out.println("Hello from printer");
        for(int i = 0; i < 10; i++){
            System.out.println("Print:" + i);
        }
    }
}
