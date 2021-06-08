// subklasse av Resept
// har 75% rabatt på alt

public class BlaaResept extends Resept {
	static String farge = "blaa";
	static double rabatt = 0.25;
	
	// konstruktør, med parametere legemiddel, lege, pasientid og reit
	BlaaResept (Legemiddel m, Fastlege l, Pasient p, int r) {
		// sende argumentene videre til superklassens konstruktør
		super(m, l, p, r);
	}
	
	// hent ut reseptens farge
	public String farge () {
		return farge;
	}
	
	// hent ut pris på legemiddelet, med eventuelle rabatter
	public double prisAaBetale () {
		// regne ut rabatt og returner
		return legemiddel.hentPris() * rabatt;
	}
}


