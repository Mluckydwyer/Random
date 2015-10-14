package com.Prime;

public class PrimeThread implements Runnable {

	double startNum;
	double increment;
	boolean PRIME;
	boolean PRIME_THREAD;

	public PrimeThread(double startNum, double increment, boolean PRIME) {
		this.startNum = startNum;
		this.increment = increment;
		this.PRIME_THREAD = PRIME;
	}

	public void run() {

		System.out.println("These numbers are prime:");
		System.out.println("Starting at " + startNum);
		for (double y = startNum; y <= (startNum + increment); y += 2) {
			PRIME = true;
			for (int x = 3; x <= (y / 2); x += 2) {
				if (y % x == 0) {
					PRIME = false;
					break;
				}
			}
			if (PRIME) {
				System.out.println(y + " is prime");
			}
			
			if (PRIME_THREAD) {
				System.out.println(y + "/" + (startNum + increment));
			}
			
			try {
				Thread.sleep(250);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
