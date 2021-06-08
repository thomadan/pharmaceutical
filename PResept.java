


public class PResept extends HvitResept {
	static double rabatt = 116;	
	
	// konstruktør, med parametere ,.,, merk at reit alltid er 3
	PResept (Legemiddel m, Fastlege l, Pasient p, int r) {
		super(m, l, p, 3);
	}
	
	public String farge () {
		return farge;
	}
	
	public double prisAaBetale () {
		double prisen = legemiddel.hentPris() - rabatt;
		if (prisen < 0) {
			prisen = 0;
		}
		return prisen;
	}
}
