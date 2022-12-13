package BlackJack;

import java.util.*;

public class Kartendeck {
	private List<Karte> karten = new ArrayList<Karte>();
	
	public void kartendeckFuellen()
	{
		karten.clear();
		
		String[] symbole = {"Karo", "Herz", "Pik", "Kreuz"};
		String[] kartenNahmen = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Bube", "Dame", "Koenig", "Ass"};
		int num = 0;
		
		for(int i = 0; i < kartenNahmen.length; i++)
		{
			for(int j = 0; j < symbole.length; j++)
			{
				karten.add(new Karte(i > 8 ? 10 : i + 2, symbole[j] + " " + kartenNahmen[i]));
			}
		}
		kartenMischen();
	}
	
	private void kartenMischen()
	{
		for(int i = 0; i < karten.size(); i++)
		{
			int ind = (int) (Math.random() * karten.size() - 1);
			Karte k = karten.get(ind);
			karten.set(ind, karten.get(i));
			karten.set(i, k);
		}
	}
	
	public Karte zufaelligeKarteZiehen()
	{
	
		int ind =(int)(Math.random() * karten.size() - 1);
		//return new Karte(0, "");
		//Karte zufaelligeKarte = karten.get(ind);
		System.out.println("Sie haben Karte " + karten.get(ind).getBezeichnung() + " bekommen");
		Karte zufaelligeKarte = karten.get(ind);
		karten.remove(ind);
		return zufaelligeKarte;
	}
}
