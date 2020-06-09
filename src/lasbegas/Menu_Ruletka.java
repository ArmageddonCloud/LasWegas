package lasbegas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu_Ruletka extends JFrame{
	
	public void przypisanie_kolorow(Oczko[] o, int i)
	{
		if(i==0){
				o[i].kolor = "zielony";
				o[i].wartosc = i;
			}
		//przypisanie kolorow czerwonych
		else if(i==1 || i==3 || i==5 || i==7 || i==9 || i==12 || i==14 || i==16 || i==18 || i==19
			|| i==21 || i==23 || i==25 || i==27 || i==30 || i==32 || i==34 || i==36){
			o[i].kolor = "czerwony";
			o[i].wartosc = i;
		}
		//przypisanie kolorow czerwonych
		else {
			o[i].kolor = "czarny";
			o[i].wartosc = i;
		}
	}
	
	public void losowanie(Oczko[] o) {
		setVisible(false);//
		int los =  (int) (Math.random() * 36);
		System.out.print("los: " + los);
		boolean tmp = false;
		if(o[los].postawiono == true) {
			tmp = true;
			wynik(tmp, los);
		}
		else {
			tmp = false;
			wynik(tmp, los);
		}
	}
	
	public void liczby_b_akcja(Oczko[] o, int i, JButton[] b)
	{
		b[i].addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				o[i].postawiono=true;
				o[i].wypisz();
				losowanie(o);
			}
			
		});
	}
	
	public void wypisz_buttony(Oczko[] o)
	{
		//JFrame f = new JFrame("Ruletka");
		
		setSize(500,500);//
		setLocation(500,150);//
		setVisible(true);//
		setLayout(null);//
		
		//deklaracja buttonow
		JButton[] b = new JButton[37];
		JButton jed_dwana = new JButton("1-12");
		JButton trzynas_dwaycztery = new JButton("13-24");
		JButton dwaypiec_trzyszesc = new JButton("25-36");
		JButton jed_osiemn = new JButton("1-18");
		JButton dziewietn_trzycztery = new JButton("19-36");
		JButton parzyste = new JButton("EVEN");
		JButton nie_parzyste = new JButton("ODD");
		JButton red = new JButton("RED");
		JButton black = new JButton("BLACK"); 
		
		jed_dwana.setBounds(90, 45, 70, 100);
		trzynas_dwaycztery.setBounds(90, 145, 70, 100);
		dwaypiec_trzyszesc.setBounds(90, 245, 70, 100);
		jed_osiemn.setBounds(10, 45, 80, 50);
		nie_parzyste.setBounds(10, 95, 80, 50);
		red.setBounds(10, 145, 80, 50);
		black.setBounds(10, 195, 80, 50);
		parzyste.setBounds(10, 245, 80, 50);
		dziewietn_trzycztery.setBounds(10, 295, 80, 50);
		
		red.setBackground(Color.RED);
		red.setForeground(Color.WHITE);
		black.setBackground(Color.BLACK);
		black.setForeground(Color.WHITE);
		
		jed_dwana.setVisible(true);
		trzynas_dwaycztery.setVisible(true);
		dwaypiec_trzyszesc.setVisible(true);
		jed_osiemn.setVisible(true);
		dziewietn_trzycztery.setVisible(true);
		parzyste.setVisible(true);
		nie_parzyste.setVisible(true);
		red.setVisible(true);
		black.setVisible(true);
		
		add(jed_dwana);//
		add(trzynas_dwaycztery);//
		add(dwaypiec_trzyszesc);//
		add(jed_osiemn);//
		add(dziewietn_trzycztery);//
		add(parzyste);//
		add(nie_parzyste);//
		add(red);//
		add(black);//
		
		String tmp;
		
		int x=200, y=20, a=50, h=25, c=0, j=0;
		int sumax=0, sumay=0;
		
		for(int i=0; i<37; i++)
		{
			tmp = Integer.toString(i);
			b[i] = new JButton(tmp);
			b[i].setForeground(Color.WHITE);
			//b[i].setVisible(true);
			
			sumax=x+c*a;//wspolrzedne buttonów, oœ x
			sumay=y+j*h;//wspolrzedne buttonów, oœ y
			
			b[i].setBounds(sumax,sumay,a,h);
			
			if(i%3==0){c=0; j++;}
			else c++;
			if(o[i].kolor == "zielony")	
			{
					b[i].setBackground(Color.GREEN);
					b[i].setBounds(x,y,a*3,h);
			}
			else if(o[i].kolor == "czerwony")	b[i].setBackground(Color.RED);
			else if(o[i].kolor == "czarny")	b[i].setBackground(Color.BLACK);
			
			add(b[i]);//
			liczby_b_akcja(o, i, b);
			
			o[i].wypisz();
		}
		
		jed_dwana.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				for(int i=1; i<=12; i++)
				{
					o[i].postawiono=true;
					o[i].wypisz();
				}
				losowanie(o);
			}
		});
		
		trzynas_dwaycztery.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				for(int i=13; i<=24; i++)
				{
					o[i].postawiono=true;
					o[i].wypisz();
				}
				losowanie(o);
			}
		});
		
		
		dwaypiec_trzyszesc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent ae) 
			{
				for(int i=25; i<=36; i++)
				{
					o[i].postawiono=true;
					o[i].wypisz();
				}
				losowanie(o);
			}
		});
		
		jed_osiemn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				for(int i=1; i<=18; i++){
					o[i].postawiono=true;
					o[i].wypisz();
				}
				losowanie(o);
			}
		});
		
		dziewietn_trzycztery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				for(int i=19; i<=36; i++){
					o[i].postawiono=true;
					o[i].wypisz();
				}
				losowanie(o);
			}
		});
		
		parzyste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				for(int i=1; i<=36; i++){
					if(i%2==0) {
						o[i].postawiono=true;
						o[i].wypisz();
					}
				}
				losowanie(o);
			}
		});
		
		nie_parzyste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				for(int i=1; i<=36; i++){
					if(i%2!=0) {
						o[i].postawiono=true;
						o[i].wypisz();
					}
					
				}
				losowanie(o);
			}
		});
		
		red.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				for(int i=1; i<=36; i++){
					if(o[i].kolor == "czerwony") {
						o[i].postawiono=true;
						o[i].wypisz();
					}
					
				}
				losowanie(o);
			}
		});
		
		black.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				for(int i=1; i<=36; i++){
					if(o[i].kolor == "czarny") {
						o[i].postawiono=true;
						o[i].wypisz();
					}
				}
				losowanie(o);
			}
		});
	}
	
	
	public void wynik(boolean tmp, int los) {
		JFrame f = new JFrame("Wyniki");
		
		JLabel txt_wynik = new JLabel();
		JLabel label_los = new JLabel("wylosowano: " + String.valueOf(los));
		JLabel lbl_pytanie = new JLabel("Chcesz grac dalej?");
		
		JButton gram_dalej = new JButton("Gram dalej!");
		JButton koniec = new JButton("Menu");
		
		txt_wynik.setBounds(10,10,100,20);
		label_los.setBounds(10,30,150,20);
		lbl_pytanie.setBounds(60,100,150,20);
		if(tmp == true)	txt_wynik.setText("Wygrales!");
		else txt_wynik.setText("Przegrales!");
		
		gram_dalej.setBounds(10,140,100,40);
		koniec.setBounds(120, 140, 100, 40);
		
		f.setSize(280,250);
		f.setLocation(150,100);
		f.setVisible(true);
		f.setLayout(null);
		
		f.add(txt_wynik);
		f.add(label_los);
		f.add(lbl_pytanie);
		f.add(gram_dalej);
		//f.add(koniec);
		
		gram_dalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(true);
				f.dispose();
			}
		});
		
		/*koniec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.setVisible(false);
				//new Menu();
			}
		});*/
	}
	
	
	Menu_Ruletka()
	{
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Oczko[] oczka = new Oczko[37];
		for(int i=0; i<37; i++)
		{
			oczka[i] = new Oczko();
			oczka[i].wartosc = i;
			przypisanie_kolorow(oczka, i);
			//oczka[i].wypisz();
		}
		wypisz_buttony(oczka);
	}
}
