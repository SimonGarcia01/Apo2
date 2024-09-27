package recursion;

public class Recursion {

    public int factorial(int n) {
        int result;

        if(n == 0){
            result = 1;
        }

        //Recursive case
        else {
            result = n*factorial(n-1);
        }

        return result;
    }

    //Method that's called
    public String count(int n) {
        String message = "[ ";
        return count(n, message);
    }

    //Method that does the work
    private String count(int n, String message) {

        //Some logic problem here
        if(n == 0){
            message += " ]";
        } else {
            message += n + ", ";
            message  += count(--n, message);
        }


        return message;
    }

}
