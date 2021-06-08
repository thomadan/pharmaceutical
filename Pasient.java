

public class Pasient {
	
	private String navn;
	private String foedselsnummer;		
	static int idTeller = 0;			// holde orden på instansers ID, derfor statisk.
	int id;								// pasientens ID
	
	// liste av subtypen stabel, for å holde resepter
	private Liste<Resept> reseptListe = new Stabel<Resept>();

	// konstruktør, tar imot navn og fødselsnummer
	Pasient(String n, String f) {
		navn = n;
		foedselsnummer = f;
		id = idTeller;
		idTeller++;
	}
	
	// metode for å hente ut pasientens navn
	public String hentNavn() {
		return navn;
	}
	
	// metode for å hente ut pasientens fødselsnummer
	public String hentFoedselsnummer() {
		return foedselsnummer;
	}
		
	// hente ut reseptliste
	public Liste<Resept> getReseptListe() {
		return reseptListe;
	}
	
	// legge til resept i pasientens reseptliste
	public void leggTilResept(Resept resept) {
		reseptListe.leggTil(resept);
	}
	
	
	
	
	
	
	
	
	
	
}