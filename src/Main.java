/*This program will read 3 lists of competitor for 3 separate competitors 
 * Their details are read from a .csv file 
 * Each competitor is added to an array list of their competition
 * Different details and reports of all competitors can be chosen and output to console
 * A .txt file of the output is also created
 *
 * Authur: Haoran Hong
 */

//Main Class 
public class Main {
	
	public static void main(String[] args) {
		
		//runs program using object from the CompetitorManager Class
		Manager manager = new Manager();
		manager.run();
		
	}
}
