package lasbegas;

public class Kon {
	
		String imie;
		public int miejsce;
		boolean postawiono = false;
		
		public Kon (){
			this.imie = "";
			this.miejsce = 0;
		}
		
		public void wypisz(){
			System.out.print(this.imie + " " + this.miejsce + this.postawiono + "\n");
		}
		
	    // setter
		public void setImie (String imie) {this.imie = imie;}
	    public void setMiejsce(int miejsce) { this.miejsce = miejsce; }
}
