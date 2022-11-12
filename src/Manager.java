import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Class to manage input and output of competitor details from input files
//This class uses objects and methods from arrayList class to produce reports desired
//Output is shown in console and a external .txt file
public class Manager {
	
	private String dancingCompetitorFile; //filename variable
	private String singingCompetitorFile; //filename variable
	private String actingCompetitorFile; //filename variable
	private Scanner scanDancingCompetitor;	//scanner variable, initialised here so it can be closed in run()
	private Scanner scanSingingCompetitor;	//scanner variable, initialised here so it can be closed in run()
	private Scanner scanActingCompetitor;	//scanner variable, initialised here so it can be closed in run()
	CompetitorList allDancingCompetitor = new CompetitorList();	//new list object for dancing competition
	CompetitorList allSingingCompetitor = new CompetitorList();	//new list object for singing competition
	CompetitorList allActingCompetitor = new CompetitorList();	//new list object for acting competition
	CompetitorList allCompetitor = new CompetitorList();		//new list for all competitors across the three lists
	
	//method obtain file name for dancing competition from scanning user input
	//in this case, the file name is already entered for simplicity
	public String getDancingCompetitorFile() {
		//System.out.println("Input filename(default: CompetitorList.csv) : ");
		scanDancingCompetitor = new Scanner("DancingCompetitorList.csv");
		dancingCompetitorFile = scanDancingCompetitor.next();	
		return dancingCompetitorFile;
	}
	
	//method obtain file name for singing competition from scanning user input
	//in this case, the file name is already entered for simplicity
	public String getSingingCompetitorFile() {
		//System.out.println("Input filename(default: CompetitorList.csv) : ");
		scanSingingCompetitor = new Scanner("SingingCompetitorList.csv");
		singingCompetitorFile = scanSingingCompetitor.next();	
		return singingCompetitorFile;
	}
	
	//method obtain file name for acting competition from scanning user input
	//in this case, the file name is already entered for simplicity
	public String getActingCompetitorFile() {
		//System.out.println("Input filename(default: CompetitorList.csv) : ");
		scanActingCompetitor = new Scanner("ActingCompetitorList.csv");
		actingCompetitorFile = scanActingCompetitor.next();	
		return actingCompetitorFile;
	}
	
	
	
	// Method to read/scan the dancing competition input file line by line and sort by sortFileLine()
	public void inputDancingCompetitorFile(String filename) {
		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String nextLine = scan.nextLine();
				if (nextLine.length() != 0) {
					//sort file lines in CompetitorList for dancing competition
					allDancingCompetitor.sortFileLineDancingCompetitor(nextLine);
					//sort file line used to find the best competitor across all three competitions
					allCompetitor.sortFileLineDancingCompetitor(nextLine);
					
				}
			}
			scan.close();
		}
		// exception for file not found
		catch (FileNotFoundException e) {
			System.out.println(filename + " not found, check root folder");
			System.exit(0);
		}
	}
	
	// Method to read/scan the singing competition input file line by line and sort by sortFileLine()
	public void inputSingingCompetitorFile(String filename) {
		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String nextLine = scan.nextLine();
				if (nextLine.length() != 0) {
					//sort file lines in CompetitorList for singing competition
					allSingingCompetitor.sortFileLineSingingCompetitor(nextLine); 
					//sort file line used to find the best competitor across all three competitions
					allCompetitor.sortFileLineSingingCompetitor(nextLine);
				}
			}
			scan.close();
		}
		// exception for file not found
		catch (FileNotFoundException e) {
			System.out.println(filename + " not found, check root folder");
			System.exit(0);
		}
	}
	
	// Method to read/scan the acting competition input file line by line and sort by sortFileLine()
	public void inputActingCompetitorFile(String filename) {
		try {
			File file = new File(filename);
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				String nextLine = scan.nextLine();
				if (nextLine.length() != 0) {
					//sort file lines in CompetitorList for acting competition
					allActingCompetitor.sortFileLineActingCompetitor(nextLine);
					//sort file line used to find the best competitor across all three competitions
					allCompetitor.sortFileLineActingCompetitor(nextLine);
				}
			}
			scan.close();
		}
		// exception for file not found
		catch (FileNotFoundException e) {
			System.out.println(filename + " not found, check root folder");
			System.exit(0);
		}
	}

	
	//method to run the program
	public void run() {
		//get dancing competition filename
		getDancingCompetitorFile();
		//process input file
		inputDancingCompetitorFile(dancingCompetitorFile);
		//get details/report for dancing competition
		String dancingCompetitorsOutput = allDancingCompetitor.getAllShortDetails();
		
		//method to get singing competition 
		getSingingCompetitorFile();
		//process input file
		inputSingingCompetitorFile(singingCompetitorFile);
		//get details/report for dancing competition
		String singingCompetitorsOutput = allSingingCompetitor.getAllShortDetails();
		
		//get acting competition filename
		getActingCompetitorFile();
		//process input file
		inputActingCompetitorFile(actingCompetitorFile);
		//get details/report for acting competition
		String actingCompetitorsOutput = allActingCompetitor.getAllShortDetails();
		
		//get best competitor of all three competitions
		String bestCompetitorOutput = allCompetitor.getBestOverallCompetitor();
		
		//output of all reports/details from above
		String output = dancingCompetitorsOutput + singingCompetitorsOutput + actingCompetitorsOutput + bestCompetitorOutput;
		System.out.println(output);

		//write output report to CompetitorOut.txt file
		allCompetitor.outputFile("CompetitorOut.txt", output);

		//user competitor search
		//allCompetitor.searchCompetitor();
		
		GUI GUI = new GUI (allDancingCompetitor.getFullReport(),
				allDancingCompetitor.getAllShortDetails(),
				allSingingCompetitor.getFullReport(),
				allSingingCompetitor.getAllShortDetails(),
				allActingCompetitor.getFullReport(),
				allActingCompetitor.getAllShortDetails(),
				allCompetitor.getAllCompetitor(),
				allCompetitor.getAllShortDetails(),
				allCompetitor.getBestOverallCompetitor());
		

	}

}
