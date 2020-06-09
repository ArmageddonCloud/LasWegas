package lasbegas;

import lasbegas.Kon;
import lasbegas.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame; 
import javax.swing.JLabel; 

public class Menu_Wyscig_Koni extends JFrame{
	
		public void wyscig(int[] los, Kon[] kon){
			for(int i=0; i<4; i++)
			{
					los[i] = (int) (Math.random() * 4) +1;
					int j=0;
					while(j<i)
					{
						if(los[i]==kon[j].miejsce){
							//System.out.print(los[i] );
							//System.out.print(kon[j].miejsce + "\n" );
							los[i] = (int) (Math.random() * 4) +1;
							//System.out.print(los[i] + "\n");
							j = 0;
						}
						else j++;
					}
					//System.out.print(nazwa[los[i]] + "     ");
					kon[i].setMiejsce(los[i]);
					//kon[i].wypisz();
			}
			
			Kon temp = new Kon();
			
			for(int i=0;i<4;i++)
			{
				if(kon[i].miejsce==1 && i!=0)
				{
					temp=kon[0];
					kon[0]=kon[i];
					kon[i]=temp;
					i=0;
				}
				if(kon[i].miejsce==2 && i!=1)
				{
					temp=kon[1];
					kon[1]=kon[i];
					kon[i]=temp;
					i=0;
				}
				if(kon[i].miejsce==3 && i!=2)
				{
					temp=kon[2];
					kon[2]=kon[i];
					kon[i]=temp;
					i=0;
				}
				if(kon[i].miejsce==4 && i!=3)
				{
					temp=kon[3];
					kon[3]=kon[i];
					kon[i]=temp;
					i=0;
				}
			} 
			
//			for(int i=0; i<4; i++)
//			{
//				//swap(kon, i, los[i]);
//			    System.out.print(kon[i].imie + " " + kon[i].miejsce + "\n");
//			} 
			wygrana(kon);
		}
		
		public void gra_dalej(JFrame f_temp)
		{
			JFrame f = new JFrame("Wyscigi koni");
			JLabel txt_gra_dalej = new JLabel("Czy chcesz grac dalej?");
		
			JButton b_graj=new JButton("Gram dalej!");
			//JButton b_koniec=new JButton("Powrot do menu");
		
			txt_gra_dalej.setBounds(230, 25, 250, 20);
			b_graj.setBounds(75, 50, 200, 50);
			//b_koniec.setBounds(300, 50, 200, 50);
			
			f.add(txt_gra_dalej);
			f.add(b_graj);
			//f.add(b_koniec);
			
			
			
			f.setSize(600,200);  
			f.setLayout(null);  
			f.setVisible(true);
			f.setLocation(400,400);
			
			b_graj.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent ae) 
				{
						setVisible(true);
						f_temp.dispose();
						f.dispose();
				}
			});
			/*
			b_koniec.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent ae) 
				{
						//new Menu();
						f_temp.setVisible(false);
						f.setVisible(false);
				}
			});*/
			
		}
		
		public void wygrana(Kon[] k)
		{
			setVisible(false);
			
			JFrame f2 = new JFrame("Wyniki");
			JLabel txt_wygrana = new JLabel("Wygrales!");
			JLabel txt_przegrana = new JLabel("Przegrales!");
			JLabel txt_postawiles = new JLabel();
			
			for(int i=0; i<4; i++)
			{
				if(k[i].postawiono ==true) txt_postawiles.setText("Postawiles na: " + k[i].imie);
			}
			
			JLabel txt_wyniki = new JLabel("Wyniki wyscigu: ");
			JLabel txt_1miejsce = new JLabel("1. " + k[0].imie);
			JLabel txt_2miejsce = new JLabel("2. " + k[1].imie);
			JLabel txt_3miejsce = new JLabel("3. " + k[2].imie);
			JLabel txt_4miejsce = new JLabel("4. " + k[3].imie);
		
			
			f2.add(txt_wygrana);
			f2.add(txt_przegrana);
			txt_wygrana.setBounds(200, 25, 250, 20);
			txt_przegrana.setBounds(200, 25, 250, 20);
			
			txt_wygrana.setVisible(false);
			txt_przegrana.setVisible(false);
			
			f2.setSize(450,300);  
			f2.setLayout(null);  
			f2.setVisible(true);
			
			if(k[0].postawiono == true)
			{
				txt_wygrana.setVisible(true);
				//System.out.print("wygrales no!");
			}
			else 
			{	
				txt_przegrana.setVisible(true);
				//System.out.print("przegrales no!");
			}
			
			txt_postawiles.setBounds(50, 50, 200, 20);
			txt_wyniki.setBounds(50, 100, 200, 20);
			txt_1miejsce.setBounds(50, 125, 200, 20);
			txt_2miejsce.setBounds(50, 150, 200, 20);
			txt_3miejsce.setBounds(50, 175, 200, 20);
			txt_4miejsce.setBounds(50, 200, 200, 20);
			
			f2.add(txt_postawiles);
			f2.add(txt_wyniki);
			f2.add(txt_1miejsce);
			f2.add(txt_2miejsce);
			f2.add(txt_3miejsce);
			f2.add(txt_4miejsce);
			gra_dalej(f2);
			
		}
		
		
		
		Menu_Wyscig_Koni()
		{
			this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			String[] nazwa = new String [10];
			nazwa[0] = "Stefan";
			nazwa[1] = "Rafal";
			nazwa[2] = "Bozydar";
			nazwa[3] = "Klacz";
			nazwa[4] = "Plotka";
			nazwa[5] = "Gruby";
			nazwa[6] = "Chudy";
			nazwa[7] = "Samsung";
			nazwa[8] = "Kopytko";
			nazwa[9] = "Pawel";
			
			int los[] = new int [4];
			Kon kon[]  = new Kon[4];
			
			
				for(int i=0; i<4; i++)
				{
					kon[i] = new Kon();
				}
				
				for(int i=0; i<4; i++)
				{
					los[i] = (int) (Math.random() * 10);
					int j=0;
					while(j<i)
					{
						if(los[i]==los[j]){
							//System.out.print(los[i] );
							//System.out.print(kon[j].miejsce + "\n" );
							los[i] = (int) (Math.random() * 10);
							//System.out.print(los[i] + "\n");
							j = 0;
						}
						else j++;
					}
					//System.out.print(nazwa[los[i]] + "     ");
					kon[i].setImie(nazwa[los[i]]);
					//System.out.print(i+1 + ".");
					//kon[i].wypisz();
				}
				
				this.setTitle("Wyœcig koni"); 
				JButton b1=new JButton("1."+kon[0].imie);
				JButton b2=new JButton("2."+kon[1].imie);
				JButton b3=new JButton("3."+kon[2].imie);
				JButton b4=new JButton("4."+kon[3].imie);//create button  
				
				JLabel txt1 = new JLabel("Wybierz na ktorego konia chcesz postawic");
				
				txt1.setBounds(300, 20, 250, 20);
				
				b1.setBounds(50,50,150, 40);  
				b2.setBounds(250,50,150, 40);
				b3.setBounds(450,50,150, 40);
				b4.setBounds(650,50,150, 40);
				
				add(txt1);
				
				add(b1);
				add(b2);
				add(b3);
				add(b4); 
				
				setSize(900,250);  
				setLayout(null);  
				setVisible(true);
				setLocation(500,425);
				
				b1.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent ae) 
					{
							b1.setText("postawiono");
							kon[0].postawiono =true;
							wyscig(los, kon);
					}
				});
				
				b2.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent ae) 
					{
						b2.setText("postawiono");
						kon[1].postawiono =true;
						wyscig(los, kon);
					}
				});
				
				b3.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent ae) 
					{
						b3.setText("postawiono");
						kon[2].postawiono =true;
						wyscig(los, kon);
					}
				});
				
				b4.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent ae) 
					{
						b4.setText("postawiono");
						kon[3].postawiono =true;
						wyscig(los, kon);
					}
				});
				
			}
}

