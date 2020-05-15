package lasbegas;

import javax.swing.JButton;
import javax.swing.JFrame;  

public class Menu extends JFrame{//inheriting JFrame  
	 
	Menu(){
		JFrame f = new JFrame("Vegas");  
		JButton b=new JButton("Start");//create button  
		b.setBounds(130,100,100, 40);  
          
		add(b);//adding button on frame  
		setSize(400,500);  
		setLayout(null);  
		setVisible(true);  
	}  
}