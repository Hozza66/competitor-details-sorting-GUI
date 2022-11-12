import java.util.Arrays;

//Class to process singing competitors information which differs from the other two competitors
//Subclass of competitor class
public class CompetitorSinging extends Competitor {

	//constructor created using superclass "Competitor"
	public CompetitorSinging(int number, String name, int age, String country, String level, int score1, int score2,
			int score3, int score4, int score5) {
		super(number, name, age, country, level, score1, score2, score3, score4, score5);
	}
	
	//method to calculate and return the overall score
	//overall score is calculated by removing the highest and lowest score then averaging the remaining 3 scores.
	public String overallScore() {
		Arrays.sort(competitorScoreArray);	//sort array from lowest to highest score
		double sum = competitorScoreArray[1]+competitorScoreArray[2]+competitorScoreArray[3]; //remover highest and lowest scores
		double averageScore = sum/3;
		return String.format("%.1f", averageScore);	//return average score to 1 decimal place
	}
	
	
}
