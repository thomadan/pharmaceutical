

public class Lege implements Comparable<Lege> {
	String navn;
    Liste<Resept> reseptListe = new Lenkeliste<Resept>();

	// konstruktør, tar parameter legens navn
	Lege(String n) {
		navn = n;
	}
	
	public String hentNavn() {
		return navn;
	}
	
	// metode fra grensesnittet comparable, for å alfabetisere legers navn
	public int compareTo(Lege gittLege) {
		
		// sjekke gitt leges navn i forhold til denne leges navn 
		return gittLege.navn.compareTo(navn);
	}
	
	// metode for å legge til og hente ut resepter fra listen over resepter
	public void leggTilResept(Resept gittResept) {
		
		// legg til gitt resept på toppen av reseptlisten
		reseptListe.leggTil(gittResept);
	}
	
	// metode for å hente ut listen over resepter
	public Liste<Resept> hentReseptListe() {
		return reseptListe;
	}
}

