package lasbegas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Baccarat extends JFrame implements ActionListener{
	
	private Portfel money;
	private int bet;
	
	private Talia player;
    private Talia banker;
    private Talia deck;
    private Talia burn;
    
    private static JLabel pl, bl, pc, bc, ps, bs, mainL, moneyL;
    private static JButton revealButton, continueButton, startButton;
    private static JSpinner betSpinner;
    private static SpinnerNumberModel betModel;
   
    public Baccarat(Portfel cash){
        deck = new Talia(1);
        player = new Talia(0);
        banker = new Talia(0);
        burn = new Talia(0);
        money = cash;
        bet = 0;
        
        this.setTitle("Baccarat");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        bl = new JLabel("Karty Dealera");
		bl.setBounds(10,10,100,30);  
		pl = new JLabel("Karty Gracza");
		pl.setBounds(10,50,100,30);
		bc = new JLabel();
		bc.setBounds(120,10,100,30);
		pc = new JLabel();
		pc.setBounds(120,50,100,30);
		ps = new JLabel();
		ps.setBounds(250,50,100,30);
		bs = new JLabel();
		bs.setBounds(250,10,100,30);
		mainL = new JLabel();
		mainL.setBounds(10,250,400,30);
		moneyL = new JLabel();
		moneyL.setBounds(130, 300, 100, 30);
		moneyL.setText("Cash: " + money.toString());
		
		startButton = new JButton("Start");
		startButton.setBounds(10, 300, 100, 50);
		startButton.addActionListener(this);
		revealButton = new JButton("Odkryj kartê");
		revealButton.setBounds(10, 400, 200, 50);
		revealButton.addActionListener(this);
		revealButton.setEnabled(false);
		continueButton = new JButton("Dalej...");
		continueButton.setBounds(10, 350, 100, 50);
		continueButton.addActionListener(this);
		continueButton.setEnabled(false);
		
		betModel = new SpinnerNumberModel(0,0,money.getBalance(), 1);
		betSpinner = new JSpinner(betModel);
		betSpinner.setBounds(250, 300, 100, 30);
        
		setSize(400,500);  
		setLayout(null);  
		setVisible(true);
		
		add(bl);
		add(pl);
		add(pc);
		add(bc);
		add(ps);
		add(bs);
		add(mainL);
		add(moneyL);
		add(startButton);
		add(revealButton);
		add(continueButton);
		add(betSpinner);
		
    }
    
    private void cleanup() {
    	while(player.deckSize() != 0)
    		deck.putCard(player.pullRandomCard());
    	while(banker.deckSize() != 0)
    		deck.putCard(banker.pullRandomCard());
    	deck.shuffle();
    	
		bet = 0;
		moneyL.setText("Cash: " + money.toString());
		betModel.setMaximum(money.getBalance());
		betModel.setValue(0);
		betSpinner.setEnabled(true);
    }
    
    private void consult() {
    	if((player.sumUp()%10) > 5) {
    		if(banker.sumUp()%10 < 6)
    			banker.putCard(deck.pullRandomCard());
    	}else {
    		player.putCard(deck.pullRandomCard());
    		int war = player.getCard(2).getWartosc();
    		switch(banker.sumUp()%10) {
    			case 3:
    				if(war == 8)
    					banker.putCard(deck.pullRandomCard());
    				break;
    			case 4:
    				if(war >= 2 && war <= 7)
    					banker.putCard(deck.pullRandomCard());
    				break;
    			case 5:
    				if(war >= 4 && war <= 7)
    					banker.putCard(deck.pullRandomCard());
    				break;
    			case 6:
    				if(war == 6 || war == 7)
    					banker.putCard(deck.pullRandomCard());
    				break;
    			case 7:
    				break;
    			default:
    				banker.putCard(deck.pullRandomCard());
    		}
    	}
    }
    
    private void continueGame() {
    	if((banker.sumUp()%10) < 8 && (player.sumUp()%10) < 8)
    		consult();
		pc.setText(player.displayDeck());
		ps.setText(Integer.toString(player.sumUp()%10));
		bc.setText(banker.displayDeck());
		bs.setText(Integer.toString(banker.sumUp()%10));
		
		if((banker.sumUp()%10) > (player.sumUp()%10)) {
			mainL.setText("Bankier wygrywa");
			money.changeCash(-bet);
		}else if((banker.sumUp()%10) < (player.sumUp()%10)) {
			mainL.setText("Gracz wygrywa");
			money.changeCash(bet);
		}else {
			mainL.setText("Remis");
		}
		startButton.setEnabled(true);
		cleanup();
    	
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == revealButton) {			
			revealButton.setEnabled(false);
			pc.setText(player.displayDeck());
			ps.setText(Integer.toString(player.sumUp()%10));
			continueButton.setEnabled(true);
		}
    	if(e.getSource() == continueButton) {
    		continueButton.setEnabled(false);
    		continueGame();
    	}
    	if(e.getSource() == startButton) {
        	pc.setText("");
        	bc.setText("");
        	ps.setText("");
        	bs.setText("");
			mainL.setText("");
        	bet = (int)betSpinner.getValue();
        	betSpinner.setEnabled(false);
    		startButton.setEnabled(false);
    		revealButton.setEnabled(true);
    		startGame();
    	}
    }
   
    private void burnCards(){
        burn.putCard(deck.pullRandomCard());
        int v = burn.getCard(0).getWartosc();
        for(int i = 0; i < v; i++)
            burn.putCard(deck.pullRandomCard());
       
    }
   
    private void deal(){
        player.putCard(deck.pullRandomCard());
        player.putCard(deck.pullRandomCard());
        pc.setText(player.getCard(0).toString());
        
        banker.putCard(deck.pullRandomCard());
        banker.putCard(deck.pullRandomCard());
        bc.setText(banker.displayDeck());
        bs.setText(Integer.toString(banker.sumUp()%10));
        
        
    }
   
    private void startGame(){
       burnCards();
       deal();
    }
}
