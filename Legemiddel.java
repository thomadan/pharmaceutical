

// abstrakt fordi denne skal ikke instantieres, er kun superklasse
abstract public class Legemiddel {

	static int idTeller = 0;	// holde orden på instansers ID, derfor statisk.
	int id;						// legemiddels ID
	String navn;				// navn på legemiddel
	double virkestoffMengde;	// mengde virkestoff i legemiddel
	double pris;				// pris på legemiddel
	String type = "";			// legemiddelets type
	
	// konstruktør, med parametere navn, mengde virkestoff og pris
	Legemiddel (String n, double v, double p) {
		idTeller++;				// finne ny ledig ID for legemiddel
		id = idTeller;			// gi legemiddelet ID
		navn = n;				// gi navn fra parameter
		virkestoffMengde = v;	// få mengde virkestoff fra parameter
		pris = p;				// sette pris fra parameter
	}
	
	public int hentID () {
		return id;
	}
	
	public String hentNavn () {
		return navn;
	}
	
	public double hentPris () {
		return pris;	
	}
	
	public double hentVirkestoffMengde () {
		return virkestoffMengde;
	}
	
	public void settNyPris (double p) {
		pris = p;
	}
	
	public String hentType() {
		return type;
	}
}
