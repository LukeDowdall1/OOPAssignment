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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;


public class Main extends JFrame implements ActionListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	
	JLabel label1, toplabel, RedLabel;
	JButton button1;
	JPanel centrePanel, southPanel, northPanel;
	JTextField TextField1;
	Scanner scan;
	
	
	public Main(String myTitle) 
	{
		super(myTitle);
		setSize(500,500);
		
		
		BorderLayout bl1 = new BorderLayout();
		getContentPane().setLayout(bl1);
		toplabel= new JLabel ("My First GUI");
		button1 = new JButton ("Enter");
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
		RedLabel = new JLabel ("Please enter a word to be searched");
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
		
		
		label1 = new JLabel ("Word:");
		label1.setForeground(new Color(255, 255, 255));
		centrePanel.add(label1);
		TextField1 = new JTextField ("Type here");
		TextField1.setForeground(new Color(0, 0, 0));
		TextField1.setBackground(new Color(255, 255, 255));
		centrePanel.add(TextField1);
		
		TextField1.addActionListener(this);
		
		
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		String path = "C:\\Users\\Luke Dowdall\\eclipse-workspace\\Assignment\\";
		if (e.getSource() == button1)
		{
			//String word = TextField1.getText();
			//showMessageDialog(this, "Word entered: " + word);
			try {
				 File folder = new File(path);
					 File[] listOfFiles = folder.listFiles();
					 
					 //test if there is files in list
					 if (listOfFiles.length > 0) {
						 
						//loop over length of list 
					   for (int i = 0; i < listOfFiles.length; i++) {
						  //if document is a file then 
					      if (listOfFiles[i].isFile()) {
					    	  
					    	 //read the file
					         scan = new Scanner(new BufferedReader(new FileReader(path + listOfFiles[i].getName())));
					         
					         //while the file has a next line
					         while (scan.hasNext()){
					        	//using a word variable to check each word 
					            String word = scan.next();
					            //if word is equal to what you typed then set result field to name of file you are in
					            if(word.equals(TextField1.getText())){
					            	results.setText(listOfFiles[i].getName());
					            }
					          }//end while
					      }//end if
					  }//end for
					}//end 1st if
					            
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

				}
			
			
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		TextField1.setText("");
		
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



