import java.util.*;
public class ComLinePractice {
    
    static Scanner keyb = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("You typed " + args.length +
                           " things");
        for (int n = 0; n < args.length; n++) {
            System.out.println(n + " " + args[n]);
        }
        int argsSum = 0;
        for (int n = 0; n < args.length; n++) {
            int val = Integer.parseInt(args[n]);
            argsSum = argsSum + val;
        }
        System.out.println("The sum is " + argsSum);
    }
}