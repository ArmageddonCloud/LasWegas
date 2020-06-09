package lasbegas;

public class Oczko {
	String kolor;
	public int wartosc;
	boolean postawiono = false;
	
	public Oczko (){
		this.kolor = "";
		this.wartosc = 0;
	}
	
	public void wypisz(){
		System.out.print(this.kolor + " " + this.wartosc + " " + this.postawiono + "\n");
	}
	
    // setter
	public void setKolor (String imie) {this.kolor = imie;}
    public void setWartosc(int miejsce) { this.wartosc = miejsce; }
    public void setPostawiono(boolean postawiono) { this.postawiono = postawiono; }
}

