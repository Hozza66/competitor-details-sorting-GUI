import java.util.Arrays;
import java.util.stream.IntStream;

//Class to process acting competitors information which differs from the other two competitors
//Subclass of competitor class
public class CompetitorActing extends Competitor {
	
	
	public String stageName;	//variable for the new parameter "stage name"

	//constructor created using superclass "Competitor"
	public CompetitorActing(int number, String name, int age, String country, String level, int score1, int score2,
			int score3, int score4, int score5, String stageName) {
		super(number, name, age, country, level, score1, score2, score3, score4, score5);
		this.stageName = stageName; //new parameter added to contain stage names of competitors
	}
	
	//method to calculate and return the overall score
	//overall score is calculated removing the lowest score and average the remainng scores
	public String overallScore() {
		Arrays.sort(competitorScoreArray);	//sort array from lowest to highest score
		//remover lowest scores
		double sum = competitorScoreArray[1]+competitorScoreArray[2]+competitorScoreArray[3]+competitorScoreArray[4]; 
		double averageScore = sum/4;
		return String.format("%.1f", averageScore);	//return average score to 1 decimal place
	}
	
	//method to return the stage name of competitorss
	public String stageName() {
		String actingStageName = stageName;
		return "  (AKA:\"" + actingStageName + "\")";
	}
}