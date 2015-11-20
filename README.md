# Homework Assignment 10 – Sort Program

## Abstract
This program uses for loops, methods, and arrays to solve the programming problem to sort 6 numbers into ascending order. 

## Summary
This part of homework assignment 10 is to write a program to sort 6 numbers into ascending order using for loops, methods, and arrays. 

The program creates an integer array to hold six random integer values. A for loop immediately following iterates through the array calling the MyRandoms.randomNumber method to generate random numbers between 0 and 2000 inclusive to fill the array. Once the array is filled the numbers are printed in the original order then the array is sorted and finally printed in ascending order.

The Git-SCM was used to track the project during development and it proved to be a valuable tool helping with tracking the development over various branches and then with the integration of the branches into one complete program. GitHub was also used giving access to the project during the development to interested persons who could make comments and suggestions as well as code corrections.



# Homework Assignment Number 10 – Sort Program
Homework assignment consisted of two parts. This part of the assignment is to write a program to sort six random numbers into ascending order. The program is to use methods, for loops, and arrays to accomplish the task.

The code for the programming solution is below followed by an explanation of the program.

## CODE – COMSC_1033_HW_10_Sort.java
```java
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

```
The program creates an array to hold six integers after which the program enters a for loop. The for loop in the main method is used to loop through the array and with each iteration fill the current element with a random number between 0 and 2000. The MyRandoms.randomNumber method is used to generate the numbers. Once the array is filled the outputArray method is used to print the array in the original order.

After the array is printed in the original order the insertSort method is used to sort the numbers in the array into ascending order after which the array is printed again with the numbers in ascending order.

The code for the MyRandoms class is given below.

## CODE – MyRandoms.java
```java
/***************************** MyRandoms.java****************************
 * The MyRandoms class has 4 methods that can be called to generate random
 * numbers using the Math.random method provided by Java.
 * Each method will generate a random number with the specified number of
 * digits. get1DigRandom gives a single digit random integer number between
 * 0 and 9 inclusive, that is (0<= number <=9).
 * get2DigRandom gives a two digit random integer number between
 * 10 and 99 inclusive, that is (10<= number <=99).
 */
public class MyRandoms {

	/**
	 * Generate a random number between mn (minimum) and mx (maximum) inclusive.
	 * Inputs: int minimum boundary, int maximum boundary
	 * Output: random integer between mn and mx inclusive.
	 */
	public static int randomNumber(int mn, int mx){

		int temp;
		if  (mn>mx){
			temp=mn;
			mn=mx;
			mx=temp;
		}
		return ((mx - mn + 1) * (int)(Math.random()*1000000)) / 1000000 + mn;
	}
// Return a random integer between 0 and 9 inclusive. 0<= random <=9
	public static int get1DigRandom (){
		return  (10 * (int)(Math.random()*100000)) / 100000;
	}
//Return a random integer between 10 and 99 inclusive. 10<= random <=99
	public static int get2DigRandom (){
		return  (90 * (int)(Math.random()*100000)) / 100000 + 10;
	}
//Return a random integer between 100 and 999 inclusive. 100<= random <=999
	public static int get3DigRandom (){
		return  (900 * (int)(Math.random()*100000)) / 100000 + 100;
	}
//Return a random integer between 1000 and 9999 inclusive. 1000<= random <=9999
	public static int get4DigRandom (){
		return  (9000 * (int)(Math.random()*100000)) / 100000 + 1000;
	}
} // ************** End of MyRandoms class ********************


```
The program required the generation of random numbers so the following formula was used to get the numbers: ((max - min + 1) * (int)(Math.random()*1000000)) / 1000000 + min. The Java Math.random method returns a double value that is greater than or equal to 0.0 and less than 1.0. Using that value the formula above will generate an integer value that is greater than or equal to min and less than or equal to max. The random number generation is contained in a class separate from the main class.

The MyRandoms class is used to provide various random integers to the calling program. There are five methods in the class get1DigRandom, get2DigRandom, get3DigRandom, get4DigRandom, and randomNumber. The 1, 2, 3, or 4 in the getXDigRandom methods indicate the number of digits in the random integer the method returns. As an example, the get3DigRandom method returns a three digit integer between 100 and 999 inclusive. The randomNumber method accepts two integer inputs and returns a random integer between the two inputs inclusive. Each of the methods in the MyRandoms class use the Math.random method that is included in the Java library. It was decided to put the random number methods in a separate class to make it easier to reuse the code in future projects. 

Some sample output from the program is provided in the console section below.

## CONSOLE
```
The program generates a list of 6 integer numbers then sorts the numbers and prints them in ascending order.

The numbers in the original order are:
780
1594
483
629
80
1069

The numbers in ascending order are:
80
483
629
780
1069
1594
```

The Git-SCM software was used to track the source code during the development of the programming project and GitHub was used as the remote repository server for the project. The git commands used in the git Bash shell are below.

```
mdobrinski@LT-WEA-0023 MINGW32 /e/COMSC_1033/Programs/COMSC_1033_HW_10_Sort (master)
$ git log
commit 4b8e8664721da677920a71f9e632be1041f1605a
Author: Michael Dobrinski <michael.git2015@gmail.com>
Date:   Wed Nov 18 08:22:56 2015 -0600

    Initial project commit of imported files.

mdobrinski@LT-WEA-0023 MINGW32 /e/COMSC_1033/Programs/COMSC_1033_HW_10_Sort (master)
$ git status
On branch master
Your branch is up-to-date with 'origin/master'.
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git checkout -- <file>..." to discard changes in working directory)

        modified:   bin/COMSC_1033_HW_10_Sort.class
        modified:   bin/MyRandoms.class
        modified:   src/COMSC_1033_HW_10_Sort.java
        modified:   src/MyRandoms.java

no changes added to commit (use "git add" and/or "git commit -a")

mdobrinski@LT-WEA-0023 MINGW32 /e/COMSC_1033/Programs/COMSC_1033_HW_10_Sort (master)
$ git commit -am"Modified sort program from homework 4."
[master 1ced109] Modified sort program from homework 4.
 4 files changed, 25 insertions(+), 44 deletions(-)
 rewrite bin/COMSC_1033_HW_10_Sort.class (85%)

mdobrinski@LT-WEA-0023 MINGW32 /e/COMSC_1033/Programs/COMSC_1033_HW_10_Sort (master)
$ git tag "v1.00"

mdobrinski@LT-WEA-0023 MINGW32 /e/COMSC_1033/Programs/COMSC_1033_HW_10_Sort (master)
$ git push
Username for 'https://github.com': MDobrinski
Password for 'https://MDobrinski@github.com':
Counting objects: 8, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (8/8), done.
Writing objects: 100% (8/8), 1.85 KiB | 0 bytes/s, done.
Total 8 (delta 3), reused 0 (delta 0)
To https://github.com/MDobrinski/COMSC_1033_HW_10_Sort.git
   4b8e866..1ced109  master -> master

mdobrinski@LT-WEA-0023 MINGW32 /e/COMSC_1033/Programs/COMSC_1033_HW_10_Sort (master)
$
```


