

// importere utskriftsfunksjonalitet
import java.io.*;	

// abstrakt fordi denne skal ikke instantieres, er kun superklasse
abstract public class Resept {

	static int idTeller = 0;	// holde orden på instansers ID, derfor statisk.
	int id;						// legemiddels ID
	Legemiddel legemiddel;		// navn på legemiddel
	Fastlege lege;				// 
	Pasient pasient;			// 
	int reit;					// hvor mange ganger resepten varer
	String type = "";			// hvilken type resept
	
	// konstruktør, med parametere navn, mengde virkestoff og pris
	Resept (Legemiddel m, Fastlege l, Pasient p, int r) {
		idTeller++;
		id = idTeller;
		legemiddel = m;
		lege = l;
		pasient = p;
		reit = r;
	}
	
	public int hentID () {
		return id;
	}
	
	public Legemiddel hentLegemiddel () {
		return legemiddel;
	}
	
	public String hentLege () {
		return lege.hentNavn();	
	}
	
	public Pasient hentPasient () {
		return pasient;	
	}
	
	public int hentReit () {
		return reit;	
	}
	
	public boolean bruk () {
		if (reit > 0) {
			reit--;
			return true;
		} else {
			return false;
		}
	}
	
	
	public String hentType() {
		return type;
	}
	
	
	abstract public String farge ();
	
	abstract public double prisAaBetale ();

}
