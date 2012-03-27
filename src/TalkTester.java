import java.io.File;
import java.io.FileNotFoundException;


public class TalkTester {

	public static void main(String[] args) {
		
		try { //exception handling
			
			Schedule s = new Schedule();
			
			s.acquireTalks(new File(args[0]), new File (args [1])); //Command line arguments
			s.scheduleTalks();
			s.displaySchedule(new File (args [1]));
			
		}
		//Handling all the errors
		catch (FileNotFoundException e) {
			System.out.println("You entered one or more invalid filenames.");
		}
		
		
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Please specify the required command line arguments.");
			System.out.println("Usage: <Input File> <Output File>");
		}
		
		catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
		catch (StringIndexOutOfBoundsException e) {
			System.out.println("Please reformat your times with a colon in between");
		}
		
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		

		
			
			

	}

}
