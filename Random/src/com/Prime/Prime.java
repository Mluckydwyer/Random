package com.Prime;

import java.util.ArrayList;
import java.util.Scanner;

public class Prime {

	public static String threadManagement;
	public static char testChar;
	public static int threadCount;
	public static int startPoint = 1;//BigInteger startPoint = new BigInteger((Math.pow(2, 57885161) + 1));
	public static boolean PRIME;
	public static double increment = 2000000;//2,000,000
	public static double ThreadStartPoint;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (threadManagement == null) {
			System.out.println(Math.pow(2, 57885161) + 1);
			System.out.println("What type of thread management would you like? (Automatic-Number of CPU Cores, Manual-User Specifyed)");
			String s = input.nextLine();
			Scanner findChar = new Scanner(s);
			testChar = findChar.findInLine(".").charAt(0);
			findChar.close();

			if (Character.toString((testChar)).matches("a") || Character.toString((testChar)).matches("A")) {
				threadManagement = Character.toString(testChar);
				threadCount = Runtime.getRuntime().availableProcessors();
				System.out.println("System detected " + threadCount + " availble physical cores");
			} else if (Character.toString((testChar)).matches("m") || Character.toString((testChar)).matches("M")) {
				threadManagement = Character.toString(testChar);
				System.out.println("How many threads would you like?");
				threadCount = input.nextInt();
			} else {
				System.out.println("That is not a valid option");
			}
		}
		input.close();
		System.out.println("Spawing Threads...");
		ArrayList<Thread> threads = new ArrayList<Thread>();

		for (int x = 0; x == threadCount; x++) {
			//ThreadStartPoint = startPoint = (x * increment);
			
			if (x == threadCount) {
				threads.add(new Thread(new PrimeThread(startPoint, increment, true)));
				threads.get(threads.size() - 1).start();
			} else {
				threads.add(new Thread(new PrimeThread(startPoint, increment, false)));
				threads.get(threads.size() - 1).start();
			}

			threads.get(x).start();
			System.out.println("Thread " + x + 1 + " Started");
		}
	}
}
