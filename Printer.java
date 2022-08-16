
public class Printer {

	private Job printJob;
	private String printerName;
	private int startIdleTime, startInUseTime, totalIdleTime, totalInUseTime, totalJobsProcessed = 0;
	
	public Printer() {
		
	}

	public Printer(String printerName) {
		setPrinterName(printerName);
	}
	
	public void setPrinterName(String newPrinterName) {
		printerName = newPrinterName;
	}
	
	public String getPrinterName() {
		return printerName;
	}
	
	public void setJob(Job newJob) {
		printJob = newJob;
	}
	
	public Job getJob() {
		return printJob;
	}
	
	public void setStartInUseTime(int newStartInUseTime) {
		totalIdleTime += newStartInUseTime - startIdleTime;
		startInUseTime = newStartInUseTime;
		totalJobsProcessed++;
	}
	
	public void setStartIdleTime(int newStartIdleTime) {
		startIdleTime = newStartIdleTime;
		totalInUseTime += newStartIdleTime - startInUseTime;
	}
	
	public int getTotalIdleTime(int currentTime) {
		totalIdleTime += currentTime - startIdleTime;
		return totalIdleTime;
	}
	
	public int getTotalInUseTime() {
		return totalInUseTime;
	}
	
	public int getTotalJobsProcessed() {
		return totalJobsProcessed;
	}
	
}
