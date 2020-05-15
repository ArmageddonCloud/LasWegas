package lasbegas;

public class Karta {
	private int wartosc;
	private int kolor;
	
	/* A - 14
	 * K - 13
	 * Q - 12
	 * J - 11
	 * ----------------
	 * Kier - 1
	 * Pik - 2
	 * Karo - 3
	 * Trefl - 4
	 */
	public Karta(int w, int k) {
		if((w > 14 || w < 2)||(k < 0 || k > 4)) {
			wartosc = 0;
			kolor = 0;
			return;
		}
		wartosc = w;
		kolor = k;
	}
	
	public int getWartosc() { return wartosc; }
	public int getKolor() { return kolor; }
}
