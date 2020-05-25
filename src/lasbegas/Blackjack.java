package lasbegas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Blackjack extends JFrame implements ActionListener{
	private Talia deck;
	private Talia dealer;
	private Talia player;
	private boolean fin;//test
	
	private static JLabel pl, dl, pc, dc, ps, ds, mainL;
	private static JButton startButton, acceptButton;
	private static JRadioButton hitRadio, standRadio;
	
	public Blackjack() {
		deck = new Talia(1);
		player = new Talia(0);
		dealer = new Talia(0);
		fin = false;
	
		this.setTitle("Blackjack");
		
		dl = new JLabel("Karty Dealera");
		dl.setBounds(10,10,100,30);  
		pl = new JLabel("Karty Gracza");
		pl.setBounds(10,50,100,30);
		dc = new JLabel();
		dc.setBounds(120,10,100,30);
		pc = new JLabel();
		pc.setBounds(120,50,100,30);
		ps = new JLabel();
		ps.setBounds(250,50,100,30);
		ds = new JLabel();
		ds.setBounds(250,10,100,30);
		mainL = new JLabel();
		mainL.setBounds(10,250,400,30);
		
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		startButton.setBounds(300, 60, 80, 50);
		acceptButton = new JButton("Accept");
		acceptButton.addActionListener(this);
		acceptButton.setBounds(150, 400, 80, 50);
		acceptButton.setEnabled(false);
		
		hitRadio = new JRadioButton("Hit");
		hitRadio.setBounds(10, 400, 100, 30);
		hitRadio.setEnabled(false);
		standRadio = new JRadioButton("Stand");
		standRadio.setBounds(10, 430, 100, 30);
		standRadio.setEnabled(false);
		ButtonGroup options = new ButtonGroup();
		options.add(hitRadio);
		options.add(standRadio);
		
		
         
		add(dl);
		add(pl);
		add(pc);
		add(dc);
		add(mainL);
		add(startButton);
		add(acceptButton);
		add(hitRadio);
		add(standRadio);
		setSize(400,500);  
		setLayout(null);  
		setVisible(true); 
	}
	
	private void deal() {
		Karta wybrana;
		
		wybrana = deck.pullRandomCard();
		dealer.putCard(wybrana);
		wybrana = deck.pullRandomCard();
		dealer.putCard(wybrana);
		dc.setText(dealer.getCard(0).toString());
		
		wybrana = deck.pullRandomCard();
		player.putCard(wybrana);
		wybrana = deck.pullRandomCard();
		player.putCard(wybrana);
		pc.setText(player.displayDeck());
		ps.setText(Integer.toString(player.sumUp()));
	}
	
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == startButton) {			
				startButton.setEnabled(false);
				mainL.setText("");
				pc.setText("");
				dc.setText("");
				startGame();
			}

			if(e.getSource() == acceptButton) {
				acceptButton.setEnabled(false);
				hitRadio.setEnabled(false);
				standRadio.setEnabled(false);
				handleInput();
				round();
			}
				
	}
	
	private void handleInput() {
		if(hitRadio.isSelected()) {
			player.putCard(deck.pullRandomCard());
			pc.setText(player.displayDeck());
			ps.setText(Integer.toString(player.sumUp()));
			if(player.sumUp() > 21)
				fin = true;
		}
		else if(standRadio.isSelected())
			fin = true;
	}
	
	private void decideWinner() {
		int dsum = dealer.sumUp();
		int psum = player.sumUp();
		
		if(psum == 21 && dsum == 21) {
			mainL.setText("Push");
			return;
		}else if (psum == 21 && dsum != 21) {
			mainL.setText("Gracz ma blackjacka.");
			return;
		}else if (psum != 21 && dsum == 21){
			mainL.setText("Dealer ma blackjacka.");
			dc.setText(dealer.displayDeck());
			return;
		}
		
		if(psum > 21) {
			mainL.setText("Gracz przebil.");
			return;
		}
		
		while(dsum < 17) {
			dealer.putCard(deck.pullRandomCard());
			dsum = dealer.sumUp();
		}
		dc.setText(dealer.displayDeck());
		
		if(dsum > 21) {
			mainL.setText("Dealer przebil - Gracz wygrywa");
			return;
		}
		
		if(psum > dsum) {
			mainL.setText("Gracz wygrywa.");
			return;
		}else if (psum < dsum) {
			mainL.setText("Dealer wygrywa.");
			return;
		}else {
			mainL.setText("Push");
			return;
		}
	}
	
	private void cleanup() {
		ds.setText(Integer.toString(dealer.sumUp()));
		startButton.setEnabled(true);
		while(player.deckSize() != 0)
			deck.putCard(player.pullRandomCard());
		
		while(dealer.deckSize() != 0)
			deck.putCard(dealer.pullRandomCard());
		
		deck.shuffle();
	}
	
	public void startGame() {
		deal();
		if(player.sumUp() >= 21 || dealer.sumUp() == 21 || fin == true)
			decideWinner();
		else {
			round();
		}
			
		
	}
	
	public void round() {
		if(fin == true) {
			fin = false;
			decideWinner();
			cleanup();
			return;
		}
		hitRadio.setEnabled(true);
		standRadio.setEnabled(true);
		acceptButton.setEnabled(true);
	}
	
/*	public void round(){
		deal();
		boolean bj = false;
		if(dealer.sumUp() == 21 || player.sumUp() == 21) {
			fin = true;
			bj = true;
		}

		while(fin == false || player.sumUp() <= 21) {
			
			hitRadio.setEnabled(true);
			standRadio.setEnabled(true);
			acceptButton.setEnabled(true);
		}
		decideWinner(bj);
	}*/
}
