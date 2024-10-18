package util;

public class Work implements Runnable{

    private String name;
    private int counter;

    public Work(String name){
        this.name = name;
    }

    @Override
    public void run(){
        ++counter;
        System.out.println("Hello from Work Runnable: " + name + " Counter: "+ counter);
        setName("New Name");
        System.out.println("Hello from Work Runnable: " + name + " Counter: "+ counter);
    }

    public void setName(String name){
        this.name = name;
    }
}
