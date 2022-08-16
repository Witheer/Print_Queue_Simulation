import java.util.Scanner;

public class TestPrintQueueSimulation {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("Please enter the number of printers for the simulation: ");
		int numOfPrinters = scnr.nextInt();
		
		System.out.print("Please enter the number of printer jobs for the simulation: ");
		int numOfPrintJobs = scnr.nextInt();
		
		System.out.print("Please enter a random number seed for the simulation: ");
		int seed = scnr.nextInt();
		
		
		PrintQueueSimulation sim = new PrintQueueSimulation(numOfPrintJobs, numOfPrinters, seed);
		
		sim.simulate();
		
	}
	
}
