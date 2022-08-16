import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PrintQueueSimulation {

	private PriorityQueue<Job> waitQueue;
	private int totalWaitTime = 0;
	private Queue<Job> finishedQueue;
	private int currentTime = 0;
	private Printer[] printers;
	private Random randy;
	private int numberOfPrinters, numberOfPrintJobs;
	
	public PrintQueueSimulation(int numberOfJobs, int numberOfPrinters, int seed) {
		numberOfPrintJobs = numberOfJobs;
		this.numberOfPrinters = numberOfPrinters;
		randy = new Random(seed);
		waitQueue = new PriorityQueue<>(numberOfPrintJobs);
		finishedQueue = new PriorityQueue<>(numberOfPrintJobs);
		printers = new Printer[numberOfPrinters];
		
		for(int i = 0; i < this.numberOfPrinters; i++) {
			printers[i] = new Printer("Printer" + i);
		}
		
	}
	
	public void simulate() {
		
		int jobsCreated = 0;
		boolean isDone = false;
		
		while(!isDone) {
			
			if(currentTime % 100 == 0 && jobsCreated < numberOfPrintJobs) {
				Job jobTemp = new Job(currentTime, randy.nextInt(991) + 10, randy.nextInt(10) + 1);
				waitQueue.add(jobTemp);
				jobsCreated++;
			}
			

			
			for(int i = 0; i < numberOfPrinters; i++) {
				if(printers[i].getJob() != null) {
					Job tempJob = printers[i].getJob();
					if(tempJob.getStartTime() + tempJob.getTimeForJob() <= currentTime) {
						tempJob.setEndTime(currentTime);
						finishedQueue.add(tempJob);
						printers[i].setStartIdleTime(currentTime);
						printers[i].setJob(null);
					}
				} 
				
			}
			
			for(int i = 0; i < numberOfPrinters; i++) {
				if(printers[i].getJob() == null) {
					if(!waitQueue.isEmpty()) {
						Job tempJob = waitQueue.remove();
						tempJob.setStartTime(currentTime);
						printers[i].setJob(tempJob);
						printers[i].setStartInUseTime(currentTime);
						totalWaitTime += tempJob.getWaitTime();
						
					}
				}
			}
			
			currentTime++;
			
			if(jobsCreated >= numberOfPrintJobs && waitQueue.isEmpty()) {
				isDone = true;
				for (Printer current: printers) {
					if(current.getJob() != null) {
						isDone = false;
						break;
					}
				}
				
			}
			
			
		}
		
		displayStatistics();
		
		
	}
	
	
	public void displayStatistics() {
		System.out.printf("Simulation Results\nSimulation with %d printers lasted %d secodns processed %d jobs\n", numberOfPrinters, currentTime, numberOfPrintJobs);
		System.out.printf("The average time in the wait queue for a job is %.2f seconds\n\n\n", totalWaitTime/(double)numberOfPrintJobs);
		
		System.out.println("Printer Statistics");
		System.out.println("                Jobs        Time     Time");
		System.out.println("   Name         Processed   In Use   Idle");
		
		for(Printer current: printers) {
			System.out.printf("%s        %-12d%-9d%d\n",current.getPrinterName() ,current.getTotalJobsProcessed(), current.getTotalInUseTime(), current.getTotalIdleTime(currentTime));
		}
		System.out.println("\n\n\nJob Statistics");
		System.out.println("Job No.       Priority     Wait Time      Length Of Job");
		for(Job current: finishedQueue) {
			System.out.printf("%-14d%-14d%-14d%d\n", current.getID(), current.getPriority(), current.getWaitTime(), current.getTimeForJob());
		}
		
	}
	
}
