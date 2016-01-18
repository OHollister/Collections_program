//Olga Hollister
//11/9/2015
//Collections Lab- Merge lists

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CollectionsLab extends JFrame  {
	JFrame f = new JFrame("MargeList2");
	JPanel west=new JPanel ();
	JPanel east=new JPanel ();
	JTextArea textArea = new JTextArea(8, 20);
	JScrollPane scrollingArea= new JScrollPane(textArea,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); ;
    JTextField fileOneTextField = new JTextField();
	JTextField fileTwotField = new JTextField();
	JButton selectOneButton = new JButton("Select File1");
	JButton selectTwoButton =new JButton("Select File2");
	JButton compare =new JButton("Compare");
	private final static String newline = "\n";
	static int number=0; //Number of duplicates
	List<String> list = new ArrayList<String>();
	 
	
	public CollectionsLab(){
		super("MargeList2");
		 f.getContentPane().add(west).setBackground(Color.YELLOW);
		 f.getContentPane().add(east).setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		//west
		textArea.setEditable(false);
		west.add(scrollingArea);
		add(west, BorderLayout.WEST);
		// East
		east.setLayout(new GridLayout(3, 2));
		east.add(selectOneButton).setBackground(Color.PINK);
		east.add(fileOneTextField);
		east.add(selectTwoButton).setBackground(Color.PINK);
		east.add(fileTwotField);
		east.add(compare).setBackground(Color.PINK);
		add(east, BorderLayout.EAST);
	          
		                //select File 1 button
	selectOneButton.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e) {
		try { 
			//"C:/Users/Olga/Desktop/Hmw#9_Collections/Collections_lab/boynames.txt.txt
			
			BufferedReader firstF = new BufferedReader(new FileReader(fileOneTextField.getText()));//reading a file
			String str;
			try {
				while((str = firstF.readLine()) != null){ //reading data from the file into ArrayList
				    list.add(str);
				}
			} catch (IOException er) {
				// TODO Auto-generated catch block
				er.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
			
		}
	});	
	                      //select File 2 button
	selectTwoButton.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e) {
			//C:/Users/Olga/Desktop/Hmw#9_Collections/Collections_lab/girlnames.txt.txt
			try {
				BufferedReader secondF = new BufferedReader(new FileReader(fileTwotField.getText()));//reading a file
				String str;
				try {
					while((str = secondF.readLine()) != null){ //reading data from the file into ArrayList
					    list.add(str);
					}
				} catch (IOException er) {
					// TODO Auto-generated catch block
					er.printStackTrace();
				}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
		}
	});
	
	                   //compare button
	 compare.addActionListener(new ActionListener() { 
		public void actionPerformed(ActionEvent e) {
			 List<String> list1 = new LinkedList<String> ();
			 list1.addAll(list);
			 Collections.sort(list1);//sorting a new list
			 List<String> tempNames = new ArrayList<String>();//new arraylist 
			 for(String name : list1) {
			 if(!tempNames.contains(name)) {
				 
			 tempNames.add(name);
			 }
			
			 }
			 for(String name : tempNames) {
				 if(Collections.frequency(list1, name)!=1){
					 number++;	//increasing the integer "number",to count how many duplicates we have		 
			 textArea.append(name+newline); //show duplicates
				 }
				
			 }
			 
			 textArea.append("Number of duplicates :"+number+newline);// show number of duplicates
			 
			
			
		}
		
	});}
	
		
		
	
	 public static void main(String[] args) {
		CollectionsLab f = new CollectionsLab();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(470, 200);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
	}
	}

