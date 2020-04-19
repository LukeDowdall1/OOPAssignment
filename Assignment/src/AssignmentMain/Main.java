package AssignmentMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;


public class Main extends JFrame implements ActionListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	
	JLabel label1, toplabel, RedLabel;
	JButton button1;
	JPanel centrePanel, southPanel, northPanel;
	JTextField TextField1;
	Scanner scan;
	JTextArea lists, StrengthList;
	
	// main used to make GUI more user friendly
	public Main(String myTitle) 
	{
		super(myTitle);
		setSize(500,500);
		
		
		BorderLayout bl1 = new BorderLayout();
		getContentPane().setLayout(bl1);
		toplabel= new JLabel ("My First GUI");
		button1 = new JButton ("Search");
		button1.setForeground(new Color(0, 0, 255));
		button1.setBackground(new Color(0, 0, 255));
		
		
		
		centrePanel = new JPanel();
		centrePanel.setBorder(null);
		southPanel = new JPanel();
		southPanel.setBorder(null);
		southPanel.setBackground(new Color(0, 0, 255));
		northPanel = new JPanel();
		northPanel.setBorder(null);
		northPanel.setPreferredSize(new Dimension(10, 100));
		northPanel.setBackground(new Color(0, 0, 255));
		
		
		button1.addActionListener(this);
		centrePanel.addMouseListener(this);
		northPanel.setLayout(null);
		RedLabel = new JLabel ("Please enter a word to be searched");
		RedLabel.setBounds(12, 36, 488, 25);
		RedLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 28));
		northPanel.add(RedLabel);
		RedLabel.setOpaque(true);
		RedLabel.setBorder(null);
		RedLabel.setForeground(new Color(255, 255, 255));
		RedLabel.setBackground(new Color(0, 0, 255));
		southPanel.add(button1);
		
		
		getContentPane().add(northPanel, BorderLayout.NORTH);
		getContentPane().add(centrePanel, BorderLayout.CENTER);
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		
		
		centrePanel.setBackground(new Color(0, 0, 255));
		centrePanel.setLayout(null);
		
		
		label1 = new JLabel ("Word:");
		label1.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		label1.setBounds(147, 25, 80, 36);
		label1.setForeground(new Color(255, 255, 255));
		centrePanel.add(label1);
		TextField1 = new JTextField ("Type here");
		TextField1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		TextField1.setBounds(239, 26, 154, 35);
		TextField1.setForeground(new Color(0, 0, 0));
		TextField1.setBackground(new Color(255, 255, 255));
		centrePanel.add(TextField1);
		
		lists = new JTextArea();
		lists.setBounds(87, 111, 112, 150);
		lists.setPreferredSize(new Dimension(80, 150));
		centrePanel.add(lists);
		
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblResults.setForeground(Color.WHITE);
		lblResults.setBounds(87, 73, 112, 36);
		centrePanel.add(lblResults);
		
		StrengthList = new JTextArea();
		StrengthList.setPreferredSize(new Dimension(80, 150));
		StrengthList.setBounds(211, 111, 112, 150);
		centrePanel.add(StrengthList);
		
		JLabel lblStrength = new JLabel("Strength:");
		lblStrength.setForeground(Color.WHITE);
		lblStrength.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblStrength.setBounds(211, 73, 112, 36);
		centrePanel.add(lblStrength);
		
		TextField1.addActionListener(this);
		
		
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		//got stuck on the path as i'm using a Mac its different usage of the path command took me a while to figure out.
		String path = "/Users/lukedowdall/eclipse-workspace/Assignment/";
		
		//Initializing variables
		int j = 1;
		//line String for ease of use
		String line = "\n";
		double[] str = {0, 0, 0, 0, 0, 0, 0};
		double strtotal = 0;
		String temp = "";
		String temp2 = "";
		
		//clearing JFrames so you don't need to reset program every time
		lists.setText("");
		StrengthList.setText("");
		
		//when Search button is pressed
		if (e.getSource() == button1) {
			try {
				File folder = new File(path);
				File[] FileList = folder.listFiles();
				 
				if (FileList.length > 0) {
					 
					for (int i = 0; i < 7; i++) {
					   
						if (FileList[i].isFile()) {
				    	  
							scan = new Scanner(new BufferedReader(new FileReader(path + FileList[i].getName())));
				         
							while (scan.hasNext()){
								String word = scan.next();
				            
								if(word.equals(TextField1.getText())){
									str[i] ++;
									if(j == 1) {
										lists.append(FileList[i].getName());
										lists.append(line);
										j++;
									}
								}
							}
						}
						j = 1;
							
						strtotal = strtotal + str[i];
					}
					//had to use a  for statement as the first one would not work  properly
					for (int i = 0; i < 7; i++) {
						//if file has no match, the 0 will not be counted
						if (str[i] > 0) {
								
							temp = String.valueOf((str[i] / strtotal)*100);
							//Could not figure out a way to make it so it would show it to 2 decimal points so decided to show first 4 characters
							temp2 = temp.substring(0,4);
							StrengthList.append(temp2);
							StrengthList.append(line);
						}
						
					}
				}
				
			} catch (FileNotFoundException f) {
				f.printStackTrace();
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}



