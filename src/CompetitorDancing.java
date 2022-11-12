import java.util.stream.IntStream;

//Class to process dancing competitors information which differs from the other two competitors
//Subclass of competitor class
public class CompetitorDancing extends Competitor {
	
	
	//constructor created using superclass "Competitor"
	public CompetitorDancing(int number, String name, int age, String country, String level, int score1, int score2,
			int score3, int score4, int score5) {
		super(number, name, age, country, level, score1, score2, score3, score4, score5);

	}

	//method to calculate and return the overall score
	//overall score is calculated by averaging all scores
	public String overallScore() {   
		double sum = IntStream.of(competitorScoreArray).sum(); //sum of all scores
		double averageScore = sum/competitorScoreArray.length;	//average score calculation
		return String.format("%.1f", averageScore);	//return average score to 1 decimal place
	}
	

}
