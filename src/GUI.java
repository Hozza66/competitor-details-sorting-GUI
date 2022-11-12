import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;

//class for GUI
public class GUI {

	//constructor variables
	private String dancingFull;
	private String dancingShort;
	private String singingFull;
	private String singingShort;
	private String actingFull;
	private String actingShort;
	private String allCompFull;
	private String allCompShort;
	private String bestOverall;

	//GUI variables
	JFrame frame;
	JTextArea textArea;
	JMenuBar menuBar;
	JMenu menuDancing;
	JMenu menuSinging;
	JMenu menuActing;
	JMenu menuAll;
	JMenuItem menuDancing1;
	JMenuItem menuDancing2;
	JMenuItem menuSinging1;
	JMenuItem menuSinging2;
	JMenuItem menuActing1;
	JMenuItem menuActing2;
	JMenuItem menuAll1;
	JMenuItem menuAll2;
	JMenuItem menuAll3;
	JTextField textField;
	JButton searchButton1; 
	JButton searchButton2;
	JPanel panel;
	JLabel label;

	//logic variables
	boolean search1 = false;
	boolean search2 = false;
	String searchNumber;

	//constructor for GUI
	//GUI used to display competitor details
	//Also used for searching a specific competitor
	//used to construct all GUI components
	GUI(String dancingFull, 
			String dancingShort,
			String singingFull, 
			String singingShort, 
			String actingFull,
			String actingShort,
			String allCompFull,
			String allCompShort,
			String bestOverall) {  

		//declaring variables
		this.dancingFull = dancingFull;
		this.dancingShort = dancingShort;
		this.singingFull = singingFull;
		this.singingShort = singingShort;
		this.actingFull = actingFull;
		this.actingShort = actingShort;
		this.allCompFull = allCompFull;
		this.allCompShort = allCompShort;
		this.bestOverall = bestOverall;

		//call methods
		setup();
		action();
		searchCompetitorShort();
		searchCompetitorFull();
	}

	//method to setup the GUI frame, buttons, menu and panels
	public void setup () {
		//Creating the Frame
		frame = new JFrame("Competitor Database");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 800);
		// Text Area at the Center
		textArea = new JTextArea("Use the menu at the top to search through various competitor information and statistics" +
				"\n\nUse the search field and buttons at the bottom to search for details of a specific competitor by competitor number" +
				"\n\n Dancing Competitor Number Range (100-110)" +
				"\n\n Singing Competitor Number Range (200-210)" +
				"\n\n Acting Competitor Number Range (300-310)");
		textArea.setEditable(false);

		//Creating the MenuBar and adding components
		menuBar = new JMenuBar();
		menuDancing = new JMenu("Dancing Competitors");
		menuSinging = new JMenu("Singing Competitors");
		menuActing = new JMenu("Acting Competitors");
		menuAll= new JMenu("All Competitors");
		menuBar.add(menuDancing);
		menuBar.add(menuSinging);
		menuBar.add(menuActing);
		menuBar.add(menuAll);
		menuDancing1 = new JMenuItem("Show Full Report");
		menuDancing2 = new JMenuItem("Show Short Details");
		menuDancing.add(menuDancing1);
		menuDancing.add(menuDancing2);
		menuSinging1 = new JMenuItem("Show Full Report");
		menuSinging2 = new JMenuItem("Show Short Details");
		menuSinging.add(menuSinging1);
		menuSinging.add(menuSinging2);
		menuActing1 = new JMenuItem("Show Full Report");
		menuActing2 = new JMenuItem("Show Short Details");
		menuActing.add(menuActing1);
		menuActing.add(menuActing2);
		menuAll1 = new JMenuItem("All Competitor Full Details");
		menuAll2 = new JMenuItem("All Competitor Short Details");
		menuAll3 = new JMenuItem("Best Overall Competitor");
		menuAll.add(menuAll1);
		menuAll.add(menuAll2);
		menuAll.add(menuAll3);

		//Creating the bottom panel and adding buttons and search field
		panel = new JPanel(); 
		label = new JLabel("Enter Competitor Number: ");
		textField = new JTextField(10); 
		searchButton1 = new JButton("Search Short Details");
		searchButton2 = new JButton("Search Full Details");
		panel.add(label); 
		panel.add(textField);
		panel.add(searchButton1);
		panel.add(searchButton2);

		//Adding Components to the GUI frame
		frame.getContentPane().add(BorderLayout.SOUTH, panel);
		frame.getContentPane().add(BorderLayout.NORTH, menuBar);
		frame.getContentPane().add(BorderLayout.CENTER, textArea);
		frame.setVisible(true);
	}

	//Action performed by menu item and buttons
	public void action () {
		//menu action for all dancing competitors full details
		menuDancing1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(dancingFull);	//output to text field
			}

		});

		//menu action for all dancing competitors short details
		menuDancing2.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(dancingShort);
			}

		});

		//menu action for all singing competitors full details
		menuSinging1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(singingFull);
			}

		});

		//menu action for all dancing competitors Short details
		menuSinging2.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(singingShort);
			}

		});

		//menu action for all acting competitors full details
		menuActing1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(actingFull);
			}

		});

		//menu action for all dancing competitors short details
		menuActing2.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(actingShort);
			}

		});

		//menu action for all competitors full details
		menuAll1.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(allCompFull);
			}

		});

		//menu action for all competitors short details
		menuAll2.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(allCompShort);
			}

		});

		//menu action for best overall competitor
		menuAll3.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(bestOverall);
			}

		});

		//loop for search buttons
		//loop until either button is pressed
		do {
			//button action to retrieve full details
			searchButton1.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					//reading entered search number
					searchNumber = textField.getText().trim();	
					//search number minus 1 since using scan.nextline later
					int x = Integer.parseInt(searchNumber) - 1;
					searchNumber = Integer.toString(x);
					//stop the loop
					search1 = true;
				}
			});

			//button action to retrieve short details
			searchButton2.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent e) {
					//reading entered search number
					searchNumber = textField.getText().trim();
					//search number minus 1 since using scan.nextline later
					int x = Integer.parseInt(searchNumber) - 1;
					searchNumber = Integer.toString(x);
					//stop the loop
					search2 = true;
				}
			});
		}while(!search1 && !search2);


	}

	//method to run the search for short details
	//search done by scanning competitor details
	public void searchCompetitorShort() {
		do {
			//scan all competitors
			Scanner scan = new Scanner(allCompShort);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				//if line contains search number return line in text field
				if (line.contains(searchNumber)) {
					textArea.setText(scan.nextLine() +
							"\n\nSearch completed, rerun program for another search");
				}
			}
		}while(search1);

	}

	//method to run the search for Full details
	//search done by scanning competitor details
	public void searchCompetitorFull() {
		do {
			//scan all competitors
			Scanner scan = new Scanner(allCompFull);
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				//if line contains search number return line in text field
				if (line.contains(searchNumber)) {
					textArea.setText(scan.nextLine() +
					"\n\nSearch completed, rerun program for another search");
				}
			}
		}while(search2);

	}

}