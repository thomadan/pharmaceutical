
// subklasse av Lege
// implementerer Kommuneavtale for å hente avtalenummer

public class Fastlege extends Lege implements Kommuneavtale {
	// avtalenummeret
	int avtaleNummer;									
	
	// konstruktøren, har parameterne navn og avtalenummer
	Fastlege (String n, int a) {
		// sende videre argumentet navn til superklassens konstruktør
		super(n);		
		avtaleNummer = a;
	}
	
	public String hentNavn() {
		return navn;
	}
	
	public int hentAvtalenummer(){
		return avtaleNummer;
	}
}
