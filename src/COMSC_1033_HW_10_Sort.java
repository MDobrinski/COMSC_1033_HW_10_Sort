/**
 * Author Michael Dobrinski COMSC 1033 Section 1411 Instructor: Dr. Evert
 * 19 September 2015
 */
/**
 * Homework number 4 Create a program to read in 3 numbers then sort
 * them into ascending order.
 *
 * Solution:
 * The program prompts the user to enter the number of integers to be sorted
 * then prompts for each number in turn. The numbers are stored in an array
 * as they are entered and then the array is printed in the order that the
 * numbers were entered. After the numbers are printed in the original order
 * the array is sent to the method insertSort(int[] sortList, int c) where the
 * array is sorted using an insertion sort. Once the array is sorted it is
 * printed out with the numbers in ascending order.
 *
 * The method outputArray(int[] sortList, int x) is used to print the array.
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class COMSC_1033_HW_10_Sort {

	public static void main(String[] args) {
		int[] sortList = new int[21];
		int i = 0, count=0;
		boolean continueProgram = false;

			System.out.print("\nThe program reads in a list of up to 20 integer"+
				" numbers then sorts the numbers and prints them in ascending"+
				" order.\n");
			Scanner input = new Scanner(System.in);
				do{
					try{
						System.out.print("\nEnter the number of integers to be sorted, "
								+ "the maximum is 20: ");
						count = input.nextInt();
						System.out.printf("\nEnter %d numbers separated by a space: ",
								+count);
						count = (count > 20) ? 20 : count; // Limit the list to 20 max.
						for (i = 0; i < count; i++) {      // loop to get the numbers
							sortList[i] = input.nextInt();
						}
						continueProgram = false;//Set to exit DO-WHILE loop & end program.
					}   // End of try block
					catch (InputMismatchException ex){
						System.out.print("\nERROR: Invalid input type. The numbers must" +
								" be integers.");
						input.nextLine();
						continueProgram = true;
					}   // End of catch block
				} while (continueProgram);
				System.out.println("\nThe numbers in the original order are:");
				outputArray(sortList, count);   // print the original array
				insertSort(sortList, count);
				System.out.println("\nThe numbers in ascending order are:");
				outputArray(sortList, count);   // print the sorted array

				input.close();
	} // ******************** END of Main *************************

	/**
	 * Method to output an array.
	 * Inputs are the array reference and an integer value that is
	 * the number of integers in the array
	 */
	public static void outputArray(int[] sortList, int x) {
		for (int j = 0; j < x; j++) {
			System.out.println(sortList[j]);
		}
	}	// END of outputArray

	/**
	 * Method to sort an array of integers using an insert sort technique.
	 * Inputs are the array reference and an integer value that is the number of
	 * integers in the array.
	 */
	public static void insertSort(int[] sortList, int c) {
		int i = 0, j = 0, temp = 0;

		for (j = 1; j <= c; j++) {   // pick each number starting at the
			temp = sortList[j];      // second element
			i = j - 1;
																		 // Then look for a place to insert it
			while (i >= 0 && i < (c - 1) && sortList[i] > temp) {
				sortList[i + 1] = sortList[i];
				i--;
			}                       // insert the number
			sortList[i + 1] = temp;
		}
	} // END of insertSort

} // END of COMSC_1033_HW_4_SORT class
