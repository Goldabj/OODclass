import java.util.Scanner;


public class FindFactors {
	
	public static class FactorThread implements Runnable {

		long startRange;
		long endRange;
		long factoredNumber;
		
		public FactorThread(long startRange2, long endRange2, long numberToFactor) {
			this.startRange = startRange2;
			this.endRange = endRange2;
			this.factoredNumber = numberToFactor;
		}
		
		@Override
		public void run() {
			System.out.println("Starting thread");
			findFactors(this.startRange, this.endRange, this.factoredNumber);
			System.out.println("Ending Thread");
		}
	}
	
	public static void findFactors(long rangeStart, long rangeEnd, long numberToFindFactorsOf) {
		System.out.println("Finding factors of " + numberToFindFactorsOf + " in range " + rangeStart + "-" + rangeEnd + " (range size " + (rangeEnd - rangeStart) + ")");
		for(long i = rangeStart; i <= rangeEnd; i++) {
			if(numberToFindFactorsOf % i == 0) {
				System.out.println(i + " is a factor");
			}

		}
	}
	
	public static void main(String[] args) {

		System.out.println("Welcome to factor search!  Enter your query in the form NUMBER_TO_FACTOR MIN_RANGE MAX_RANGE NUMBER_OF_THREADS");
		Scanner s = new Scanner(System.in);
		long numberToFactor = s.nextLong();
		long startRange = s.nextLong();
		long endRange = s.nextLong();
		long numberOfThreads = s.nextLong();
		
		long additionalRange = 0;
		for(int i = 0; i <= numberOfThreads - 2; i++) {
			long totalRange = endRange - startRange;
			long threadRange = Math.floorDiv(totalRange, numberOfThreads);
			additionalRange = totalRange % numberOfThreads;
			Thread factorThread = new Thread(new FactorThread(startRange + (i*threadRange), threadRange * (i+1), numberToFactor));
			factorThread.start();
		}
		
		Thread factorThread = new Thread(new FactorThread(endRange - additionalRange, endRange, numberToFactor));	
		factorThread.start();
		

	}

}
