package lasbegas;

public class Portfel {
	private int balance;
	
	public Portfel(int startingCash) {
		balance = startingCash;
	}
	
	public void changeCash(int dosh) { balance += dosh; }
	public int getBalance() { return balance; }
	public String toString() { return Integer.toString(balance); }
}
