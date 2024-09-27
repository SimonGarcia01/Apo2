package ui;

import recursion.Recursion;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();

//        m.iterativeCount(10);
//        m.recursiveCount(10);

        Recursion r = new Recursion();
        // System.out.println(r.factorial(5));

        System.out.println(r.count(5));
    }

    //Iterative version for a countdown
    public void iterativeCount(int n){
        for(int i = n; i > 0; i--){
            System.out.println(i);
        }
    }

    public void recursiveCount(int n){
        //Base case
        if(n == 0){
            System.out.println(n);
        }
        //Recursive case
        else {
            System.out.println(n);
            recursiveCount(--n);
        }
    }
}
