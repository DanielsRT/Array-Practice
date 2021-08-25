import java.util.*;
import java.io.*;
public class Sandbox {
    
    static Scanner keyb = new Scanner(System.in);
    
    public static void main(String[] args){
        System.out.println("Welcome to the Sandbox");
        int[] values = {12, 24, 31, 56, 44, 39, 48, 8, 52, 64, 37, 19, 28};
        printArray(values);
        System.out.print("Enter a target value: ");
        int target = keyb.nextInt();
        int index = findArrayIndex(values, target);
        if (index < 0) {
            System.out.println("Value not found");
        } else {
            System.out.printf("The index of %d is %d\n", target, index);
        }
        Arrays.sort(values);
        printArray(values);
        int index2 = binarySearch(values, target);
        if (index < 0) {
            System.out.println("Value not found");
        } else {
            System.out.printf("The index of %d is %d\n", target, index2);
        }
    }
    
    // printArray(values);
    public static void printArray(int[] array) {
        for (int ndx = 0; ndx < array.length; ndx++) {
            System.out.print(array[ndx] + "\t");
        }
        System.out.println();
    }
    
    // int index = findArrayIndex(values, 24);
    public static int findArrayIndex(int[] array, int valToFind) {
        for (int ndx = 0; ndx < array.length; ndx++) {
            if (array[ndx] == valToFind) {
                return ndx;
            }
        }
        return -1;
    }
    
    // int searchIndex = binarySearch(values);
    public static int binarySearch(int[] array, int valToFind) {
        int first = 0;
        int last = array.length - 1;
        int mid = (first + last) / 2;
        int valFromArray = array[mid];
        while (valFromArray != valToFind && first <= last) {
            if (valToFind > valFromArray) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
            valFromArray = array[mid];
        }
        
        if (first > last) {
            return -1;
        }
        return mid;
    }
}