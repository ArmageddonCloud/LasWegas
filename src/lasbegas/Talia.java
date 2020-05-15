package lasbegas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Talia {
	private List<Karta> deck;
	private static Random rng;
	
	/*
	 * 0 - standardowe 52 kart
	 */
	public Talia(int type) {
		deck = new ArrayList();
		rng = new Random();
		Karta nowa;
		
		if(type == 0) {
			for(int i = 0; i < 4; i++)
				for(int j = 1; j < 14; j++) {
					nowa = new Karta(j+1, i+1);
					deck.add(nowa);
				}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Karta getRandomCard() {
		int n = rng.nextInt(deck.size());
		Karta rand = deck.get(n);
		deck.remove(n);
		return rand;
	}
}
