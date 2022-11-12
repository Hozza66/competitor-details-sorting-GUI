import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class will read competitor information from a .csv file and store it in
 * a array list created from objects of the Competitor class. 
 * This class have methods for various details and statistics of each competitor 
 * Some details/reports are for across all 3 competitions
 * 
 * @author Haoran Hong
 *
 */

//Super class for GUI
public class CompetitorList {

	protected ArrayList<CompetitorDancing> dancingCompetitorList = new ArrayList<CompetitorDancing>();	// array list for storing competitors information
	protected ArrayList<CompetitorSinging> singingCompetitorList = new ArrayList<CompetitorSinging>();	// array list for storing competitors information	
	protected ArrayList<CompetitorActing> actingCompetitorList = new ArrayList<CompetitorActing>();		// array list for storing competitors information
	protected ArrayList<Integer> frequencyArrayList = new ArrayList<Integer>(); 	// array list to store all scores to calculated score frequency
	protected int numberOfCompetitors; 	// variable for number of competitors
	protected int competitorNumber; 		// variable competitor number
	protected boolean readDancingCompetitors = false;		//boolean to show if dancing competitors are being processed 
	protected boolean readSingingCompetitors = false;		//boolean to show if singing competitors are being processed 
	protected boolean readActingCompetitors = false;		//boolean to show if acting competitors are being processed 


	/**
	 * Method to add a competitor object to the array list
	 * 
	 * @param competitor the competitor object created in sortFileLine()
	 */
	public void addDancingCompetitor(CompetitorDancing dancingCompetitor) {
		dancingCompetitorList.add(dancingCompetitor);
	}

	/**
	 * Method to add a competitor object to the array list
	 * 
	 * @param competitor the competitor object created in sortFileLine()
	 */
	public void addSingingCompetitor(CompetitorSinging singingCompetitor) {
		singingCompetitorList.add(singingCompetitor);
	}

	/**
	 * Method to add a competitor object to the array list
	 * 
	 * @param competitor the competitor object created in sortFileLine()
	 */
	public void addActingCompetitor(CompetitorActing actingCompetitor) {
		actingCompetitorList.add(actingCompetitor);
	}




	/**
	 * Method for sorting each line of the input file. It creates objects from each
	 * line using the Competitor class and stores it in the array list. The method
	 * checks if attributes are correct in the input file.
	 * 
	 * @param fileLine scanned line from the input file
	 * @exception NumberFormatException          if the the format errors occur
	 * @exception ArrayIndexOutOfBoundsException if the array index errors occur
	 */
	public void sortFileLineDancingCompetitor(String fileLine) {
		try {
			// Assigning variables to each individual information
			String competitorInfo[] = fileLine.split(","); // each attribute of the line separated by commas

			// input file line length check
			// if length is not the expected 10, stop program and display error message for
			// the specific line
			if (competitorInfo.length != 10) {
				System.out.println("Error! competitor " + competitorInfo[0]
						+ " have too many/few attributes (default = 10), check input");
				System.exit(0);
			}

			// input scores check loop for all five scores
			// scores are from 1 to 5, if not the program will stop with an error message
			// indicating which line has the error
			for (int i = 5; i < 10; i++) {
				int score = Integer.parseInt(competitorInfo[i]);
				if (score < 1 || score > 5) {
					System.out.println(
							"Error! competitor " + competitorInfo[0] + " has scores outside of the range (1 to 5)");
					System.exit(0);
				}
			}

			//assigning variables to each item of a line
			competitorNumber = Integer.parseInt(competitorInfo[0].trim());
			String competitorName = competitorInfo[1].trim();
			int competitorAge = Integer.parseInt(competitorInfo[2].trim());
			String competitorCountry = competitorInfo[3].trim();
			String competitorLevel = competitorInfo[4].trim();
			int competitorScore1 = Integer.parseInt(competitorInfo[5].trim());
			int competitorScore2 = Integer.parseInt(competitorInfo[6].trim());
			int competitorScore3 = Integer.parseInt(competitorInfo[7].trim());
			int competitorScore4 = Integer.parseInt(competitorInfo[8].trim());
			int competitorScore5 = Integer.parseInt(competitorInfo[9].trim());
			// adding scores to the frequency array list
			frequencyArrayList.add(competitorScore1);
			frequencyArrayList.add(competitorScore2);
			frequencyArrayList.add(competitorScore3);
			frequencyArrayList.add(competitorScore4);
			frequencyArrayList.add(competitorScore5);

			// using Competitor class to create objects for each competitor
			// adding objects to the competitor array list
			CompetitorDancing danceCompetitor = new CompetitorDancing(competitorNumber, competitorName, competitorAge,
					competitorCountry, competitorLevel, competitorScore1, competitorScore2, competitorScore3,
					competitorScore4, competitorScore5);
			this.addDancingCompetitor(danceCompetitor);

			readDancingCompetitors = true; //boolean true for reading dancing competitors list
		}
		// exception for number format errors
		// prints the line with the error and stops the program
		catch (NumberFormatException e) {
			System.out.println(
					"NumberFormatException! Check number coversion in line: " + fileLine + e.getMessage() + "\n\n");
			System.exit(0);

		}
		// exception for array index errors
		// prints the line with the error and stops the program
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException! Missing item(s) in line: " + fileLine + " with "
					+ e.getMessage() + "\n\n");
			System.exit(0);
		}
	}


	/**
	 * Method for sorting each line of the input file. It creates objects from each
	 * line using the Competitor class and stores it in the array list. The method
	 * checks if attributes are correct in the input file.
	 * 
	 * @param fileLine scanned line from the input file
	 * @exception NumberFormatException          if the the format errors occur
	 * @exception ArrayIndexOutOfBoundsException if the array index errors occur
	 */
	public void sortFileLineSingingCompetitor(String fileLine) {
		try {
			// Assigning variables to each individual information
			String competitorInfo[] = fileLine.split(","); // each attribute of the line separated by commas

			// input file line length check
			// if length is not the expected 10, stop program and display error message for
			// the specific line
			if (competitorInfo.length != 10) {
				System.out.println("Error! competitor " + competitorInfo[0]
						+ " have too many/few attributes (default = 10), check input");
				//System.exit(0);
			}

			// input scores check loop for all five scores
			// scores are from 1 to 5, if not the program will stop with an error message
			// indicating which line has the error
			for (int i = 5; i < 10; i++) {
				int score = Integer.parseInt(competitorInfo[i]);
				if (score < 1 || score > 5) {
					System.out.println(
							"Error! competitor " + competitorInfo[0] + " has scores outside of the range (1 to 5)");
					System.exit(0);
				}
			}

			//assigning variables to each item of a line
			competitorNumber = Integer.parseInt(competitorInfo[0].trim());
			String competitorName = competitorInfo[1].trim();
			int competitorAge = Integer.parseInt(competitorInfo[2].trim());
			String competitorCountry = competitorInfo[3].trim();
			String competitorLevel = competitorInfo[4].trim();
			int competitorScore1 = Integer.parseInt(competitorInfo[5].trim());
			int competitorScore2 = Integer.parseInt(competitorInfo[6].trim());
			int competitorScore3 = Integer.parseInt(competitorInfo[7].trim());
			int competitorScore4 = Integer.parseInt(competitorInfo[8].trim());
			int competitorScore5 = Integer.parseInt(competitorInfo[9].trim());
			// adding scores to the frequency array list
			frequencyArrayList.add(competitorScore1);
			frequencyArrayList.add(competitorScore2);
			frequencyArrayList.add(competitorScore3);
			frequencyArrayList.add(competitorScore4);
			frequencyArrayList.add(competitorScore5);

			// using Competitor class to create objects for each competitor
			// adding objects to the competitor array list
			CompetitorSinging singingCompetitor = new CompetitorSinging(competitorNumber, competitorName, competitorAge,
					competitorCountry, competitorLevel, competitorScore1, competitorScore2, competitorScore3,
					competitorScore4, competitorScore5);
			this.addSingingCompetitor(singingCompetitor);

			readSingingCompetitors = true;		//boolean true for reading singing competitors list
		}
		// exception for number format errors
		// prints the line with the error and stops the program
		catch (NumberFormatException e) {
			System.out.println(
					"NumberFormatException! Check number coversion in line: " + fileLine + e.getMessage() + "\n\n");
			System.exit(0);

		}
		// exception for array index errors
		// prints the line with the error and stops the program
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException! Missing item(s) in line: " + fileLine + " with "
					+ e.getMessage() + "\n\n");
			System.exit(0);
		}
	}

	/**
	 * Method for sorting each line of the input file. It creates objects from each
	 * line using the Competitor class and stores it in the array list. The method
	 * checks if attributes are correct in the input file.
	 * 
	 * @param fileLine scanned line from the input file
	 * @exception NumberFormatException          if the the format errors occur
	 * @exception ArrayIndexOutOfBoundsException if the array index errors occur
	 */
	public void sortFileLineActingCompetitor(String fileLine) {
		try {
			// Assigning variables to each individual information
			String competitorInfo[] = fileLine.split(","); // each attribute of the line separated by commas

			// input file line length check
			// if length is not the expected 10, stop program and display error message for
			// the specific line
			if (competitorInfo.length != 11) {
				System.out.println("Error! competitor " + competitorInfo[0]
						+ " have too many/few attributes (default = 11), check input");
				System.exit(0);
			}

			// input scores check loop for all five scores
			// scores are from 1 to 5, if not the program will stop with an error message
			// indicating which line has the error
			for (int i = 5; i < 10; i++) {
				int score = Integer.parseInt(competitorInfo[i]);
				if (score < 1 || score > 5) {
					System.out.println(
							"Error! competitor " + competitorInfo[0] + " has scores outside of the range (1 to 5)");
					System.exit(0);
				}
			}

			//assigning variables to each item of a line
			competitorNumber = Integer.parseInt(competitorInfo[0].trim());
			String competitorName = competitorInfo[1].trim();
			int competitorAge = Integer.parseInt(competitorInfo[2].trim());
			String competitorCountry = competitorInfo[3].trim();
			String competitorLevel = competitorInfo[4].trim();
			int competitorScore1 = Integer.parseInt(competitorInfo[5].trim());
			int competitorScore2 = Integer.parseInt(competitorInfo[6].trim());
			int competitorScore3 = Integer.parseInt(competitorInfo[7].trim());
			int competitorScore4 = Integer.parseInt(competitorInfo[8].trim());
			int competitorScore5 = Integer.parseInt(competitorInfo[9].trim());
			String competitorStageName = competitorInfo[10].trim();	
			// adding scores to the frequency array list
			frequencyArrayList.add(competitorScore1);
			frequencyArrayList.add(competitorScore2);
			frequencyArrayList.add(competitorScore3);
			frequencyArrayList.add(competitorScore4);
			frequencyArrayList.add(competitorScore5);


			// using Competitor class to create objects for each competitor
			// adding objects to the competitor array list
			CompetitorActing actingCompetitor = new CompetitorActing(competitorNumber, competitorName, competitorAge,
					competitorCountry, competitorLevel, competitorScore1, competitorScore2, competitorScore3,
					competitorScore4, competitorScore5, competitorStageName);
			this.addActingCompetitor(actingCompetitor);

			readActingCompetitors = true;	//boolean true for reading acting competitors list
		}
		// exception for number format errors
		// prints the line with the error and stops the program
		catch (NumberFormatException e) {
			System.out.println(
					"NumberFormatException! Check number coversion in line: " + fileLine + e.getMessage() + "\n\n");
			System.exit(0);

		}
		// exception for array index errors
		// prints the line with the error and stops the program
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException! Missing item(s) in line: " + fileLine + " with "
					+ e.getMessage() + "\n\n");
			System.exit(0);
		}
	}


	/**
	 * Method to return the full sorted report of all competitors with various
	 * statistics, calls other methods for each section of the report.
	 * 
	 * @return full competitor report
	 */
	public String getFullReport() {
		String report = getAllCompetitor() + getBestCompetitor() + getStatistics();
		return report;
	}

	/**
	 * Method used to return all competitors in a certain competition neatly formated.
	 * 
	 * @return all competitor information
	 */
	public String getCompetitor() {

		// format the headers of the report
		String report = "\nAll competitor details:\n\n";
		report += String.format("%-27s", "Competitor");
		report += String.format("%-6s", "Age");
		report += String.format("%-17s", "Country");
		report += String.format("%-15s", "Level");
		report += String.format("%-12s", "Score");
		report += "Overall";
		report += "\n";

		//loop for each competitor details in the dancing competition
		for (CompetitorDancing competitor : dancingCompetitorList) {
			report += competitor.formatAllCompetitors(); // calls format method from Competitor class
			report += "\n";
		}

		//loop for each competitor details in the singing competition
		for (CompetitorSinging competitor : singingCompetitorList) {
			report += competitor.formatAllCompetitors(); // calls format method from Competitor class
			report += "\n";
		}

		//loop for each competitor details in the acting competition
		for (CompetitorActing competitor : actingCompetitorList) {
			report += competitor.formatAllCompetitors() + competitor.stageName(); // calls format method from Competitor class
			report += "\n";
		}

		return report + "\n---------------------------------------------\n\n";
	}

	//method to get all competitors across three competitions
	public String getAllCompetitor() {

		String report = "";






		//heading for dancing competition
		if (readDancingCompetitors) {
			report += "Dancing Competitors Full Details: \n\n";
			//format the headers of the report
			report += String.format("%-27s", "Competitor");
			report += String.format("%-6s", "Age");
			report += String.format("%-17s", "Country");
			report += String.format("%-15s", "Level");
			report += String.format("%-12s", "Score");
			report += "Overall";
		}

		//Outputs all competitors for each competition
		for (CompetitorDancing competitor : dancingCompetitorList) {
			report += "\n" + competitor.formatAllCompetitors(); // calls format method from Competitor class

		}

		//heading for singing competition
		if (readSingingCompetitors) {
			report += "\n\nSinging Competitors Full Details: \n\n";
			//format the headers of the report
			report += String.format("%-27s", "Competitor");
			report += String.format("%-6s", "Age");
			report += String.format("%-17s", "Country");
			report += String.format("%-15s", "Level");
			report += String.format("%-12s", "Score");
			report += "Overall";
		}

		for (CompetitorSinging competitor : singingCompetitorList) {
			report += "\n" + competitor.formatAllCompetitors(); // calls format method from Competitor class

		}

		//heading for acting competition
		if (readActingCompetitors) {
			report += "\n\nActing Competitors Full Details: \n\n";
			//format the headers of the report
			report += String.format("%-27s", "Competitor");
			report += String.format("%-6s", "Age");
			report += String.format("%-17s", "Country");
			report += String.format("%-15s", "Level");
			report += String.format("%-12s", "Score");
			report += "Overall";

			//add stage name heading if processing acting competitors
			report += "   Stage Name";

		}

		for (CompetitorActing competitor : actingCompetitorList) {
			report += "\n" + competitor.formatAllCompetitors() + "     " + competitor.stageName(); // calls format method from Competitor class

		}
		return report + "\n---------------------------------------------\n\n";
	}

	//this method returns the best competitor within a certain competitor
	//all tied best competitors will be output
	public String getBestCompetitor() {
		String bestCompetitor = "";
		double bestScore = 0.0;
		String Heading = "";

		//heading for dancing competition
		if (readDancingCompetitors) {
			Heading += "Best Dancing Competitor: \n\n";
		}

		//heading for singing competition
		if (readSingingCompetitors) {
			Heading += "Best Singing Competitor: \n\n";;
		}

		//heading for acting competition
		if (readActingCompetitors) {
			Heading += "Best Acting Competitor:  \n\n";
		}

		//scans through the array list for highest overall score
		//returns full details of the highest score competitor by calling method from Competitor Class
		for (CompetitorDancing competitor  : dancingCompetitorList) {
			double newScore = Double.parseDouble(competitor.overallScore());
			if (newScore > bestScore) {
				bestCompetitor = competitor.getFullDetails();
				bestScore = newScore;
			}
			//return details of the tied highest overall score competitor
			else if (newScore == bestScore) {
				bestCompetitor += competitor.getFullDetails();
			}	
		}

		//scans through the array list for highest overall score
		//returns full details of the highest score competitor by calling method from Competitor Class
		for (CompetitorSinging competitor  : singingCompetitorList) {
			double newScore = Double.parseDouble(competitor.overallScore());
			if (newScore > bestScore) {
				bestCompetitor = competitor.getFullDetails();
				bestScore = newScore;
			}
			//return details of the tied highest overall score competitor
			else if (newScore == bestScore) {
				bestCompetitor += competitor.getFullDetails();
			}	
		}

		//scans through the array list for highest overall score
		//returns full details of the highest score competitor by calling method from Competitor Class
		for (CompetitorActing competitor  : actingCompetitorList) {
			double newScore = Double.parseDouble(competitor.overallScore());
			if (newScore > bestScore) {
				bestCompetitor = competitor.getFullDetails();
				bestScore = newScore;
			}
			//return details of the tied highest overall score competitor
			else if (newScore == bestScore) {
				bestCompetitor += competitor.getFullDetails();
			}	
		}
		return  Heading + bestCompetitor + "---------------------------------------------\n";
	}

	/**
	 * Method to calculate and return the competitor with the highest overall score across 
	 * all three competitions
	 * if there are multiple competitors with the highest score then return all of them.
	 * 
	 * @return best scored competitor(s) full details
	 */
	public String getBestOverallCompetitor() {
		String bestCompetitor = "";
		String bestDancingCompetitor = "";
		String bestSingingCompetitor = "";
		String bestActingCompetitor = "";
		double bestDancingScore = 0.0;
		double bestSingingScore = 0.0;
		double bestActingScore = 0.0;


		// scans through the array list for highest overall score
		// returns full details of the highest score competitor by calling method from
		// Competitor Class
		for (CompetitorDancing competitor : dancingCompetitorList) {
			double newScore = Double.parseDouble(competitor.overallScore());
			if (newScore > bestDancingScore) {
				bestDancingCompetitor = competitor.getFullDetails();
				bestDancingScore = newScore;
			}
			// return details of the tied highest overall score competitor
			else if (newScore == bestDancingScore) {
				bestDancingCompetitor += competitor.getFullDetails();
			}
		}

		// scans through the array list for highest overall score
		// returns full details of the highest score competitor by calling method from
		// Competitor Class
		for (CompetitorSinging competitor : singingCompetitorList) {
			double newScore = Double.parseDouble(competitor.overallScore());
			if (newScore > bestSingingScore) {
				bestSingingCompetitor = competitor.getFullDetails();
				bestSingingScore = newScore;
			}
			// return details of the tied highest overall score competitor
			else if (newScore == bestSingingScore) {
				bestSingingCompetitor += competitor.getFullDetails();
			}
		}

		// scans through the array list for highest overall score
		// returns full details of the highest score competitor by calling method from
		// Competitor Class
		for (CompetitorActing competitor : actingCompetitorList) {
			double newScore = Double.parseDouble(competitor.overallScore());
			if (newScore > bestSingingScore) {
				bestActingCompetitor = competitor.getFullDetails();
				bestSingingScore = newScore;
			}
			// return details of the tied highest overall score competitor
			else if (newScore == bestActingScore) {
				bestActingCompetitor += competitor.getFullDetails();
			}
		}

		//if statement if the best dancing competitor is the best overall competitor
		if (bestDancingScore >= bestSingingScore && bestDancingScore >= bestActingScore) {
			bestCompetitor += bestDancingCompetitor;
		}

		//if statement if the best singing competitor is the best overall competitor
		if (bestSingingScore >= bestDancingScore && bestSingingScore >= bestActingScore) {
			bestCompetitor += bestSingingCompetitor;
		}

		//if statement if the best acting competitor is the best overall competitor
		if (bestActingScore >= bestDancingScore && bestActingScore >= bestActingScore) {
			bestCompetitor += bestActingCompetitor;
		}

		//return best competitor across all three competitions
		return "\nCompetitor(s) with the highest overall score across all competitions: \n\n" + 
		bestCompetitor + "---------------------------------------------\n";
	}

	/**
	 * Method to combine all statistical methods and returns it.
	 * 
	 * @return competitor statistics
	 */
	public String getStatistics() {

		String Heading = "";

		if (readDancingCompetitors) {
			Heading += "Dancing competition Statistics: \n\n";
		}

		if (readSingingCompetitors) {
			Heading += "Singing competition Statistics: \n\n";;
		}

		if (readActingCompetitors) {
			Heading += "Acting competition Statistics:  \n\n";
		}
		String statistics = Heading + numberOfCompetitors() + getScoreStatistics() + getScoreFrequency();

		return statistics + "\n---------------------------------------------\n\n";
	}

	/**
	 * Method to calculate and return the number of competitors using the method
	 * .size().
	 * 
	 * @return number of competitors in the list
	 */
	public String numberOfCompetitors() {
		int number = 0;

		//if statements to get the total number of competitors in each competition
		if (readDancingCompetitors) {
			numberOfCompetitors = dancingCompetitorList.size();
		}

		if (readSingingCompetitors) {
			numberOfCompetitors = singingCompetitorList.size();
		}

		if (readActingCompetitors) {
			numberOfCompetitors = actingCompetitorList.size();
		}
		number = numberOfCompetitors;

		return "There are a total of " + number + " competitors\n\n";
	}

	/**
	 * Method to calculate and return score statistics including: 1.total average
	 * overall score 2.worst overall score competitor(s) can be more than 1, similar
	 * to the bestCompetitor() method.
	 * 
	 * @return average overall score and short details of the worst scored
	 *         competitor(s)
	 */
	public String getScoreStatistics() {
		double averageOverallScore = 0.0;
		String worstCompetitor = "";
		double worstScore = 5.0;

		//calculates scores statistics for dancing competition
		for (CompetitorDancing competitor : dancingCompetitorList) {
			averageOverallScore += Double.parseDouble(competitor.overallScore());
			double newScore = Double.parseDouble(competitor.overallScore());
			if (newScore < worstScore) {
				worstCompetitor = competitor.competitorName();
				worstScore = newScore;
			} else if (newScore == worstScore) {
				worstCompetitor += " / " + competitor.competitorName();
			}
		}

		//calculates scores statistics for singing competition
		for (CompetitorSinging competitor : singingCompetitorList) {
			averageOverallScore += Double.parseDouble(competitor.overallScore());
			double newScore = Double.parseDouble(competitor.overallScore());
			if (newScore < worstScore) {
				worstCompetitor = competitor.competitorName();
				worstScore = newScore;
			} else if (newScore == worstScore) {
				worstCompetitor += " / " + competitor.competitorName();
			}
		}

		//calculates scores statistics for acting competition
		for (CompetitorActing competitor : actingCompetitorList) {
			averageOverallScore += Double.parseDouble(competitor.overallScore());
			double newScore = Double.parseDouble(competitor.overallScore());
			if (newScore < worstScore) {
				worstCompetitor = competitor.competitorName();
				worstScore = newScore;
			} else if (newScore == worstScore) {
				worstCompetitor += " / " + competitor.competitorName();
			}
		}

		//return statistics
		averageOverallScore = averageOverallScore / numberOfCompetitors;
		return "The average overall score is " + String.format("%.1f", averageOverallScore) + "\n\n" + worstCompetitor
				+ " is the competitor with the lowest overall score of " + worstScore;
	}

	/**
	 * Method to calculate and return the frequency each individual score. All
	 * competitor scores are stored in the frequency array list.
	 * Collections.frequency method is used to return the frequency.
	 * 
	 * @return frequency of each score given
	 */
	public String getScoreFrequency() {
		String result = "\n\nScore frequency:\n ";
		result += "Score:       1   2   3   4   5  \n Frequency:   ";
		result += String.format("%-4s", Collections.frequency(frequencyArrayList, 1));
		result += String.format("%-4s", Collections.frequency(frequencyArrayList, 2));
		result += String.format("%-4s", Collections.frequency(frequencyArrayList, 3));
		result += String.format("%-4s", Collections.frequency(frequencyArrayList, 4));
		result += Collections.frequency(frequencyArrayList, 5);
		result += "\n";
		return result;
	}

	//method to get short details of all three competitions
	public String getAllShortDetails() {
		String reportAll ="";
		String reportDancing ="";
		String reportSinging ="";
		String reportActing ="";

		//heading for dancing competition
		if (readDancingCompetitors) {
			reportDancing = "\nDancing Competitors Short Details: \n\n";
		}

		//heading for singing competition
		if (readSingingCompetitors) {
			reportSinging = "\nSinging Competitors Short Details: \n\n";
		}

		//heading for acting competition
		if (readActingCompetitors) {
			reportActing = "\nActing Competitors Short Details: \n\n";
		}

		//get short details for dancing competitors
		for (CompetitorDancing competitor : dancingCompetitorList) {
			reportDancing += competitor.getShortDetails();
			reportDancing += "\n";
		}

		//get short details for singing competitors
		for (CompetitorSinging competitor : singingCompetitorList) {
			reportSinging += competitor.getShortDetails();
			reportSinging += "\n";
		}

		//get short details for acting competitors
		for (CompetitorActing competitor : actingCompetitorList) {
			reportActing += competitor.getShortDetails() + competitor.stageName();
			reportActing += "\n";
		}

		//return all details as report
		reportAll = "\n" + reportDancing + reportSinging + reportActing;
		return reportAll + "---------------------------------------------\n";
	}

	/**
	 * Method to output the full report a .txt file in the root folder.
	 * 
	 * @param filename filename of the output .txt file
	 * @param report   the full report produced buy the method getFullReport()
	 * @exception IOException if input/output error has occurred
	 */
	public void outputFile(String filename, String report) {

		FileWriter writer;
		try {
			writer = new FileWriter(filename);
			writer.write(report);
			writer.close();
		}
		// input/output exception to return stack trace and exits the program
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Method to search a competitor by their number from users input. Calls the
	 * checkNumber() method from the Competitor class.
	 * 
	 * @exception InputMismatchException if input is not an integer
	 */
	public void searchCompetitor() {
		boolean validNumber = false;
		try {
			do {
				System.out.println("Input competitor number:\n"
						+ "(Dancing Competitors 100-110)\n"
						+ "(Singing Competitors 200-210)\n"
						+ "(Acting  Competitors 300-310)\n");
				Scanner scan = new Scanner(System.in);
				int number = scan.nextInt();

				// output the short details of the searched competitor
				for (CompetitorDancing competitor : dancingCompetitorList) {
					if (competitor.checkNumber(number)) {
						System.out.println(competitor.getShortDetails());
						validNumber = true;
						scan.close();
					}
				}

				for (CompetitorSinging competitor : singingCompetitorList) {
					if (competitor.checkNumber(number)) {
						System.out.println(competitor.getShortDetails());
						validNumber = true;
						scan.close();
					}
				}

				for (CompetitorActing competitor : actingCompetitorList) {
					if (competitor.checkNumber(number)) {
						System.out.println(competitor.getShortDetails());
						validNumber = true;
						scan.close();
					}
				}

				// output if the competitor number does not exist in the array list
				if (!validNumber) {
					System.out.println("Competitor number " + number + " does not exist\n\n");
				}
			} while (!validNumber); // loops until a valid competitor number is entered
		}
		// exception if anything other an integer is inputed from the user
		catch (InputMismatchException e) {
			System.out.println("Input integer number only!");
		}
	}
}
