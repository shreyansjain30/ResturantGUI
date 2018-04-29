import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class RestaurantTester {
	
	int choice;

	public void getType()
	{
		  
		  JButton owner = new JButton("Create Menu");
	      JButton customer = new JButton("Order Items");
	      JPanel pan=new JPanel();
	      final JFrame fr;
	      pan.setLayout(new FlowLayout());
	      pan.add(owner);
	      pan.add(customer);
	      
	      fr=new JFrame("Enter Option");
	      fr.setLayout(new FlowLayout());
	      fr.setVisible(true);
	      fr.setContentPane(pan);
	      fr.setSize(800,400);
	      /*fr.addWindowListener(new WindowAdapter(){
	          public void windowClosing(WindowEvent winEvt)
	          {
	        	  RestaurantTester.this.choice=0;
	        	  fr.dispose();
	              
	          }
	      });*/

	      owner.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 try {
					CreateMen();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error! Program terminated1"
							 , " Error", JOptionPane.ERROR_MESSAGE);
					
				}
	            fr.dispose();
	         }
	      });

	      customer.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 OrderItems();
	            fr.dispose();
	         }
	      });
	      
	     
	}
	
	public void CreateMen() throws IOException
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Resturant name ");
		String rn=sc.next();
		createrest r1=new createrest(rn);
		r1.enterItems();
		
	}
	
	public void OrderItems()
	{
		try{
			
			File inputFile = new File(JOptionPane.showInputDialog("Enter Restaurant Name"));
			MainFrame guiFrame = new MainFrame(inputFile);
		}
		
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error! Menu File not found!", "Please reinput", JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception e) {
		
			JOptionPane.showMessageDialog(null, "Error! Program terminated1"
					 , " Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	


	public static void main(String[] args) throws IOException {
		
		RestaurantTester obj=new RestaurantTester();
		obj.getType();
		Scanner sc=new Scanner(System.in);
		
		
		}
		
	}


