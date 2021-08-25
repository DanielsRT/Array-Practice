import java.util.*;
public class ArrPrac {
    
    // "cd" command enters folder
    
    public static void main(String[] args){ // primitive array
        System.out.println("ArrPrac Program");
        System.out.printf("You entered %d args\n", args.length);
        for (int ndx = 0; ndx < args.length; ndx++) {
            System.out.printf("args[%d]: %s\n", ndx, args[ndx]);
        }
        
        ArrayList<Integer> vals = new ArrayList<>(); // list
        for (int ndx = 0; ndx < args.length; ndx++) {
            int convertedArg = Integer.parseInt(args[ndx]);
            vals.add(convertedArg);
        }
        System.out.printf("You converted %d values\n", vals.size());
        
        int sum = 0;
        for (int ndx = 0; ndx < vals.size(); ndx++) {
            System.out.printf("vals.get(%d): %d\n", ndx, vals.get(ndx));
            sum += vals.get(ndx);
        }
        System.out.printf("sum is %d\n", sum);
    }
}