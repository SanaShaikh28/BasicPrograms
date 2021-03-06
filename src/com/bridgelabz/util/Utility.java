/***********************************************
 * Purpose : To store all logic of the programs
 *           
 * @author  Sana Shaikh
 * @version 1.0
 * @since   13/01/2018          
 ***********************************************/

package com.bridgelabz.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.bridgelabz.objectOriented.StackCommercial;
import com.sun.javafx.scene.paint.GradientUtils.Parser;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Utility<T> {

	private static File file;
	private static FileWriter fileWriter;
	private static FileReader fileReader;
	private static final String Regex = null;
	static Scanner scanner = new Scanner(System.in);
	static PrintWriter writer = new PrintWriter(System.out, true);
	public static String total;
	private static int t;

	/**
	 * This method to take input from user
	 */
	public Utility() {
		scanner = new Scanner(System.in);
	}

	public static int getInteger() {
		return scanner.nextInt();

	}

	public static boolean getBoolean() {
		return scanner.nextBoolean();

	}

	public static double getDouble() {
		return scanner.nextDouble();

	}

	public static String getString() {
		return scanner.next();
	}

	public static String getWords() {
		return scanner.nextLine();
	}

	/**
	 * FUNCTIONAL LOGICS
	 */

	/**
	 * This method takes User Input and Replace String Template“Hello
	 * <<UserName>>, How are you?”
	 * 
	 * @param input
	 */

	public static void userName(String input) {
		String REGEX = "<<UserName>>";
		String INPUT = "Hello <<UserName>> , How are you?";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(INPUT);
		INPUT = matcher.replaceAll(input);
		System.out.println(INPUT);
	}

	/**
	 * This method Flips a Coin and print percentage of Heads and Tails
	 * 
	 * @param input
	 */
	public static void flipCoin(int input) {
		int flip;
		int headCount = 0;
		int tailCount = 0;
		for (flip = 1; flip <= input; flip++) {
			if (Math.random() < 0.5) {
				headCount++;
			} else {
				tailCount++;
			}
		}
		System.out.println("headCount=" + headCount);
		System.out.println("tailCount=" + tailCount);

		System.out.println("per of heads " + ((headCount) * 100) / input + " %");
		System.out.println("per of tails " + ((tailCount) * 100) / input + " %");
	}

	/**
	 * This method determine if it is a Leap Year.
	 * 
	 * @param year
	 * @return
	 */
	public static int leapYear(int year) {
		if (((year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0)))) {
			System.out.println("Year " + year + " is a Leap Year");
		} else {
			System.out.println("Year " + year + " is not a Leap Year");
		}
		return year;

	}

	/**
	 * This method takes a command-line argument N and prints a table of the
	 * powers of 2 that are less than 2^N
	 * 
	 * @param number
	 */
	public static void powerOfTwo(int number) {
		int i = 0;
		int power = 1;
		System.out.println("Powers of 2 that are less than 2^" + number);
		while (i < number) {
			System.out.println("2^" + i + " = " + power);
			power = power * 2;
			i++;
		}

	}

	/**
	 * This function prints the Nth harmonic number
	 * 
	 * @param value
	 */
	public static void harmonicNumber(int value) {
		float i;
		float term;
		float sum = 0;
		for (i = 1; i <= value; i++) {
			term = 1 / i;
			sum = sum + term;
		}
		System.out.println("Sum of Harmonic series is=" + sum);

	}

	/**
	 * This method computes the prime factorization of a Number
	 * 
	 * @param number
	 */
	public static void primeFactoristaion(int number) {
		while (number % 2 == 0) {
			System.out.println(2 + "");
			number /= 2;
		}

		for (int i = 3; i <= Math.sqrt(number); i += 2) {
			while (number % i == 0) {
				System.out.println(i + "");
				number /= i;
			}
		}

		if (number > 2) {
			System.out.println(number);
		}

	}

	/**
	 * This method prints the percentage of win and lose
	 * 
	 * @param stake
	 * @param goal
	 * @param trials
	 */
	public static void gambler(int stake, int goal, int trials) {
		int wins = 0, i, loss = 0;
		for (i = 0; i < trials; i++) {
			int cash = stake;

			while (cash > 0 && cash < goal) {
				if (Math.random() < 0.5)
					cash++;
				else
					cash--;
			}
			if (cash == goal)
				wins++;
			else
				loss++;
		}
		System.out.println("Number of Percentage won..." + (100 * wins) / trials + "%");
		System.out.println("Number of Percentage loss..." + (100 * loss) / trials + "%");

	}

	/**
	 * This method generates distinct coupon number
	 * 
	 * @param number
	 */
	public static void couponNumber(int number) {

		int[] array = new int[number];
		// int count=0;
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * number);

			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					i--;
				}
			}
		}
		for (int i : array) {
			System.out.println("Generated number is : " + i);
		}
		System.out.println("Distinct generated number are :" + number);
	}

	/**
	 * This method reads integer array from user
	 * 
	 * @param array
	 * @param rows
	 * @param columns
	 */
	public static void inputArray(Integer[][] array, int rows, int columns) {
		writer.println("Enter Array elements");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		Utility.printArray(array, rows, columns);
	}

	/**
	 * This method reads double array from user
	 * 
	 * @param array
	 * @param rows
	 * @param columns
	 */
	public static void inputArray(Double array[][], int rows, int columns) {
		writer.println("Enter Array elements");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = scanner.nextDouble();
			}
		}
		Utility.printArray(array, rows, columns);

	}

	/**
	 * This method reads boolean input array from user
	 * 
	 * @param array
	 * @param rows
	 * @param columns
	 */
	public static void inputArray(Boolean array[][], int rows, int columns) {
		writer.println("Enter Array elements");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = scanner.nextBoolean();
			}
		}
		Utility.printArray(array, rows, columns);

	}

	/**
	 * This method prints the output of 2D array
	 * 
	 * @param array
	 * @param rows
	 * @param columns
	 */
	public static <E> void printArray(E[][] array, int rows, int columns) {
		writer.println("Array elements are:");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				writer.print(array[i][j] + "  ");
			}
			writer.println(" ");
		}
	}

	/**
	 * This method finds the triplet with sum zero
	 * 
	 * @param N
	 * @param array
	 */
	public static void findTriplet(int number, int[] array) {
		// System.out.println("hi..");
		boolean found = false;

		for (int i = 0; i < number - 2; i++) {
			for (int j = i + 1; j < number - 1; j++) {
				for (int k = j + 1; k < number; k++) {
					if (array[i] + array[j] + array[k] == 0) {
						System.out.println("Triplets are :" + array[i] + " " + array[j] + " " + array[k]);
						found = true;
					}
				}
			}
		}
		if (found == false)
			System.out.println("Triplets not Exist...");
	}

	/**
	 * This method calculates distance between two points
	 * 
	 * @param initial1
	 * @param initial2
	 * @param final1
	 * @param final2
	 */
	public static void findDistance(int initial1, int initial2, int final1, int final2) {
		double distance;
		distance = Math.sqrt((initial1 * final1) + (initial2 * final2));
		System.out.println("Distance between initial and final points" + distance);
		System.out.println("" + Math.round(distance * 10000.0) / 10000.0);

	}

	/**
	 * This method is to calculate Permutation
	 * 
	 * @param string
	 * @param left
	 * @param right
	 */
	public void permute(String string, int left, int right) {
		if (left == right)
			System.out.println(string);
		else {
			for (int i = left; i <= right; i++) {
				string = swap(string, left, i);
				permute(string, left + 1, right);
				string = swap(string, left, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	/**
	 * Iterative method to find permutation of string
	 * 
	 * @param string
	 * @param length
	 */
	public static void permutations(String string, int length) {
		char[] str = string.toCharArray();
		Arrays.sort(str);

		while (true) {
			System.out.print(String.valueOf(str) + " ");

			int i = length - 1;
			while (str[i - 1] >= str[i]) {
				if (--i == 0)
					return;
			}
			int j = length - 1;
			while (j > i && str[j] <= str[i - 1])
				j--;

			swap(str, i - 1, j);
			reverse(str, i, length - 1);
		}
	}

	/**
	 * This method is to swap the string
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void swap(char[] array, int i, int j) {
		char c = array[i];
		array[i] = array[j];
		array[j] = c;
	}

	/**
	 * This method is to reverse the string
	 * 
	 * @param array
	 * @param i
	 * @param j
	 */
	private static void reverse(char[] array, int i, int j) {
		while (i < j) {
			swap(array, i++, j--);
		}
	}

	/**
	 * This method calculates the time between start and stop watch
	 * 
	 */
	public static void stopWatch() {

		System.out.println("Press 1 to Start the time:");
		scanner.nextLong();
		long startTime = System.currentTimeMillis();
		System.out.println("Start time.." + startTime);

		System.out.println("Press 2 to stop the time:");
		scanner.nextLong();
		long stopTime = System.currentTimeMillis();
		System.out.println("Stop Time." + stopTime);

		long elapsedTime = stopTime - startTime;
		// System.out.println("Elapsed time between start and stop.."
		// +elapsedTime);
		System.out.println("Elapsed time: " + (elapsedTime / 1000) % 60 + "sec");
	}

	/**
	 * This method is to find the square root
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public double root(int a, int b, int c) {
		double root1, root2;
		double delta = ((b * b) - (4 * a * c));

		if (delta > 0) {
			System.out.println("Roots are real and unequal");
			root1 = (-b + Math.sqrt(delta)) / (2 * a);
			root2 = (-b - Math.sqrt(delta)) / (2 * a);
			System.out.println("First root is:" + root1);
			System.out.println("Second root is:" + root2);
		}

		else if (delta == 0) {
			System.out.println("Roots are real and equal");
			root1 = (-b + Math.sqrt(delta)) / (2 * a);
			System.out.println("Root:" + root1);
		} else {
			System.out.println("Roots are imaginary");
		}
		return delta;
	}

	/****
	 * This method is to calculate WindChill
	 * 
	 * @param temperature
	 * @param velocity
	 * @return
	 */
	public double wind(double temperature, double velocity) {
		double windchill = 35.74 + 0.6215 * temperature + (0.4275 - 35.75) * Math.pow(velocity, 0.16);
		return windchill;
	}

	/**
	 * AlGORITHM LOGICS
	 */

	/****
	 * This method is to find the one string anagram of another
	 * 
	 * @param string1
	 * @param string2
	 * @return
	 */
	public static boolean isAnagram(String string1, String string2) {
		// int n1=string1.length();
		// int n2=string2.length();
		char n1[] = string1.replace(" ", "").toLowerCase().toCharArray();
		char n2[] = string2.replace(" ", "").toLowerCase().toCharArray();

		Arrays.sort(n1);
		Arrays.sort(n2);

		if (n1.length != n2.length) {
			return false;
		} else {

			for (int i = 0; i < n1.length; i++) {

				@SuppressWarnings("unused")
				boolean isAnagram;
				if (n1[i] == n2[i]) {
					isAnagram = true;
				} else {
					isAnagram = false;
					break;
				}
			}
		}
		return true;
		// System.out.println(string1.compareTo(string2));
	}

	/****
	 * This method is to find prime number between a given range
	 * 
	 * @return
	 ****/
	public String prime(int lowerLimit, int upperLimit) {
		System.out.println("Prime numbers between " + lowerLimit + "-" + upperLimit);

		String primeNumber = null;
		for (int i = lowerLimit; i <= upperLimit; i++) {
			int flag = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					flag = 0;
					break;
				} else {
					flag = 1;
				}
			}
			if (flag == 1) {
				primeNumber = "" + i;
				String[] anagram = primeNumber.split(" ", +i);
				System.out.println(primeNumber);
				for (String a : anagram)
					System.out.println(a);
			}
		}
		return primeNumber;
	}

	public static boolean anagramDetection(String anagram1, String anagram2) {

		char char1[] = anagram1.toCharArray();
		char char2[] = anagram2.toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		String string1 = String.valueOf(char1);
		String string2 = String.valueOf(char2);

		if (!string1.equals(string2))
			return false;

		return true;
	}

	public static void palindromeNumber(String[] anagramNumber) {
		// Object arraysAnagram;
		int[] numbers = new int[anagramNumber.length];
		for (int i = 0; i < anagramNumber.length; i++) {
			numbers[i] = Integer.parseInt(anagramNumber[i]);
		}
		int temp, reverse_num, rem = 0, i = 0, num = 0;
		while (i < numbers.length) {
			temp = numbers[i];
			num = temp;
			reverse_num = 0;
			while (temp != 0) {
				rem = temp % 10;
				temp = temp / 10;
				reverse_num = reverse_num * 10 + rem;
			}
			i++;
			if (num == reverse_num)
				System.out.print(" " + num);
		}
	}

	/**
	 * This method sort the array using insertion sort
	 * 
	 * @param array
	 */
	public static <T extends Comparable<T>> T[] insertionSort(T[] array) {

		int i, temporary;
		for (i = 1; i < array.length; i++) {
			T key = array[i];
			temporary = i;

			while (temporary > 0 && array[temporary - 1].compareTo(key) > 0) {
				array[temporary] = array[temporary - 1];
				temporary--;
			}
			array[temporary] = key;
		}
		return array;
	}

	/**
	 * THis method sorts list of elements using bubble sort
	 * 
	 * @param array
	 * @return
	 */
	public static <T extends Comparable<T>> T[] bubbleSort(T[] array) {
		int i, j;
		int length = array.length;
		for (i = 0; i < length; i++) {
			for (j = 1; j < length - i; j++) {
				if ((array[j - 1]).compareTo(array[j]) > 0) {
					T temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	/**
	 * This method search a element in sorted list using binary search Generic
	 * method to search integer as well as string
	 * 
	 * @param array
	 * @param key
	 * @return
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] array, T key, int left, int right) {

		if (left > right)
			return 0;

		int mid = (left + right) / 2;

		if (array[mid].equals(key))
			return 1;
		else if ((array[mid]).compareTo(key) > 0)
			return binarySearch(array, key, left, mid - 1);
		else
			return binarySearch(array, key, mid + 1, right);
	}

	/**
	 * This method prints a sorted array
	 * 
	 * @param array
	 */
	public static <T> void printArray(T[] array) {
		System.out.println("\n" + "Sorted list :");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " " + "\n");

	}

	/**
	 * This method takes a command-line argument N, asks you to think of a
	 * number between 0 and N-1,and always guesses the answer with n questions.
	 * 
	 * @param low
	 * @param high
	 * @return
	 */
	public static int search(int low, int high) {
		if ((high - low) == 1)
			return low;
		int mid = low + (high - low) / 2;
		System.out.printf("Is it less than %d?  ", mid);
		System.out.println();
		System.out.println("Enter the true or false to find your number");
		boolean b = scanner.nextBoolean();
		if (b)
			return search(low, mid);
		else
			return search(mid, high);
	}

	/**
	 * This method l is for left index and r is right index of the sub-array of
	 * array to be sorted
	 * 
	 * @param array
	 */
	public static void mergesort(int[] array) {
		int number = array.length;

		if (number < 2)
			return;

		int mid = number / 2;

		int left[] = new int[mid];
		int right[] = new int[number - mid];

		for (int i = 0; i < mid; i++)
			left[i] = array[i];
		for (int i = mid; i < number; i++)
			right[i - mid] = array[i];

		mergesort(left);
		mergesort(right);
		merge(left, right, array);
	}

	/**
	 * This method merges two sub-arrays
	 * 
	 * @param left
	 * @param right
	 * @param array
	 */
	public static void merge(int[] left, int[] right, int[] array) {

		int i = 0, j = 0, k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				array[k] = left[i];
				i++;
			} else if (right[j] < left[i]) {
				array[k] = right[j];
				j++;
			}
			k++;
		}
		while (i < left.length) {
			array[k++] = left[i];
			i++;
		}
		while (j < right.length) {
			array[k++] = right[j];
			j++;
		}
	}

	/**
	 * This method prints the array
	 * 
	 * @param array
	 */
	public static void printArray(int[] array) {
		System.out.println("Sorted array list :");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}

	/**
	 * This program to calculate the minimum number of Notes as well as the
	 * Notes to be returned by the Vending Machine as a Change
	 * 
	 * @param notes
	 * @param amount
	 * @param length
	 * @return
	 */
	public static int vendingMachine(int notes[], int amount, int length) {
		int count = 0;
		for (int i = length - 1; i >= 0; i--) {
			while (amount >= notes[i]) {
				amount -= notes[i];
				System.out.print("Amount contains notes of:");
				System.out.println(+notes[i]);
				count++;
			}
		}
		System.out.println();
		return count;
	}

	/**
	 * This program is to find day of week
	 * 
	 * @param month
	 * @param day
	 * @param year
	 * @return
	 */
	public static int dayOfWeek(int month, int date, int year) {
		// System.out.println("Entered date is : " + month + "/" + date + "/" +
		// year);
		int y0 = year - (14 - month) / 12;
		int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		int m0 = month + 12 * ((14 - month) / 12) - 2;
		int d0 = (date + x + 31 * m0 / 12) % 7;
		return d0;
	}

	/**
	 * This method takes temperature input in fahrenheit, outputs the
	 * temperature in Celsius or viceversa
	 */

	public static void temperatureConversion() {
		// TODO Auto-generated method stub
		System.out.println("\nEnter 1 for Fahrenheit to Celsius" + "\nEnter 2 for Celsius to Fahrenheit"
				+ "\nSomething else to Exit." + "\nYour Option:");
		int selection = scanner.nextInt();
		if (selection == 1) {
			System.out.println("Enter a degree in Fahrenheit:");
			fahrenheitToCelsius();
		} else if (selection == 2) {
			System.out.println("Enter a degree in Celsius:");
			celsiusToFahrenheit();
		} else {
			System.out.println("Invalid");
		}

	}

	/**
	 * This method converts celcius to fahrenhiet
	 * 
	 */
	private static void celsiusToFahrenheit() {
		// TODO Auto-generated method stub
		Double celsius = scanner.nextDouble();
		System.out.println(celsius + " celsius is " + ((celsius * 9 / 5.0) + 32) + " Fahrenheit");
		temperatureConversion();
	}

	/**
	 * This method converts fehrenhiet to celcius
	 * 
	 */
	private static void fahrenheitToCelsius() {
		// TODO Auto-generated method stub
		Double Fahrenheit = scanner.nextDouble();
		System.out.println(Fahrenheit + " Fahrenheit is " + ((Fahrenheit - 32) * (5 / 9.0)) + " celsius");
		temperatureConversion();
	}

	/**
	 * This method calculates the monthly payment using formula
	 * 
	 * @param principalLoan
	 * @param years
	 * @param rateOfInterest
	 */
	public static void monthlyPayment(int principalLoan, int years, double rateOfInterest) {

		int n = 12 * years;
		double result = rateOfInterest / (12 * 100);
		double payment = (principalLoan * result) / (1 - Math.pow(1 + result, (-n)));

		System.out.println("The output is...." + payment);
	}

	/**
	 * This method used to calculate square root
	 * 
	 * @param c
	 */
	public static void sqrt(int c) {
		double t = c;
		double epsilon = 1e-15;
		while (Math.abs(t - c / t) > (epsilon * t)) {
			t = (c / t + t) / 2.0;

		}
		System.out.println("The Result is.." + t);
	}

	/**
	 * This method converts the decimal number
	 * 
	 * @param decimal
	 * @return
	 */
	public static String toBinary(int decimal) {
		String binary = "";
		while (decimal > 0) {
			binary = decimal % 2 + binary;
			decimal = decimal / 2;
		}
		return binary;
	}

	/**
	 * This method to convert binary to decimal
	 * 
	 * @param array
	 * @param sum
	 * @return
	 */
	public static double toDecimal(char[] array, double sum) {
		int temp = 0;
		String powerTwo = "";
		// System.out.println("" +array.length);
		for (int i = array.length - 1; i >= 0; i--) {
			if (array[i] == '1') {
				sum = sum + (Math.pow(2, temp));
				if (temp < array.length - 1)
					powerTwo = powerTwo + (Math.pow(2, temp)) + "+";
				else
					powerTwo = powerTwo + (Math.pow(2, temp)) + "=";
			}
			temp++;
		}
		System.out.print(powerTwo);
		System.out.println(sum);
		return sum;
	}

	/**
	 * This method to check power of two
	 * 
	 * @param result
	 * @return
	 */
	public static boolean isPowerOfTWo(int result) {
		return result != 0 && ((result & (result - 1)) == 0);
	}

	/**
	 * DATA STRUCTURE LOGICS
	 */

	/**
	 * This method reads the data from file and find a word in a file,if it is
	 * found than added to file else removed from file.
	 */
	public static void unOrderedList() {
		try {
			boolean key = false;
			File file = new File("/home/bridgelabz/Documents/file1.txt");
			BufferedReader buffer = new BufferedReader(new FileReader(file));

			String words = buffer.readLine();

			FileWriter fileWriter = new FileWriter("/home/bridgelabz/Documents/file1.txt");
			String[] string = words.split(" ");
			LinkedList<String> linkedlist = new LinkedList<String>();

			for (int i = 0; i < string.length; i++) {
				linkedlist.add(string[i]);
			}

			// System.out.println(linkedlist);
			System.out.println(linkedlist.toString());
			System.out.println("Enter the string to search :");
			String find = Utility.getString();

			for (int i = 0; i < linkedlist.size(); i++) {
				if (linkedlist.get(i).equals(find)) {
					linkedlist.remove(string[i]);
					key = true;
					break;
				}
			}
			System.out.println(linkedlist.toString());
			if (key == false) {

				linkedlist.add(find);
			}

			if (key == true) {
				for (int i = 0; i < linkedlist.size(); i++) {
					String string2 = (linkedlist.get(i)) + " ";
					fileWriter.write(string2);
					fileWriter.flush();
				}
			} else {
				for (int i = 0; i < linkedlist.size(); i++) {
					String string3 = linkedlist.get(i) + " ";
					fileWriter.write(string3);
					fileWriter.flush();
				}
			}
			System.out.println(linkedlist.toString());
			buffer.close();
			fileWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method reads the data from file and find a Integer in a file,if it
	 * is found than added to file else removed from file.
	 */
	public static void orderedList() {
		try {
			boolean key = false;

			// get a file
			File file = new File(
					"/home/bridgelabz/SANAworkspace/BasicProgram/src/" + "com/bridgelabz/dataStructure/file2.txt");
			BufferedReader buffer = new BufferedReader(new FileReader(file));

			String words = buffer.readLine();

			// write back to file
			FileWriter fileWriter = new FileWriter(
					"/home/bridgelabz/SANAworkspace/BasicProgram/src/" + "com/bridgelabz/dataStructure/file2.txt");

			// splits words of file
			String[] string = words.split(" ");

			// Initialize a linked list
			LinkedList<String> linkedlist = new LinkedList<String>();

			// add Elements to linked list
			for (int i = 0; i < string.length; i++) {
				linkedlist.add(string[i]);
			}

			// System.out.println(linkedlist);
			System.out.println(linkedlist.toString());

			System.out.println("Enter the string to search :");
			String find = Utility.getString();

			// If search word is same then remove it
			for (int i = 0; i < linkedlist.size(); i++) {
				if (linkedlist.get(i).equals(find)) {
					linkedlist.remove(string[i]);
					key = true;
					break;
				}
			}
			System.out.println(linkedlist.toString());

			// if new word add to String
			if (key == false) {

				linkedlist.add(find);
			}

			if (key == true) {
				for (int i = 0; i < linkedlist.size(); i++) {
					String string2 = (linkedlist.get(i)) + " ";
					fileWriter.write(string2);
					fileWriter.flush();
				}
			} else {
				for (int i = 0; i < linkedlist.size(); i++) {
					String string3 = linkedlist.get(i) + " ";
					fileWriter.write(string3);
					fileWriter.flush();
				}
			}
			System.out.println(linkedlist.toString());
			buffer.close();
			fileWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method to read from from the list of numbers
	 * 
	 * @param list
	 */
	public static <T> void readingDataFromFile(LinkedList<T> list) throws IOException {
		try {
			// read file from particular location
			file = new File(
					"/home/bridgelabz/SANAworkspace/BasicProgram/src/" + "com/bridgelabz/dataStructure/file2.txt");
			try {
				// check weather file is present or not
				if (file.exists()) {

					// check for read permisssion
					if (file.canRead()) {
						// scans file contents
						while (scanner.hasNext()) {// checks for next token
							Integer number = Utility.getInteger();
							list.add((T) number); // add to linked list
							list.sort(null);
						}
						System.out.println(list);
					} else {
						System.out.println("You can't read file");
					}
				} else {
					System.out.println("File does not exits.");
				}
			} catch (Exception FileNotFoundException) {
				System.out.println("File does not exits.");
			}
		} catch (Exception e) {
			System.out.println("Exception raised");
		}
		System.out.println();
	}

	/**
	 * This method search data from file
	 * 
	 * @param linkedlist
	 * @param search
	 */
	public static <T> void searchFromFile(LinkedList<T> list, T search) throws IOException {

		{
			if (list.contains(search)) { // checks for the element present in
				// the list
				System.out.println("Integer found in the list and it is deleted from list.");
				list.remove((Integer) search);
				list.sort(null);
				System.out.println(list);
			} else {
				System.out.println("Integer not found in the list and it is added to list.");
				list.add(search);
				list.sort(null);
				System.out.println(list);
			}
		}
	}

	/**
	 * This method writes the data back to the file
	 * 
	 * @param linkedlist
	 */
	public static <T> void writeDataToFile(LinkedList<Integer> list) throws IOException {
		// TODO Auto-generated method stub
		{
			try {
				// read file from particular location
				File file = new File("/home/bridgelabz/Documents/file2.txt");
				if (file.exists())
				// checks weather file is present or not
				{
					// checks for write permission
					if (file.canWrite()) {
						// reads text from a character-input stream
						BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

						String string = "";
						for (int ele : list) {
							string += ele + " ";
						}
						bufferedWriter.write(string);
						bufferedWriter.flush();
						bufferedWriter.close();
					}

					else {
						System.out.println("You cant edit the file!!. Its does not have edit permission.");
					}
				} else {
					System.out.println("File not exits.");
					return;
				}
			} catch (Exception e) {
				// trace exception where actual problem occured
				System.out.println("Exception raised");
			}
		}
	}

	/**
	 * This method push open parenthesis “(“ and pop closed parenthesis “) and
	 * outputs true or False to Show Arithmetic Expression is balanced or not.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isValid(String string) {
		int count = 0;
		// initialize an empty stack
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < string.length(); i++) {
			// returns the specified index from 0 to n-1
			if (string.charAt(i) == '(') {
				// push an element to stack and and returns
				// char value at specified location
				stack.push(string.charAt(i));
				count++;
			}

			if (string.charAt(i) == ')') {
				// if nothing on stack decrease count else
				// removes the top element
				if (stack.isEmpty()) {
					count--;
				} else {
					stack.pop();
					count--;
				}
			}
		}

		if (stack.isEmpty() && count == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * SIMULATE BANKING CASH COUNTER
	 */
	/**
	 * This method is to add people in queue
	 * 
	 * @param numberOfPeople
	 */
	public static void getDetails() {

		GenericQueue<String> queue = new GenericQueue<String>();
		for (int i = 0; i < 3; i++) {
			System.out.print("Enter Nominee Name: ");
			String name = Utility.getString();
			queue.enqueue(name);

			System.out.println("Enter your Account Number:");
			int number = Utility.getInteger();
			queue.enqueue(number);
		}
	}

	/**
	 * This method is to deposit cash
	 * 
	 * @param cash
	 */
	public static void deposite(int cash) {

		// Utility.getDetails();
		System.out.println("Available balance:" + cash);
		System.out.println("Enter amount to deposite");
		int amount = Utility.getInteger();
		cash = cash + amount;
		System.out.println("Transaction sucessfull!!!");
		System.out.println("Available balance: " + cash);
	}

	/**
	 * This method is to withdraw amount from account
	 * 
	 * @param cash
	 */
	public static void withdraw(int cash) {

		// Utility.getDetails();
		System.out.println("Available balance:" + cash);
		System.out.println("Enter amount to withdraw");
		int amount = Utility.getInteger();
		if (amount <= cash) {
			cash = cash - amount;
			System.out.println("Transaction sucessfull!!!");
		} else
			System.out.println("Balance is less !!! \n Cannot do transaction");
		System.out.println("Available balance: " + cash);
	}

	/**
	 * This method is to check palindrome
	 * 
	 * @param lowerString
	 */
	public static void palindromeChecker(String lowerString) {
		// Initializing array Deque
		ArrayDeque<Character> arrayDeque = new ArrayDeque<Character>();

		for (int i = lowerString.length() - 1; i >= 0; i--) {
			// add method to add elements
			arrayDeque.add(lowerString.charAt(i));
		}

		String reverseString = "";

		// writtens false if deque contains no elements
		while (!arrayDeque.isEmpty()) {
			reverseString = reverseString + arrayDeque.remove();
		}
		if (lowerString.equals(reverseString))
			System.out.println("The input String is a palindrome.");
		else
			System.out.println("The input String is not a palindrome.");
	}

	/**
	 * This method is find number of binary trees generated using recursion.
	 * 
	 * @param node
	 * @return
	 */
	public static int find(int node) {
		{
			int sum = 0;

			if (node <= 1)
				return 1;
			else {
				for (int i = 1; i <= node; i++) {
					sum = (int) (sum + (find(i - 1) * find(node - i)));
				}
			}
			return sum;

		}
	}

	/**
	 * This method to check prime number
	 * 
	 * @param num
	 * @return
	 */
	public static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method is to check anagram or not
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static Boolean anagramChecker2(int number1, int number2) {
		String numberToString1 = Integer.toString(number1);
		String numberToString2 = Integer.toString(number2);
		boolean status = true;

		if (numberToString1.length() != numberToString2.length()) {
			status = false;
			// System.out.println("false");
		} else {
			char[] ArrayS1 = numberToString1.toCharArray();
			char[] ArrayS2 = numberToString2.toCharArray();
			Arrays.sort(ArrayS1);
			Arrays.sort(ArrayS2);
			status = Arrays.equals(ArrayS1, ArrayS2);
		}
		if (status) {
			// System.out.println(number1 + " and " + number2 + " are
			// anagrams");
			return true;
		} else {
			// System.out.println(number1 + " and " + number2 + " are not
			// anagrams");
			return false;
		}
	}

	/**
	 * OBJECT ORIENTED LOGICS
	 */

	/**
	 * This method is to calculate Inventory Cost
	 */
	public static void inventoryManagement() {
		JSONParser parser = new JSONParser();

		try {
			Object object = parser.parse(new FileReader("/home/bridgelabz/SANAworkspace/BasicProgram"
					+ "/src/com/bridgelabz/objectOriented/inventory1.json"));

			JSONObject jsonObject = (JSONObject) object;
			// System.out.println(jsonObject);

			double amount = 0, totalAmount = 0;

			JSONArray Itemlist = (JSONArray) jsonObject.get("Itemlist");

			Iterator<?> iterator = Itemlist.iterator();

			while (iterator.hasNext()) {
				JSONObject jsonObject1 = (JSONObject) iterator.next();

				double weight = Double.parseDouble(jsonObject1.get("weight").toString());
				System.out.println("InventoryDetails : " + jsonObject1.get("item_Name") + " " + weight + " " + "kg"
						+ " " + "40Rs/kg");

				double price = Double.parseDouble(jsonObject1.get("price").toString());

				amount = weight * price;
				totalAmount = amount + totalAmount;
				// System.out.println("Total Inventary cost.." + totalAmount+
				// "\n");
			}
			System.out.println("\n" + "Total Inventary cost.." + totalAmount);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to replace the regular expression
	 * 
	 * @param message
	 * @param firstName
	 * @param fullName
	 * @param mobileNumber
	 * @param date
	 */
	public static void regexExpression(String message, String firstName, String fullName, String mobileNumber,
			String date) {
		// TODO Auto-generated method stub
		String replacefname = message.replace("<<name>>", firstName);
		String replacefullname = replacefname.replace("<<full name>>", fullName);
		String replacemobileNumber = replacefullname.replace("xxxxxxxxxx", mobileNumber);
		String replacedate = replacemobileNumber.replace("01/01/2016", date);
		System.out.println(replacedate);
	}

	/**
	 * This method is to calculate total stock value
	 */
	public static void stockReport() {
		// TODO Auto-generated method stub
		JSONObject object = new JSONObject();

		System.out.println("Enter number of stocks:");
		int numberOfStock = Utility.getInteger();
		// object.put("Number Of Stocks", numberOfStock);

		JSONArray stockArray = new JSONArray();
		for (int i = 0; i < numberOfStock; i++) {
			JSONObject object1 = new JSONObject();

			System.out.println("\n" + "Enter Name of Company:");
			String shareName = Utility.getString();
			object1.put("Share Name:", shareName);

			System.out.println("Enter the Price of shares:");
			int sharePrice = Utility.getInteger();
			object1.put("Share Price:", sharePrice);

			System.out.println("Enter Number of shares:");
			int numberOfShares = Utility.getInteger();
			object1.put("Number Of Shares:", numberOfShares);

			int totalValue = sharePrice * numberOfShares;
			object1.put("Total Value of stock:", totalValue);

			stockArray.add(object1);

			System.out.println("\n" + "*****Stock Report*****" + "\n");
			System.out.println("Company Name       : " + shareName);
			System.out.println("Share Price        : " + sharePrice);
			System.out.println("Number of Shares   : " + numberOfShares);
			System.out.println("Total Cost of Share: " + (totalValue));
		}
		object.put("Stock Details:", stockArray);
		// System.out.println("\n" +"Total value of Stock.." +
		// object.add(totalValue));

		try {
			fileWriter = new FileWriter(
					"/home/bridgelabz/SANAworkspace/BasicProgram/src/" + "com/bridgelabz/objectOriented/stock.json");
			fileWriter.write(object.toString());

			fileWriter.flush();
			System.out.println("\n" + "Successfully Copied JSON Object to File..");
			System.out.println("\nJSON Object: " + object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to create Company Shares
	 * 
	 * @throws IOException
	 * @throws org.json.simple.parser.ParseException
	 */
	public static void companyShares() throws IOException, org.json.simple.parser.ParseException {
		// TODO Auto-generated method stub
		file = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src/"
				+ "com/bridgelabz/objectOriented/companyShares.json");
		fileReader = new FileReader(file);

		// initialize JSon parser
		JSONParser parser = new JSONParser();

		// create a JSon array parse the file
		JSONArray jsonArray = (JSONArray) parser.parse(fileReader);
		// System.out.println(jsonArray.size());

		// create a JSon object
		JSONObject jsonObject = new JSONObject();

		System.out.println("Enter Your Share symbol ex:'@','#','$':");
		String ShareSymbol = Utility.getString();
		jsonObject.put("ShareSymbol", ShareSymbol);

		System.out.println("Enter price of share:");
		int price = Utility.getInteger();
		jsonObject.put("SharePrice", price);

		System.out.println("Enter number of Shares you want to purchase:");
		int shareCount = Utility.getInteger();
		jsonObject.put("ShareCount", shareCount);

		jsonArray.add(jsonObject);

		fileWriter = new FileWriter(file);
		// writing back JSon file to JSonArray
		fileWriter.write(JSONValue.toJSONString(jsonArray));
		fileWriter.flush();
		fileWriter.close();
	}

	/**
	 * This method is to create a user.
	 * 
	 * @throws IOException
	 * @throws ParseException
	 * @throws org.json.simple.parser.ParseException
	 * @throws org.json.simple.parser.ParseException
	 * @throws Throwable
	 */

	public static void createUser() throws IOException, ParseException, 
										   org.json.simple.parser.ParseException {

		boolean checkUser = true;

		file = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src/" + 
						"com/bridgelabz/objectOriented/userDetails.json");
		
		fileReader = new FileReader(file);

		// initialize JSon parser
		JSONParser parser = new JSONParser();

		// create a JSon array parse the file
		JSONArray jsonArray = (JSONArray) parser.parse(fileReader);
		// System.out.println(jsonArray.size());

		// create a JSon object
		JSONObject jsonObject = new JSONObject();

		// input values from user add to JSOn object
		System.out.println("Enter First Name");
		String name = Utility.getString();
		jsonObject.put("userName", name);

		System.out.println("Enter Number of Shares");
		String numberOfShare = Utility.getString();
		jsonObject.put("numberOfShare", numberOfShare);

		System.out.println("Enter your balance");
		String balance = Utility.getString();
		jsonObject.put("balance", balance);

		// all values of object adding to JSOn array
		jsonArray.add(jsonObject);

		if (checkUser) {
			fileWriter = new FileWriter(file);
			// writing back JSon file to JSonArray
			fileWriter.write(jsonArray.toJSONString());
			fileWriter.flush();
			fileWriter.close();
		}
	}

	/**
	 * This method is to buy share
	 * 
	 * @throws IOException
	 * @throws org.json.simple.parser.ParseException
	 */
	public static void buyShare() throws IOException, org.json.simple.parser.ParseException {
		// TODO Auto-generated method stub
		File file1 = new File(
				"/home/bridgelabz/SANAworkspace/BasicProgram/src/" + "com/bridgelabz/objectOriented/userDetails.json");

		File file2 = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src/"
				+ "com/bridgelabz/objectOriented/companyShares.json");

		// check for the existence of the file
		if (file1.exists() && file2.exists()) {

			// Reading userDetails file
			fileReader = new FileReader(file1);
			JSONParser parser = new JSONParser();
			JSONArray userDetails = (JSONArray) parser.parse(fileReader);
			// System.out.println(""+userDetails);

			// Reading shares file
			fileReader = new FileReader(file2);
			JSONParser parser1 = new JSONParser();
			JSONArray shares = (JSONArray) parser1.parse(fileReader);
			// System.out.println("" +shares);

			// for userDeatils.json
			Iterator<?> iterator = userDetails.iterator();

			// for companyShares.json
			Iterator<?> iterator1 = shares.iterator();

			System.out.println("Enter your name Existing User:");
			String name = Utility.getString();

			// check in user details for next
			while (iterator.hasNext()) {

				// JSON object for userDeatils
				JSONObject object = (JSONObject) iterator.next();

				if (object.get("userName").equals(name)) {
					// System.out.println(""+object.get("userName"));

					System.out.println("Enter your share symbol you want to buy:[@,#,$,!]");
					String symbol = Utility.getString();
					object.put("ShareSymbol", symbol);

					Stack stack = new Stack();
					stack.push(symbol);
					// System.out.println("Stack symbol" +stack);

					// Check in company Shares share symbol
					while (iterator1.hasNext()) {

						// created object1 for Company Shares
						JSONObject object1 = (JSONObject) iterator1.next();

						if (object1.get("ShareSymbol").equals(symbol)) {
							// System.out.println(""+object.get("ShareSymbol"));

							System.out.println("Enter number of shares you want to buy:");
							int buy = Utility.getInteger();

							// get balance from user
							int balance = Integer.parseInt(object.get("balance").toString());
							// System.out.println("userbalance"+" "+balance);

							// get price from company share
							int price = Integer.parseInt(object1.get("price").toString());
							// System.out.println("company shareprice"+"
							// "+price);

							// get number of share user have
							int numberOfShare = Integer.parseInt(object.get("numberOfShare").toString());
							// System.out.println("number of share user have"+"
							// "+numberOfShare);

							// get share count company have
							int shareCount = Integer.parseInt(object1.get("shareCount").toString());
							// System.out.println("shareCountcompany"+"
							// "+shareCount+"\n");

							int newBalance = balance - (price * buy);
							// System.out.println("newBalance"+" "+newBalance);

							int updateNumberOfShare = numberOfShare + buy;
							// System.out.println("updateNumberOfShare"+"
							// "+updateNumberOfShare);

							int shareCountCompany = shareCount - buy;
							// System.out.println("shareCountCompany"+"
							// "+shareCountCompany);

							object.remove("balance");
							object.remove("numberOfShare");
							object.remove("shareCount");

							object.put("balance", newBalance);
							object.put("numberOfShare", updateNumberOfShare);
							object1.put("shareCount", shareCountCompany);

							LinkedList<String> queue = new LinkedList<String>();
							Date date = new Date();
							String currentDateTime = new SimpleDateFormat("E dd/MM/yyyy. 'at' hh:mm:ss a").format(date);
							queue.add(currentDateTime);
							System.out.println("Date and Time of Share Purchase:" + " " + currentDateTime + "\n");

						}

						fileWriter = new FileWriter(file1);
						// writing back JSon file to JSonArray
						fileWriter.write(JSONValue.toJSONString(userDetails));
						fileWriter.flush();
						fileWriter.close();
					}
					fileWriter = new FileWriter(file2);
					// writing back JSon file to JSonArray
					fileWriter.write(JSONValue.toJSONString(shares));
					fileWriter.flush();
					fileWriter.close();
				}
			}
		}
	}

	/**
	 * This method is to sell a share
	 * 
	 * @throws Throwable
	 */
	public static void sellShare() throws Throwable {
		File file1 = new File(
				"/home/bridgelabz/SANAworkspace/BasicProgram/src/" + "com/bridgelabz/objectOriented/userDetails.json");

		File file2 = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src/"
				+ "com/bridgelabz/objectOriented/companyShares.json");

		// check for the existence of the file
		if (file1.exists() && file2.exists()) {

			// Reading userDetails file
			fileReader = new FileReader(file1);
			JSONParser parser = new JSONParser();
			JSONArray userDetails = (JSONArray) parser.parse(fileReader);
			// System.out.println(""+userDetails);

			// Reading shares file
			fileReader = new FileReader(file2);
			JSONParser parser1 = new JSONParser();
			JSONArray shares = (JSONArray) parser1.parse(fileReader);
			// System.out.println("" +shares);

			// for userDeatils.json
			Iterator<?> iterator = userDetails.iterator();

			// for companyShares.json
			Iterator<?> iterator1 = shares.iterator();

			System.out.println("Enter your name Existing User:");
			String name = Utility.getString();

			// check in user details for next
			while (iterator.hasNext()) {

				// JSON object for userDeatils
				JSONObject object = (JSONObject) iterator.next();

				if (object.get("userName").equals(name)) {
					// System.out.println(""+object.get("userName"));

					System.out.println("Enter your share symbol you want to sell:[@,#,$,!]");
					String symbol = Utility.getString();
					object.put("ShareSymbol", symbol);

					Stack stack = new Stack();
					stack.push(symbol);

					// Check in company Shares share symbol
					while (iterator1.hasNext()) {

						// created object1 for Company Shares
						JSONObject object1 = (JSONObject) iterator1.next();

						if (object.get("ShareSymbol").equals(symbol)) {
							// System.out.println(""+object.get("ShareSymbol"));

							System.out.println("Enter number of shares you want to sell:");
							int sell = Utility.getInteger();

							// get balance from user
							int balance = Integer.parseInt(object.get("balance").toString());
							// System.out.println("Balance of User"+"
							// "+balance);

							// get number of share user have
							int numberOfShare = Integer.parseInt(object.get("numberOfShare").toString());
							// System.out.println("Number of share user have"+"
							// "+numberOfShare);

							// get price of share
							int price = Integer.parseInt(object1.get("price").toString());
							// System.out.println("Price per Share"+" "+price);

							// get share count company have
							int shareCount = Integer.parseInt(object1.get("shareCount").toString());
							// System.out.println("ShareCount of the company"+"
							// "+shareCount+"\n");

							int newBalance = balance + (price * sell);
							// System.out.println("NewBalance of user"+"
							// "+newBalance);

							int updateNumberOfShare = numberOfShare - sell;
							// System.out.println("updateNumberOfShare"+"
							// "+updateNumberOfShare);

							int shareCountCompany = shareCount + sell;
							// System.out.println("shareCountCompany"+"
							// "+shareCountCompany);

							object.remove("balance");
							object.remove("numberOfShare");
							object1.remove("shareCount");

							object.put("balance", newBalance);
							object.put("numberOfShare", updateNumberOfShare);
							object1.put("shareCount", shareCountCompany);

							LinkedList<String> queue = new LinkedList<String>();
							Date date = new Date();
							String currentDateTime = new SimpleDateFormat("E dd/MM/yyyy. 'at' hh:mm:ss a").format(date);
							queue.add(currentDateTime);
							System.out.println("Date and Time of Share sold:" + " " + currentDateTime + "\n");

						}

						fileWriter = new FileWriter(file1);
						// writing back JSon file to JSonArray
						fileWriter.write(JSONValue.toJSONString(userDetails));
						fileWriter.flush();
						fileWriter.close();
					}
					fileWriter = new FileWriter(file2);
					// writing back JSon file to JSonArray
					fileWriter.write(JSONValue.toJSONString(shares));
					fileWriter.flush();
					fileWriter.close();
				}
			}
		}
	}

	/**
	 * This method is to display stock report
	 * 
	 * @throws IOException
	 * @throws org.json.simple.parser.ParseException
	 */
	public static <T> void displayReport() throws IOException, org.json.simple.parser.ParseException {
		File file1 = new File(
				"/home/bridgelabz/SANAworkspace/BasicProgram/src/" + "com/bridgelabz/objectOriented/userDetails.json");

		fileReader = new FileReader(file1);
		JSONParser parser = new JSONParser();
		JSONArray userDetails = (JSONArray) parser.parse(fileReader);

		Iterator<T> iterator = userDetails.iterator();
		System.out.println("\n" + "All user Detail Report:");
		while (iterator.hasNext()) {
			JSONObject object = (JSONObject) iterator.next();
			System.out.println(object);
		}
	}

	/**
	 * This method initialize deck of cards,Shuffle the cards using Random
	 * method and then distribute 9 Cards to 4 Players and Print the Cards the
	 * received by the 4 Players
	 * 
	 * @param suits
	 * @param ranks
	 */
	public static void deckOfCards(String[] suits, String[] ranks) {
		String array[][] = new String[4][9];

		// initialize deck
		int numberOfCards = suits.length * ranks.length;
		String[] deck = new String[numberOfCards];

		// initialize deck
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				deck[suits.length * i + j] = ranks[i] + "->" + suits[j];
				// System.out.print(""+(deck[suits.length*i + j]));
			}
		}

		// shuffle cards
		for (int i = 0; i < numberOfCards; i++) {
			int random = i + (int) (Math.random() * (numberOfCards - i));
			String temp = deck[random];
			deck[random] = deck[i];
			deck[i] = temp;
		}

		// distribute 9 cards to 4 player
		for (int i = 0; i < 4; i++) {
			System.out.print("Player" + (i + 1) + "\n");
			for (int j = 0; j < 9; j++) {
				array[i][j] = (deck[i + j * 4]);
				System.out.print(" " + array[i][j]);
			}
			System.out.println("\n");
		}
	}

	/**
	 * This method is to print deck of card using queue
	 * 
	 * @param suits
	 * @param ranks
	 */
	public static void deckOfCardsQueue(String[] suits, String[] ranks) {

		String array[][] = new String[4][9];

		// initialize deck
		int numberOfCards = suits.length * ranks.length;
		String[] deck = new String[numberOfCards];

		// initialize deck
		for (int i = 0; i < ranks.length; i++) {
			for (int j = 0; j < suits.length; j++) {
				deck[suits.length * i + j] = ranks[i] + "->" + suits[j];
				// System.out.print(""+(deck[suits.length*i + j]));
			}
		}

		// shuffle cards
		for (int i = 0; i < numberOfCards; i++) {
			int random = i + (int) (Math.random() * (numberOfCards - i));
			String temp = deck[random];
			deck[random] = deck[i];
			deck[i] = temp;
		}

		QueueDeck queueDeck = new QueueDeck();
		// distribute 9 cards to 4 player
		for (int i = 0; i < 4; i++) {
			System.out.print("Player" + (i + 1) + "\n");
			for (int j = 0; j < 9; j++) {
				array[i][j] = (deck[i + j * 4]);
				// System.out.println(" " + array[i][j]);
				queueDeck.push(array[i][j]);
				// System.out.println("" + queue);
			}
			System.out.println("\n");
		}
	}

	/**
	 * This method is to add a New person to the address book
	 */
	public static void addNewPerson() {
		try {
			file = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src"
					+ "/com/bridgelabz/objectOriented/addressBook.json");
			if (file.exists()) {

				if (file.canRead() && file.canWrite()) {
					fileReader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray array = (JSONArray) parser.parse(fileReader);

					JSONObject json = new JSONObject();

					System.out.println("Enter First Name:");
					String firstname = Utility.getString();
					// System.out.println("firstname"+firstname);

					System.out.println("Enter Last Name:");
					String lastname = Utility.getString();
					// System.out.println("lastname"+lastname);

					System.out.println("Enter Address:");
					String address = Utility.getString();
					// System.out.println("address"+address);

					System.out.println("Enter City:");
					String city = Utility.getString();
					// System.out.println("city"+city);

					System.out.println("Enter State:");
					String state = Utility.getString();
					// System.out.println("state"+state);

					System.out.println("Enter ZIP Code:");
					String zip = Utility.getString();
					// System.out.println("zip"+zip);

					System.out.println("Enter Mobile Number:");
					String mobile = Utility.getString();
					// System.out.println("mobile"+mobile);

					Map<String, String> map = new HashMap<>();

					json.put("Firstname", firstname);
					json.put("Lastname", lastname);
					json.put("Address", address);
					json.put("City", city);
					json.put("State", state);
					json.put("Zip", zip);
					json.put("Mobile", mobile);

					array.add(json);

					System.out.println("Your details added Successfully." + "\n");
					fileWriter = new FileWriter(file);
					fileWriter.write(JSONArray.toJSONString(array));
					fileWriter.flush();
					fileWriter.close();
				}

				else {
					System.out.println("Cannot read and write to file");
				}
			} else {
				System.out.println("File not exits..");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to edit details of person in Address Book
	 */
	public static void editInformation() {
		{
			try {
				file = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src"
						+ "/com/bridgelabz/objectOriented/addressBook.json");
				if (file.exists()) {
					if (file.canRead() && file.canWrite()) {
						fileReader = new FileReader(file);
						JSONParser parser = new JSONParser();
						JSONArray array = (JSONArray) parser.parse(fileReader);

						Iterator<?> iterator = array.iterator();
						System.out.println("Enter the NAme of person you want to edit details:");
						String name = Utility.getString();
						boolean check = false;
						while (iterator.hasNext()) {
							JSONObject object = (JSONObject) iterator.next();
							if (object.get("Firstname").equals(name)) {
								System.out.println("What you want to edit in Address Book?" + "\n" + "Lastname" + "\n"
										+ "Address" + "\n" + "City" + "\n" + "State" + "\n" + "Zip" + "\n");
								String edit = Utility.getString();
								System.out.println("Enter the new " + edit + " to update.");

								String update = Utility.getString();
								object.remove(edit);
								object.put(edit, update);
								System.out.println("Edited Information Successfully.");
								check = true;
								break;
							}
						}
						if (check == false) {
							System.out.println("Person not found in Address Book" + "\n");
						}
						fileWriter = new FileWriter(file);
						fileWriter.write(JSONArray.toJSONString(array));
						fileWriter.flush();
						fileWriter.close();
					} else {
						System.out.println("Cannot edit a File");
					}
				} else {
					System.out.println("File not exist..");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is to Delete person from addressBook
	 */
	public static void deletePerson() {
		{
			try {
				file = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src"
						+ "/com/bridgelabz/objectOriented/addressBook.json");
				if (file.exists()) {
					if (file.canRead()) {
						fileReader = new FileReader(file);
						JSONParser parser = new JSONParser();
						JSONArray array = (JSONArray) parser.parse(fileReader);

						System.out.println("Enter the user");
						String name = Utility.getString();

						Iterator<?> iterator = array.iterator();
						boolean check = false;
						while (iterator.hasNext()) {
							JSONObject jsonObject = (JSONObject) iterator.next();

							if (jsonObject.get("Firstname").equals(name)) {
								array.remove(jsonObject);
								System.out.println("Deleted Successfully." + "\n");
								check = true;
								break;
							}
						}
						if (check == false) {
							System.out.println("Person do not exist in Address Book." + "\n");
						}
						if (file.canWrite()) {
							fileWriter = new FileWriter(file);
							fileWriter.write(JSONArray.toJSONString(array));
							fileWriter.flush();
							fileWriter.close();
						} else {
							System.out.println("Do not read/write permission");
						}
					}
				} else {
					System.out.println("File not exits..");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * This method is to print the Address Book
	 */
	public static void printAddressBook() {
		{
			try {
				file = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src"
						+ "/com/bridgelabz/objectOriented/addressBook.json");
				if (file.exists()) {
					if (file.canRead() && file.canWrite()) {
						fileReader = new FileReader(file);
						JSONParser parser = new JSONParser();
						JSONArray array = (JSONArray) parser.parse(fileReader);
						Iterator iterator = array.iterator();
						System.out.println("\n" + "****Address Book****");

						while (iterator.hasNext()) {
							JSONObject obj = (JSONObject) iterator.next();
							System.out.println("\n" + "***Person Details***");
							System.out.println("First Name : " + obj.get("Firstname"));
							System.out.println("Last Name  : " + obj.get("Lastname"));
							System.out.println("Address    : " + obj.get("Address"));
							System.out.println("City       : " + obj.get("City"));
							System.out.println("State      : " + obj.get("State"));
							System.out.println("Zip        : " + obj.get("Zip"));
							System.out.println("Mobile     : " + obj.get("Mobile"));
						}
					} else {
						System.out.println("Cannot have read permission" + "\n");
					}
				} else {
					System.out.println("Filenot exist.." + "\n");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * This method is to add Shares
	 */
	public static void addShare() {
		Map list = (Map) new LinkedList<String>();

		try {
			file = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src/com/"
					+ "bridgelabz/objectOriented/linkedShares.json");
			if (file.exists())
				if (file.canRead() && file.canWrite()) {
					fileReader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray array = (JSONArray) parser.parse(fileReader);
					Iterator iterator = ((List) array).iterator();

					while (iterator.hasNext()) {
						JSONObject json = (JSONObject) iterator.next();
						System.out.println("Enter your share you want to add:");
						String share = Utility.getString();
						((ArrayList) list).add(share);
						json.putAll(list);
						array.add(json);
					}
					fileWriter = new FileWriter(file);
					fileWriter.write(JSONArray.toJSONString(array));
					fileWriter.flush();
					fileWriter.close();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void removeShare() {
		Map list = (Map) new LinkedList<String>();

		try {
			file = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src/com/"
					+ "bridgelabz/objectOriented/linkedShares.json");
			if (file.exists())
				if (file.canRead() && file.canWrite()) {
					fileReader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray array = (JSONArray) parser.parse(fileReader);
					Iterator iterator = ((List) array).iterator();

					while (iterator.hasNext()) {
						JSONObject json = (JSONObject) iterator.next();
						System.out.println("Enter index of share you want to Remove:");
						int position = Utility.getInteger();
						((ArrayList) list).remove(position);
						json.putAll(list);
						array.add(json);
					}
					fileWriter = new FileWriter(file);
					fileWriter.write(JSONArray.toJSONString(array));
					fileWriter.flush();
					fileWriter.close();
				}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is to add patient details
	 */
	public static void addPatient() {

		try {
			file = new File(
					"/home/bridgelabz/SANAworkspace/BasicProgram/" + "src/com/bridgelabz/objectOriented/patient.json");
			if (file.exists()) {

				if (file.canRead() && file.canWrite()) {
					fileReader = new FileReader(file);
					JSONParser parser = new JSONParser();
					JSONArray patientArray = (JSONArray) parser.parse(fileReader);

					JSONObject jsonObject1 = new JSONObject();

					System.out.println("Enter patient name:");
					String name = Utility.getString();
					jsonObject1.put("Name", name);

					System.out.println("Enter patient ID:");
					String id = Utility.getString();
					jsonObject1.put("Id", id);

					System.out.println("Enter Mobile number:");
					String mobileNumber = Utility.getString();
					jsonObject1.put("MobileNumber", mobileNumber);

					System.out.println("Enter Age of patient:");
					String age = Utility.getString();
					jsonObject1.put("Age", age);

					patientArray.add(jsonObject1);

					fileWriter = new FileWriter(file);
					fileWriter.write(JSONArray.toJSONString(patientArray));
					fileWriter.flush();
					fileWriter.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to fix appointment of patient with Doctor
	 */
	public static void fixAppointment() 
	{
		try 
		{
			File file1 = new File(
					"/home/bridgelabz/SANAworkspace/BasicProgram/src/" +
					"com/bridgelabz/objectOriented/doctors.json");
			File file2 = new File(
					"/home/bridgelabz/SANAworkspace/BasicProgram/src/" +
					"com/bridgelabz/objectOriented/patient.json");

			File file3 = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src/"
					+ "com/bridgelabz/objectOriented/appointment.json");

			// check for existence of all files
			if (file1.exists() && file2.exists() && file3.exists() && file1.canRead() && file2.canRead() && file3.canRead() && file1.canWrite() && file2.canWrite() && file3.canWrite()) 
			{


				JSONParser parser = new JSONParser();
				fileReader = new FileReader(file1);
				JSONArray doctorsarray = (JSONArray) parser.parse(fileReader);
				// System.out.println(""+doctorsarray.size());
				
				JSONParser parser1=new JSONParser();
				fileReader=new FileReader(file2);
				JSONArray patientArray=(JSONArray) parser1.parse(fileReader);

				Iterator<?> iterator = doctorsarray.iterator();

				System.out.println("****Doctor's Details****");
				while (iterator.hasNext()) {
					JSONObject object = (JSONObject) iterator.next();
					// System.out.println(""+object.size());
					System.out.println("Doctor's Name : " + object.get("Name"));
					System.out.println("Doctor's Id   : " + object.get("Doctor'sId"));
					System.out.println("Speciality    : " + object.get("Speciality"));
					System.out.println("Availability  : " + object.get("Availability"));
					System.out.println("\n");
				}
				System.out.println("Enter Doctor ID to assign to a patient:");
				String doctorId=Utility.getString();
				//System.out.println("Entered ID: "+doctorId);
				
				Iterator<?> iterator1=doctorsarray.iterator();
				
				while(iterator1.hasNext())
				{
					JSONObject object1=(JSONObject) iterator1.next();
					//System.out.println("Drs. Id"+object1.get("Doctor'sId"));
					JSONArray jsonArray = (JSONArray) object1.get("patient");
					if(doctorId.equals(object1.get("Doctor'sId")))
					{
						if(jsonArray.size()<=2){
							
							System.out.println("Enter PAtient ID to take an appointment:");
							String patientId=Utility.getString();
							
							Iterator<?> iterator2=patientArray.iterator();
							while(iterator2.hasNext())
							{
								JSONObject object2=(JSONObject) iterator2.next();
								if(patientId.equals(object2.get("PatientId"))){
									
									jsonArray.add(object2);
									break;
								}
							}
							
						}
					}
									
				}
				System.out.println(doctorsarray);
				/*fileWriter = new FileWriter(file1);
				fileWriter.write(JSONArray.toJSONString(doctorsarray));
				fileWriter.flush();
				fileWriter.close();*/
			} else {
				System.out.println("File not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to diplay clinique details
	 */
	public static void displayCliniqueDetails() {
		
			try
			{
 			File file = new File("/home/bridgelabz/SANAworkspace/BasicProgram/src/" +
					"com/bridgelabz/objectOriented/doctors.json");
			if(file.exists())
			{
			if(file.canRead() && file.canWrite())
			{
			FileReader fr = new FileReader(file);
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(fr);
			Iterator <?>itr = array.iterator();
			
			
			System.out.println("****Doctor's Details****"+ "\n");

			while (itr.hasNext())
			{
			JSONObject obj = (JSONObject) itr.next();
			System.out.println("Name : "+obj.get("Name")+ "\n"+ "Doctor'sId : "+obj.get("Doctor'sId")+"\n"+"Specialization : "+obj.get("Speciality")+"\n"+"Availability : "+obj.get("Availability"));
			System.out.println("\n");
			}
			}
			else
			{
			System.out.println("File can't have read permissions.");
			}
			}
			else
			{
			System.out.println("File does not exits on disk.");
			}
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
			
			}

	

}// End of utility
