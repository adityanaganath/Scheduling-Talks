
public class Exceptions  { //Handles various sets of error that could occur with formatting
	
	public Exceptions() {
		
	}
	
	public void Errors(String s, String e) {
		
		if (s.length() != 5 || e.length() != 5) {
			throw new IllegalArgumentException("Please reformat your time");
		}
		
		if (!(s.substring(2,3).equals(":") && e.substring(2,3).equals(":"))) {
			throw new StringIndexOutOfBoundsException("Please reformat your time");
			//must have colon separating hours and minutes
		}
		
		if (Integer.parseInt(e.substring(0,2)) < Integer.parseInt(s.substring(0,2))) {
			throw new IllegalArgumentException("End time cannot be smaller than start time. Please reformat your end time");
		}   //Doesn't make sense if end time is smaller than start time
			//(Assuming classes are not scheduled near and after midnight)
		if (Integer.parseInt(s.substring(0,2)) > 24 ||Integer.parseInt(e.substring(0,2)) > 24 ) {
			throw new NumberFormatException("Please reformat. You cannot have a listed time exceed 24!");
		
		}
		
		if (Integer.parseInt(s.substring(0,2)) < 0 ||Integer.parseInt(e.substring(0,2)) < 0 ) {
			throw new NumberFormatException("Please reformat. You cannot have a listed time be negative");
		}
		
		if (Integer.parseInt(e.substring(3,e.length())) >= 60 || Integer.parseInt(e.substring(0,2)) < 0) {
			throw new NumberFormatException("Please reformat your minutes");
		}
		
		if (Integer.parseInt(s.substring(3,s.length())) >= 60 || Integer.parseInt(s.substring(0,2)) < 0) {
			throw new NumberFormatException("Please reformat your minutes");
		}
		
		
	}

}
