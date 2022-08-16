
public class Job implements Comparable<Job>{

	private int id, arrivalTime, timeForJob, priority, startTime, waitTime, endTime;
	static private int idCounter = 1;
	
	public Job() {
		
	}
	
	public Job(int arrivalTime, int timeForJob, int priority) {
		id = idCounter;
		idCounter++;
		
		setArrivalTime(arrivalTime);
		setTimeForJob(timeForJob);
		setPriority(priority);
		
	}
	
	public int getID() {
		return id;
	}
	
	public void setArrivalTime(int newArrivalTime) {
		arrivalTime = newArrivalTime;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	public void setTimeForJob(int newTimeForJob) {
		timeForJob = newTimeForJob;
	}
	
	public int getTimeForJob() {
		return timeForJob;
	}
	
	public void setPriority(int newPriority) {
		priority = newPriority;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public void setStartTime(int newStartTime) {
		startTime = newStartTime;
		waitTime = startTime - arrivalTime;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public void setEndTime(int newEndTime) {
		endTime = newEndTime;
	}
	
	public int getEndTime() {
		return endTime;
	}
	
	public int getWaitTime() {
		return waitTime;
	}
	
	
	public int compareTo(Job obj) {
		return priority - ((Job)obj).getPriority();
		
	}
}
