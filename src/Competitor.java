import java.util.Arrays;
import java.util.stream.IntStream;

//Class to process competitor information received from competitorList class
//Super class for Dancing, Singing and Acting competitions
public class Competitor {
	
	private int competitorNumber;		//competitor number in int
	private String competitorName;		//competitor name
	private int competitorAge;			//competitor age
	private String competitorCountry;	//competitor's country
	private String competitorLevel; 		//4 competitor levels: Amature, Semi-Pro, Professional, World Class
	protected int[] competitorScoreArray = new int [5];	//array to store the 5 individual scores of a competitor
	
	//constructor for this class, each competitor(instance) information(attribute) is assigned to a variable
	public Competitor (int number, String name, int age,  String country, String level, 
			int score1, int score2, int score3, int score4, int score5) {
		competitorNumber = number;
		competitorName = name;
		competitorAge = age;
		competitorCountry = country;
		competitorLevel = level;
		//array to hold scores
		competitorScoreArray [0] = score1;
		competitorScoreArray [1] = score2;
		competitorScoreArray [2] = score3;
		competitorScoreArray [3] = score4;
		competitorScoreArray [4] = score5;
	}
	
	//method to return competitor number as a sentence
	public String getCompetitorNumber() {
		return "Number:  " + competitorNumber +  "\n"; 
	}
	
	//method to return competitor name only
	public String competitorName () { 
		return competitorName;
	}
	
	//method to return competitor name as a sentence
	public String getCompetitorName() {
		return "Name:    " + competitorName +  "\n"; 
	}
	
	//method to return competitor age as a sentence
	public String getCometitorAge() {
		return "Age:     " + competitorAge +  "\n"; 
	}  
	
	//method to return competitor's country as a sentence
	public String getCompetitorCountry() {
		return "Country: " + competitorCountry +  "\n"; 
	} 
	
	//method to return competitor's level as a sentence
	public String getCompetitorLevel () {
		return "Level:   " + competitorLevel + "\n"; 
	}
	
	//method to return competitor's score as String with bracket and commas removed and trimmed
	public String scoreArray() {
		return " "+(Arrays.toString(competitorScoreArray)).toString().replace(",", "").replace("[", "").replace("]", "").trim();   
	}
	
	//method to return competitor's score as a sentence
	public String getScoreArray(){
		return "Scores: " + scoreArray() +  "\n"; 
	}
	
	//method to calculate and return the overall score
	//overall score is calculated by removing the highest and lowest score then averaging the remaining 3 scores.
	public String overallScore() {   
		double sum = IntStream.of(competitorScoreArray).sum(); //remover highest and lowest scores
		double averageScore = sum/5;;
		return String.format("%.1f", averageScore);	//return average score to 1 decimal place
	}
	
	//method to return the overall score as a sentence
	public String getOverallScore() {
		return "Overall Score: " + overallScore();
	}

	//method to return full details of the competitor calling other methods above
	public String getFullDetails() {
		String result = 
				getCompetitorNumber() +
				getCompetitorName() + 
				getCometitorAge() +
				getCompetitorCountry() +
				getCompetitorLevel () +
				getScoreArray() +
				getOverallScore() +
				"\n\n";
		return result;
	}
	
	
	//method to return short details of the competitor as required 
	public String getShortDetails() {
		competitorName = competitorName.trim();
		String result = "CN " + competitorNumber + 
				" (" + getInitials() + ") " +
				"has overall score " +
				overallScore();
		return result;
	}
	
	//method to calculate and return the competitor's name as initials for the method getShortDetails()
	//method functions by reading and storing the name string until a space " " appears which represents the end of a name
	//the first character of the name is then recorded as initial
	//name string is emptied and repeats above till all names covered except the last name
	//for the last name since a space " " might not be present string length is used instead.
	public String getInitials() {
		String singleName = "";
		String initials = "";

		for (int i = 0; i < competitorName.length(); i++) {
			char character = competitorName.charAt(i);
			//for initals of the first and middle names
			if (character != ' ') { 
				singleName += character; 
			}
			else {
				initials += String.valueOf(singleName.charAt(0));
				singleName = "";
			}
			//for inital of the last name
			if (i == competitorName.length()-1) { 
				initials += String.valueOf(singleName.charAt(0));
			}
		}
		return initials;
	}
	
	//method to format all competitors for full report output in the arraylist
	public String formatAllCompetitors() {
		String result = 
				String.format("%-6s", competitorNumber) + 
				String.format("%-21s", competitorName) + 
				String.format("%-6s", competitorAge) + 
				String.format("%-17s", competitorCountry)+ 
				String.format("%-14s", competitorLevel) + 
				String.format("%-13s", scoreArray()) +
				overallScore(); 
		return result;	
	}
	
	//method to check the user input for searching a competitor by number and returns boolean
	public boolean checkNumber(int number) {
		if (number == competitorNumber) {
		return true; 
		}
		else {
			return false;
		}
	}
}
