

public class LegemiddelB extends Legemiddel {

	int vanedannendeStyrke;
    // konstruktør, med parametere navn, mengde virkestoff og pris
	LegemiddelB (String n, double v, double p, int s) {
		super(n, v, p);
		vanedannendeStyrke = s;
		type = "b";
	}
	
	public int hentVanedannendeStyrke () {
		return vanedannendeStyrke;
	}
}
