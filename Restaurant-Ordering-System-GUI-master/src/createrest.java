import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

public class createrest {
	PrintWriter out;
	public createrest(String restname) throws IOException
	{
		out = new PrintWriter(new BufferedWriter(new FileWriter(restname,true)));
        
	}
	
	public void enterItems()
	{
		  JLabel lblItem  = new JLabel("Item: ");
	      JLabel lblAmt = new JLabel("Price ");

	      final JTextField txtItem = new JTextField(10);
	      final JTextField txtAmt = new JTextField(10);

	      JButton addButton = new JButton("Add item");
	      JButton stopButton = new JButton("Stop");
	      JPanel pan=new JPanel();
	      JFrame fr;
	      pan.setLayout(new FlowLayout());
	      pan.add(lblItem);
	      pan.add(txtItem);
	      pan.add(lblAmt);
	      pan.add(txtAmt);
	      pan.add(addButton);
	      pan.add(stopButton);
	      
	      fr=new JFrame("Add Items!");
	      fr.setLayout(new GridLayout(3, 1));
	      fr.setVisible(true);
	      fr.setContentPane(pan);
	      fr.setSize(800,400);
	      fr.addWindowListener(new WindowAdapter(){
	          public void windowClosing(WindowEvent winEvt)
	          {
	        	  out.close();
	              System.exit(0);
	          }
	      });

	      addButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            String s1 = txtItem.getText();
	            String s2 = txtAmt.getText();
	            out.println(s1);
	            out.println(s2);
	            txtItem.setText("");
	            txtAmt.setText("");
	         }
	      });

	      stopButton.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            out.close();
	            System.exit(0);
	         }
	      });

	      
	      
	      
	}
}	
