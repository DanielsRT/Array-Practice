import java.util.*;

public class Array2dpractice {
    
    static Random rand = new Random();
    
    public static void main(String[] args) {

        int[][] scores = hard_coded_2d_array_of_ints();        
        print2DArraytoTerminal(scores);
        
        int[][] rand_values = random2darray();
        print2DArraytoTerminal(rand_values);
        
        int overallSum = computeOverallSum(scores);
        System.out.printf("\nThe overall sum is: %,d\n",overallSum);

        int numRows = scores.length;
        int numCols = scores[0].length;
        int numberOfElements = numRows * numCols;
        double overallAvg = 1.0 * overallSum / numberOfElements;
        System.out.printf("overallAvg: %,.2f\n",overallAvg);
        
        int[] sumsOfrowScores = sumRows(scores);
        System.out.println("\nHere are the sums of the rows:");
        print1DArraytoTerminal(sumsOfrowScores);
        
        int[] sumsOfColumns = sumCols(scores);
        System.out.println("Here are the sums of the columns:");
        print1DArraytoTerminal(sumsOfColumns);
    }
    
    // int[][] rand_values = random2darray();
    static int[][] random2darray() {
        int numRows = rand.nextInt(5) + 2; // from 2 to 6
        int numCols = rand.nextInt(5) + 2; // from 2 to 6
        int[][] vals2d = new Int[numRows][numCols];
        
        return vals2d;
    }
    
    // int[] sumsOfColumns = sumCols(scores);
    static int[] sumCols(int[][] array) {
        int[] sumsOfColumns = new int[array[0].length];
        for (int col = 0; col < array[0].length; col++) {
            sumsOfColumns[col] = 0;
            for (int row = 0; row < array.length; row++) {
                sumsOfColumns[col] += array[row][col];
            }
        }
        return sumsOfColumns;
    }
    
    // int[] sumsOfrowScores = sumRows(scores);
    static int[] sumRows(int[][] array) {
        int[] sumsOfrows = new int[array.length];
        for(int row = 0; row < array.length; row++) {
            sumsOfrows[row] = 0;
            for(int col = 0; col < array[row].length; col++) {
                sumsOfrows[row] += array[row][col];
            }
        } 
        return sumsOfrows;        
    }
    
    // print1DArraytoTerminal(sumsOfrows);
    static void print1DArraytoTerminal(int[] array) {
        for(int ndx = 0; ndx < array.length; ndx++) {
            System.out.printf("[%d]: %3d\n",ndx,array[ndx]);
        }
        System.out.println();
    }    
    
    // print2DArraytoTerminal(scores);
    static void print2DArraytoTerminal(int[][] array) {
        for(int row = 0; row < array.length; row++) {
            System.out.printf("Row %d: ",row);
            for(int col = 0; col < array[row].length; col++) {
                System.out.printf("%6d",array[row][col]);
            }
            System.out.println();
        }        
    }
    
    // int[][] scores = hard_coded_2d_array_of_ints();
    public static int[][] hard_coded_2d_array_of_ints() {
        /*
         * hard-coded values, rather than input
         */
        int numStudents = 3; // use for rows
        int numAssigns = 5; // use for columns
        
        int numRows = numStudents;
        int numCols = numAssigns;
        
        int[][] scores = new int[numRows][numCols]; // creates 2d array
        // values for row 0
        scores[0][0] = 100; 
        scores[0][1] = 90;
        scores[0][2] = 95;
        scores[0][3] = 92;
        scores[0][4] = 97;
        
        // values for row 1
        scores[1][0] = 93; 
        scores[1][1] = 80;
        scores[1][2] = 91;
        scores[1][3] = 90;
        scores[1][4] = 87;
        
        // values for row 2
        scores[2][0] = 83; 
        scores[2][1] = 80;
        scores[2][2] = 99;
        scores[2][3] = 96;
        scores[2][4] = 97;
       
        return scores;
    }
    
    // int overallSum = computeOverallSum(scores);
    public static int computeOverallSum(int[][] scores) {
        int sum = 0;
        for(int row = 0; row < scores.length; row++) {
            for(int col = 0; col < scores[row].length; col++) {
                sum = sum + scores[row][col];
            }            
        }        
        return sum;        
    }
}