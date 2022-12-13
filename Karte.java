package BlackJack;

public class Karte {
	private int punkte;
	private String bezeichnung;
	
	public Karte(int punkte, String bezeichnung) {
		super();
		this.punkte = punkte;
		this.bezeichnung = bezeichnung;
	}
	public int getPunkte() {
		return punkte;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	
}
