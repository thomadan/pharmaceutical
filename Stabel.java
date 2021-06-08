
// arver fra lenkeliste, kan bare legge til og ta av fra slutten av listen.

public class Stabel<T> extends Lenkeliste<T> {
	
	// legg på objekt på slutten av listen
	public void leggPaa(T objektAaLeggePaa) {
			
		// bruker bare leggtil() her
		leggTil(objektAaLeggePaa);
	}
	
	
	// ta av objekt fra slutten av listen
	public T taAv() {
		
		// la den eksisterende fjern() ta seg av dette 
		// ved å sende som parameter høyeste indeks
		return fjern(stoerrelse() - 1);
	} 
}