

public class LegemiddelA extends Legemiddel {

	int narkotiskStyrke;
    // konstruktør, med parametere navn, mengde virkestoff og pris
	LegemiddelA (String n, double v, double p, int s) {
		super(n, v, p);
		narkotiskStyrke = s;
		type = "a";
	}
	
	public int hentNarkotiskStyrke () {
		return narkotiskStyrke;
	}
	
}
