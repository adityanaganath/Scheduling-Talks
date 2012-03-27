import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections; // An abstract class
import java.util.Scanner;



public class Schedule {
	
	private ArrayList <Talks> givenTalks;
	private ArrayList<Talks> chosenTalks;
	
	public Schedule () {
		givenTalks = new ArrayList<Talks>();
		chosenTalks = new ArrayList<Talks>(); //Transferred from givenTalks
		
	}
	
	public void acquireTalks (File talkList, File scheduledTalks) throws FileNotFoundException  {
		
		Scanner readTalkList = new Scanner(talkList); //goes through txt file containing list of talks
		
		
		while (readTalkList.hasNextLine()) {
			
			String tName = readTalkList.nextLine(); //Since first line contains title
			
			if (!tName.isEmpty()){ //Handles the problem of multiple blank lines
				
			String s = readTalkList.nextLine(); // s represents String of starTime
			
			String e = readTalkList.nextLine();
			
			Exceptions ex = new Exceptions(); //From the Exceptions class
			
			ex.Errors(s, e); //calling method Errors from Exceptions class. Acts as a filter.
			
			String sT= s.substring(0,2).concat(s.substring(3,5)); //removing colon
			int tStartTime = Integer.parseInt(sT);
			
			String eT = e.substring(0,2).concat(e.substring(3,5));
			int tEndTime = Integer.parseInt(eT);
			
			if (!(tStartTime < 800 || tEndTime > 1700)) { //Not adding classes outside time frame
			
				Talks talk = new Talks(tName, tStartTime, tEndTime,s,e);
				givenTalks.add(talk); //Filling the arraylist with all the talks
				}
				
			}
		}
	} 
	
	public void scheduleTalks ()  {
		
		Collections.sort(givenTalks); //Sorting with smallest endTime first
		
		chosenTalks.add(givenTalks.get(0)); // smallest endTime automatically added to chosen talk
		
		int currentEndTime = chosenTalks.get(0).getEndTime();
		
		for (int i = 1; i<givenTalks.size(); i++) {
			if (givenTalks.get(i).getStartTime() >= currentEndTime) { //no overlap condition
				chosenTalks.add(givenTalks.get(i));
				currentEndTime = givenTalks.get(i).getEndTime(); //must be changed so that we no longer 
				}												// compare with earlier class
			}
		}
		
	
	
	
	public String toString()  { //returns info of talks in chosenTalks array list
		
		String info = "The optimal schedule is: \n\n";
		for (Talks talk: chosenTalks) {
			info += talk.toString();
		}
		
		return info;
		
	}
	
	public void displaySchedule (File scheduledTalks) throws FileNotFoundException  {
		
		PrintWriter writer = new PrintWriter(scheduledTalks); //Write's schedule onto output file
		writer.print(toString());
		
		writer.close();
	}
	
	
	
	
	
}
