


public class MilitaerResept extends HvitResept {
	static double rabatt = 0;
	
	// konstruktør, med parametere navn, mengde virkestoff og pris
	MilitaerResept (Legemiddel m, Fastlege l, Pasient p, int r) {
		super(m, l, p, r);
		type = "militaer";
	}
	
	public String farge () {
		return farge;
	}
	
	public double prisAaBetale () {
		return legemiddel.hentPris() * rabatt;
	}
}
