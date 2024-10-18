package util;

public class Counter extends Thread{

    private int time;
    private String name;

    public Counter(String name){
        this.name = name;
    }

    @Override
    public void run(){
        System.out.println("Mensaje de Hilo  >>" + name);
        while(true){
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            time++;

            System.out.println("Time: " + time + ">>>" + this.name);
        }

    }
}
