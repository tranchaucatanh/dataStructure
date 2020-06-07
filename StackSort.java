
import java.io.*;
import java.util.*;

/**
 * StackSort is a program that will use two stacks to sort an array of integer values.
 * 
 * @author  Edited Canh Hanh Chi Tran
 * @version 4.0
 */
public class StackSort {

    public static void main(String args[]) {

        int data[] = null;
        int result[] = null;

        Scanner input;
        input = new Scanner(System.in);

        System.out.println("This program sorts an array of integer values.");
     
        // Create an empty array of integers
        data = createArray(0, 1, 1);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with one integer
        data = createArray(1, 0, 9);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with two integers
        data = createArray(2, 0, 9);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        // Create an array with 10 integers
        data = createArray(10, 0, 9999);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println();

        //Create an array with 20 integers
        data = createArray(20, 0, 9);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println(); 

        System.out.println("Please enter the number of values to sort");
        int size = getInt("   It should be an integer value greater than or equal to 1.");
        // Create an array of the given size

        data = createArray(size, 0, 99);
        System.out.println("Original array is: " + representationOfArray(data));
        result = doStackSort(data);
        System.out.println("Sorted array is: " + representationOfArray(result));
        System.out.println(); 


    }


    /**
     * Use two stacks to sort the data in an array
     *
     * @param data An array of integer values to be sorted.
     * @return     An array of sorted integers. 
     */
    private static int[] doStackSort(int data[]) {

    int result[] = new int[data.length];
    
    StackInterface<Integer> lowerValues = new VectorStack<Integer>(data.length);
    StackInterface<Integer> upperValues = new VectorStack<Integer>(data.length);
    
    for(int i=0; i< data.length; i++) {
    	lowerValues.push(data[i]);
    }
    
    while (!lowerValues.isEmpty()) {
    	int temp = lowerValues.pop();
    	while (!upperValues.isEmpty() && temp > upperValues.peek()) {
    		lowerValues.push(upperValues.pop());
    	}
    	upperValues.push(temp);
    }
    	
	    
    for(int i=0; i< data.length; i++) {
      result[i] = upperValues.pop();
    }
    
      return result;

    }

    /**
     * Load an array with data values
     *
     * @param size The number of data values to generate and place in the array.
     * @param min The minimum value to generate.
     * @param max The maximum value to generate.
     * @return     An array of randomly generated integers. 
     */
    private static int[] createArray(int size, int min, int max) {

        Random generator = new Random();

        // If we get a negative size, just make the size 1
        if (size < 0) {
            size = 1;
        }
        // We need max > min for the random number generator to be happy

        if (max <= min) {
            max = min + 1;
        }

        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = min + generator.nextInt(max - min);
        }

        return data;
    }

    /**
     * Create a string with the data values from an array
     *
     * @param data An array of integer values.
     * @return A string representation of the array.
     */
    private static String representationOfArray(int data[]) {
        String result = new String("< ");
        for (int i = 0; i < data.length; i++) {
            result += data[i] + " ";
        }
        result += ">";

        return result;
    }

    /**
     * Get an integer value
     *
     * @return  An integer. 
     */
    private static int getInt(String rangePrompt) {
        Scanner input;
        int result = 10;        //default value is 10
        try {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();

        } catch (NumberFormatException e) {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        } catch (Exception e) {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;

    }
}

/*
 *  
This program sorts an array of integer values.
Original array is: < >
Sorted array is: < >

Original array is: < 5 >
Sorted array is: < 5 >

Original array is: < 4 0 >
Sorted array is: < 0 4 >

Original array is: < 7428 4668 8323 7792 6802 6855 3373 1845 5700 6417 >
Sorted array is: < 1845 3373 4668 5700 6417 6802 6855 7428 7792 8323 >

Original array is: < 0 0 7 8 7 1 7 4 5 2 8 6 6 4 4 7 7 8 4 3 >
Sorted array is: < 0 0 1 2 3 4 4 4 4 5 6 6 7 7 7 7 7 8 8 8 >

Please enter the number of values to sort
   It should be an integer value greater than or equal to 1.
50
Original array is: < 72 86 96 94 38 97 33 14 37 86 60 67 77 8 3 70 75 76 24 81 46 85 45 80 20 34 87 52 74 27 27 49 21 81 39 62 70 33 62 27 82 53 95 68 49 61 93 24 82 42 >
Sorted array is: < 3 8 14 20 21 24 24 27 27 27 33 33 34 37 38 39 42 45 46 49 49 52 53 60 61 62 62 67 68 70 70 72 74 75 76 77 80 81 81 82 82 85 86 86 87 93 94 95 96 97 >

*/


