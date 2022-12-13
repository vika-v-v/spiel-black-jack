package BlackJack;

import java.util.*;

public class Spieler {
	private String name;
	private List<Karte> karten = new ArrayList<>();
	private boolean fertig = false;
	private int punkte = 0;
	
	
	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public void KarteHinzufuegen(Karte karte) {
		karten.add(karte);
	}
	
	public String getName() {
		return name;
	}
	
	public Spieler(String name, List<Karte> karten) {
		super();
		this.name = name;
		this.karten = karten;
	}
	public List<Karte> getKarten() {
		return karten;
	}
	
	public void karteBekommen(Karte karte)
	{
		this.karten.add(karte);
		punkte += karte.getPunkte();
	}

	public boolean isFertig() {
		return fertig;
	}

	public void setFertig(boolean fertig) {
		this.fertig = fertig;
	}
	
	
}
