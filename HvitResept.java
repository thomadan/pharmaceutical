

// abstrakt fordi denne skal ikke instantieres, er kun superklasse
abstract public class HvitResept extends Resept {
	static String farge = "hvit";
	
	// konstruktør, med parametere navn, mengde virkestoff og pris
	HvitResept (Legemiddel m, Fastlege l, Pasient p, int r) {
		super(m, l, p, r);
	}
	
	abstract public String farge();
	
	abstract public double prisAaBetale();
}
