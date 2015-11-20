/**
 * Author Michael Dobrinski COMSC 1033 Section 1411 Instructor: Dr. Evert
 * 19 November 2015
 */
/**
 * Homework number 10 Create a program to take 6 numbers then sort
 * them into ascending order.
 *
 * Solution:
 * The program generates 6 random integers between 0 and 2000. The numbers are
 * stored in an array and then the array is printed in the order that the
 * numbers were generated. After the numbers are printed in the original order
 * the array is sent to the method insertSort(int[] sortList, int c) where the
 * array is sorted using an insertion sort. Once the array is sorted it is
 * printed out with the numbers in ascending order.
 *
 * The method outputArray(int[] sortList, int x) is used to print the array and
 * the method MyRandoms.randomNumber(int min, int max) is used to generate the
 * random numbers.
 */

public class COMSC_1033_HW_10_Sort {

	public static void main(String[] args) {
		int i = 0, count = 6;
		int[] sortList = new int[count];

			System.out.print("\nThe program generates a list of 6 integer"+
				" numbers then sorts the numbers and prints them in ascending"+
				" order.\n");

			for (i = 0; i < count; i++) {      // loop to get the numbers
				sortList[i] = MyRandoms.randomNumber(0, 2000);
			}

			System.out.println("\nThe numbers in the original order are:");
			outputArray(sortList, count);   // print the original array
			insertSort(sortList, count);
			System.out.println("\nThe numbers in ascending order are:");
			outputArray(sortList, count);   // print the sorted array


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

		for (j = 1; j <= c-1; j++) {   // pick each number starting at the
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

} // END of COMSC_1033_HW_10_SORT class
