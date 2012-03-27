
public class Talks implements Comparable <Talks>{ // Interface Comparable
	
	//All the components of a particular Talk
	private String title;
	private int startTime;
	private int endTime;
	private String startString; //So that times can be properly represented with colons
	private String endString;
	
	public Talks(String title, int startTime, int endTime, String startString, String endString) {
		
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startString = startString;
		this.endString = endString;
	}
	
	public String getTitle() {
		return title;
	}
	public int getStartTime() {
		return startTime;
	}
	
	public int getEndTime() { //Useful for returning individual information about the talk
		return endTime;
	}
	
	public String toString() { //tells you what the talk is
		return "\n\n" + title + "\n\n Starts:" + "\t" + startString + "\n Finish:" + "\t" + endString;
	}
	
	public int compareTo(Talks t) { //provides a framework for sorting
		if (endTime> t.getEndTime()) 
			return 1;
		else if (endTime<t.getEndTime())
			return -1;
		return 0;
	}

}
