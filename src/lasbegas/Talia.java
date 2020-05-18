package lasbegas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Talia {
	private List<Karta> deck;
	private static Random rng;
	
	/*
	 * 0 - pusta talia
	 * 1 - standardowe 52 kart
	 */
	public Talia(int type) {
		deck = new ArrayList();
		rng = new Random();
		
		if(type == 1) {
			Karta nowa;
			for(int i = 0; i < 4; i++)
				for(int j = 1; j < 14; j++) {
					nowa = new Karta(j+1, i+1);
					deck.add(nowa);
				}
		}
	}
	
	public Karta getCard(int index) {
		return deck.get(index);
	}
	
	public int deckSize() { return deck.size(); }
	
	//potasowanie talii
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	//zwraca przypadkowa karte i usuwa ja z listy
	public Karta pullRandomCard() {
		if(deck.size() == 0)
			return null;
		int n = rng.nextInt(deck.size());
		Karta rand = deck.get(n);
		deck.remove(n);
		return rand;
	}
	
	//sumuje wartosci kart (na zasadach blackjacka)
	public int sumUp(){
		int war, wynik = 0, aces = 0;
		for(int i = 0; i < deck.size(); i++) {
			war = deck.get(i).getWartosc();
			if(war == 14)
				aces += 1;
			else if(war > 10)
				wynik += 10;
			else
				wynik += war;
		}
		
		for(int i = 0; i < aces; i++) {
			if(wynik + 11 <= 21)
				wynik += 11;
			else
				wynik += 1;
		}
		
		return wynik;
	}
	
	
	public void putCard(Karta k) {
		if(k == null)
			return;
		deck.add(k);
	}
	
	public String displayDeck() {
		String wynik = "";
		for(int i = 0; i < deck.size(); i++) {
			wynik += deck.get(i).toString();
			wynik += '|';
		}
		wynik += '\n';
		return wynik;
	}
}
