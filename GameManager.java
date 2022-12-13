package BlackJack;

import java.io.*;

import java.util.*;

import edu.princeton.cs.introcs.StdIn;

public class GameManager {
	public static void main(String[] args) {
		System.out.println("Wie viele Spieler sind im Spiel?");
		int num = StdIn.readInt();
		
		Spieler[] spieler = new Spieler[num];
		for(int i = 0; i < spieler.length; i++)
		{
			System.out.println("Was ist der Name des " + (i + 1) + "'s Spielers?");
			spieler[i] = new Spieler(StdIn.readString(), new ArrayList<Karte>());
		}
		
		String command;
		int spielerDran = -1;
		int mengeStehen = 0;
		boolean beendet = false;
		Kartendeck deck = new Kartendeck();
		deck.kartendeckFuellen();
		
		do {
			spielerDran = spielerDran + 1 >= spieler.length ? 0 : spielerDran + 1;
			System.out.println(spieler[spielerDran].getName() + " ist am Zug, punkte: " + spieler[spielerDran].getPunkte());
			System.out.println("Wollen sie ziehen oder stehen? z, s");
			command = StdIn.readString(); // ziehen, stehen
			if(command.equals("z"))
			{
				spieler[spielerDran].karteBekommen(deck.zufaelligeKarteZiehen());
				System.out.println("Ihre Punkte: " + spieler[spielerDran].getPunkte());
				if(spieler[spielerDran].getPunkte() >= 21) 
				{
					beendet = true;
					if(spieler[spielerDran].getPunkte() > 21) spieler[spielerDran].setPunkte(-1);
				}
				
			}
			else
			{
				spieler[spielerDran].setFertig(true);
				mengeStehen++;
				if(mengeStehen >= spieler.length) beendet = true;
			} 
			System.out.println();
			
			
			
		} while (!beendet);
		
		int maxInd = 0;
		for(int i = 0; i < spieler.length; i++)
		{
			if(spieler[maxInd].getPunkte() < spieler[i].getPunkte() && spieler[i].getPunkte() <= 21) maxInd = i;
		}
		
		System.out.println(spieler[maxInd].getName() + " hat gewonnen");
	}

}
