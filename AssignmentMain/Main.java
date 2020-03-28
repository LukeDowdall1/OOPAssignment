package AssignmentMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		if (e.getSource() == button1)
		{
			String word = TextField1.getText();
			JOptionPane.showMessageDialog(this, "Word entered: " + word);
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



