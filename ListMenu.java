import java.util.*;
import java.io.*;
public class ListMenu {
    
    static String MENU = "(A)dd element, (D)elete element, (I)nsert element\n" +
                         "(R)andom elements, (C)ount Above Average, (S)ave list\n" +
                         "(O)pen list, (F)ind Total, (Q)uit program\n";
    static Scanner keyb = new Scanner(System.in);
    static Random rand = new Random();
    
    public static void main(String[] args) {
        ArrayList<Double> valList = new ArrayList<>();
        char userChoice;
        do {
            showTheListElements(valList);
            userChoice = getChoice();
            
            switch (userChoice) {
                case 'A':
                    addElementToList(valList);
                    break;
                case 'D':
                    deleteElementFromList(valList);
                    break;
                case 'I':
                    insertElementToList(valList);
                    break;
                case 'R':
                    fillRandomElements(valList);
                    break;
                case 'C':
                    int countAboveAverage = countElementsAboveAverage(valList);
                    break;
                case 'S':
                    saveList(valList);
                    break;
                case 'O':
                    valList = openList();
                    break;
                case 'F':
                    Double total = findTheTotal(valList);
                    System.out.printf("The total equals %,.2f\n", total);
                    break;
                case 'Q':
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("No such option");
            }
        } while (userChoice != 'Q');   
    }
      
    // addElementToList(valList)
    static void addElementToList(ArrayList<Double> valList) {
        System.out.print("Enter a floating point value to add to the list: ");
        double valToAdd = Double.parseDouble(keyb.nextLine());  // consumes the trailing new line
        valList.add(valToAdd);
    }
    
    // deleteElementFromList(valList)
    static void deleteElementFromList(ArrayList<Double> valList) {
        System.out.print("Which element do you want to remove? ");
        int elementNumber = Integer.parseInt(keyb.nextLine());
        valList.remove(elementNumber);
    }
    
    // insertElementToList(valList)
    static void insertElementToList(ArrayList<Double> valList) {
        System.out.print("Where do you want to insert a value? ");
        int index = Integer.parseInt(keyb.nextLine());
        System.out.print("Enter a floating point value to add to the list: ");
        double valToAdd = Double.parseDouble(keyb.nextLine());
        valList.add(index, valToAdd);
    }
    
    // fillRandomElements(valList)
    static void fillRandomElements(ArrayList<Double> valList) {
        int numVals = 10;
        double maxVal = 100;
        for (int ndx = 0; ndx < numVals; ndx++) {
            double randNum = rand.nextDouble() * maxVal; // random double between 0 and maxVal
            valList.add(randNum);
        }
    }
    
    // countElementsAboveAverage(valList
    static int countElementsAboveAverage(ArrayList<Double> valList) {
        double average = findTheTotal(valList) / valList.size();
        int averageCount = countAboveValue(valList, average);
        System.out.printf("The average is %,.2f\n", average);
        System.out.printf("The count above average is %,d\n", averageCount);
        return averageCount;
    }
    
    // int averageCount = countAboveValue(valList, average)
    static int countAboveValue(ArrayList<Double> valList, double value) {
        int aboveValueCount = 0;
        for (int ndx = 0; ndx < valList.size(); ndx++) {
            if (valList.get(ndx) > value) {
                aboveValueCount++;
            }
        }
        return aboveValueCount;
    }
    
    // saveList(valList)
    static void saveList(ArrayList<Double> valList) {
        System.out.print("Enter a file name: ");
        String filename = keyb.nextLine();
        try (PrintWriter pw = new PrintWriter(filename)) {
            for (int ndx = 0; ndx < valList.size(); ndx++) {
                pw.println(valList.get(ndx));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // valList = openList()
    static ArrayList<Double> openList() {
        System.out.print("Enter a file name: ");
        String filename = keyb.nextLine();
        ArrayList<Double> openedList = new ArrayList<>();
        try (Scanner fileScan = new Scanner(new File(filename))) {
            while (fileScan.hasNext()) {
                Double val = fileScan.nextDouble();
                openedList.add(val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return openedList;
    }
    
    // Double total = findTheTotal(valList);
    static double findTheTotal(ArrayList<Double> valList) {
        Double total = 0.0;
        for (int ndx = 0; ndx < valList.size(); ndx++) {
            total += valList.get(ndx);
        }
        return total;
    }
    
    // showTheListElements(valList)
    static void showTheListElements(ArrayList<Double> valList) {
        System.out.println("\nIndex    Element");
        System.out.println("=====    =======");
        for (int ndx = 0; ndx < valList.size(); ndx++) {
            System.out.printf("%2d       %,.2f\n", ndx, valList.get(ndx));
        }
    }
 
    // userChoice = getChoice()
    static char getChoice() {
        System.out.print(MENU);
        System.out.print("Enter your choice: ");
        String user_input = keyb.nextLine().toUpperCase();
        return user_input.charAt(0);
    }
    
}