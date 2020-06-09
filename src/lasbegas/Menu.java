package lasbegas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;  

public class Menu extends JFrame implements ActionListener
{
	Portfel money;
	
	private JLabel welcomeL;
	private JButton bj,bc,rl,wk;
	 
	public Menu(Portfel cash)
	{
		this.setTitle("Las Vegas");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		money = cash;
		
		welcomeL = new JLabel("Witaj w wirtualnym kasynie!", SwingConstants.CENTER);
		welcomeL.setBounds(250, 50, 500, 30);
		bj = new JButton("BlackJack");
		bj.addActionListener(this);
		bj.setBounds(50, 100, 450, 250);
		bc = new JButton("Baccarat");
		bc.addActionListener(this);
		bc.setBounds(500, 100, 450, 250);
		rl = new JButton("Ruletka");
		rl.addActionListener(this);
		rl.setBounds(50, 350, 450, 250);
		wk = new JButton("Wyœcig Koni");
		wk.addActionListener(this);
		wk.setBounds(500, 350, 450, 250);
		
		
		add(welcomeL);
		add(bj);
		add(bc);
		add(rl);
		add(wk);
		setSize(1000,700);  
		setLayout(null);  
		setVisible(true); 
	}
	
	public void actionPerformed(ActionEvent e){
		this.setVisible(false);
		if(e.getSource() == bj) {
			Blackjack black = new Blackjack(money);
			black.addWindowListener(new GameWatcher(this));
		}
		if(e.getSource() == bc) {
			Baccarat bac = new Baccarat(money);
			bac.addWindowListener(new GameWatcher(this));
		}
		if(e.getSource() == rl) {
			Menu_Ruletka ruletka = new Menu_Ruletka();
			ruletka.addWindowListener(new GameWatcher(this));
		}
		if(e.getSource() == wk) {
			Menu_Wyscig_Koni konie = new Menu_Wyscig_Koni();
			konie.addWindowListener(new GameWatcher(this));
		}
	}
	

}
