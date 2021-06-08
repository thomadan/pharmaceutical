

// klasse for lenkeliste, implementerer grensesnittet Liste<T>
// listen består av instanser av klassen noder, som inneholder objekter gitt til nodens konstruktør
// nye noder legges til på starten av listen, og den eldste noden er bakerst.
// nodene er lenket sammen ved at en node peker på sin eldre nabo
// man kan sjekke størrelse, legge til, ...

import java.util.Iterator;


public class Lenkeliste<T> implements Liste<T> {
	
	// første node blir ikke initialisert her
	Node anker;
	
	// en node er en beholder for objekter
	// en node er lenket sammen via en peker til nabo-noden
	class Node {
		
		// variabel for objektet som skal puttes i noden via parameter til konstruktør
        T objekt;
		
		// peker til sin eldre nabo-node
        Node neste;

		// konstruktør: hente inn objekt gitt som parameter utenfra
        public Node(T o) {
            objekt = o;
        }
    }
	
		
	// for å iterere over liste
	class LenkelisteIterator implements Iterator<T> {
		
		private Lenkeliste<T> minListe;
		
		private int indeks = 0;
		
		public LenkelisteIterator(Lenkeliste<T> lx) {
			minListe = lx;
		}
		
		public boolean hasNext() {
			return indeks < minListe.stoerrelse();
		}
		
		public T next() {
			return minListe.hent(indeks++);
		}
	}

		
		
		
		
		
		
		
		
		/*
		// er det et objekt til?
		public boolean hasNext() {
			// placeholder returverdi
			return false;
		}
		
		
		// finn frem neste objekt
		public T next() {
			// placeholder returverdi
			return anker.objekt;
			
		}
		
		
		*/
		
		//remove();
		
	
	
	// sjekke hvor mange noder som er i listen
	// dette gjøres ved å vandre fra ankeret og bakover gjennom listen helt til noden man er på er null
	public int stoerrelse() {
	
		// referanse til noden man befinner seg på for øyeblikket, begynner med ankeret
        Node naavaerendeNode = anker;		
		
		// teller for hvor mange noder som finnes i listen
        int listeLengde = 0;									

		// så lenge det er flere noder å telle, sjekkes ved at noden man er på ikke er null
        while (naavaerendeNode != null) {
			
			// tell med noden
            listeLengde++;		

			// gå til neste node for å sjekke om den finnes (ikke er null)
            naavaerendeNode = naavaerendeNode.neste;							
        }

		// send tilbake antall noder
        return listeLengde;										
	}
	
	
	// legge til et objekt i listen, på en viss indeks
	public void leggTil(int oensketIndeks, T gittObjekt) {
		// lage ny node med objekt fra parameter, denne noden er her ikke lenket enda
        Node nyNode = new Node(gittObjekt);
		
		// peker til noden man håndterer for øyeblikket, man starter på ankeret
		Node naavaerendeNode = anker;	
		
		// finne hvilken indeks nyeste node, ankeret, den som har høyest indeks, har
		// trekke fra 1 fordi størrelse 1 er indeks 0, osv.
		int naavaerendeIndeks = stoerrelse() - 1;		
			
		System.out.println("stor: " + stoerrelse());
		// passe på å fange ugyldige indekser
		if (oensketIndeks > stoerrelse() || oensketIndeks < 0) {
			throw new UgyldigListeIndeks(naavaerendeIndeks);
		}	
			
		// før man legger ny node til i lenken, sjekke om dette er aller første node
		if (anker == null) {
			
			// i så fall, la den nye noden være anker
			anker = nyNode;
		}
		
		// hvis noden skal på bunnen, altså indeks 0
		else if (oensketIndeks == 0) {	
			
			// nå skal man telle seg baklengs til ønsket indeks, fra ankeret
			// så lenge man ikke har kommet langt nok tilbake til ønsket indeks enda
			while (naavaerendeIndeks > oensketIndeks) {	

				// gå ett steg baklengs i listen
				naavaerendeNode = naavaerendeNode.neste;
			
				// registrere at et steg er gått
				naavaerendeIndeks--;
			}
			
			// når man har kommet til indeks 0
			// sett tidligere indeks 0s neste til nyNode 
			naavaerendeNode.neste = nyNode;
		}	
		
		// hvis noden skal på toppen, altså bakerst
		else if (oensketIndeks >= naavaerendeIndeks) {	
			// sette ankeret til ny node
			anker = nyNode;
			
			// sette ankerets neste til den som tidligere var bakerst
			anker.neste = naavaerendeNode;
		}	
		
		// hvis noden skal på midten
		else if (stoerrelse() > 2 && oensketIndeks > 0) {		
			
			// nå skal man telle seg baklengs til ønsket indeks, fra ankeret
			// så lenge man ikke har kommet tilbake til ønsket indeks enda
			while (naavaerendeIndeks > oensketIndeks) {	

				// gå ett steg baklengs i listen
				naavaerendeNode = naavaerendeNode.neste;
				
				// registrere at et steg er gått
				naavaerendeIndeks--;
			}
			
			// når man har kommet til rett indeks
			// koble ny node til fremre node
			nyNode.neste = naavaerendeNode.neste;
			
			// koble ny node til bakre node
			naavaerendeNode.neste = nyNode;
		}
	}
	
	
	// legge til et objekt på starten av listen, dvs ankeret flyttes til den nye noden
	public void leggTil(T o) {
		
		// lage ny node med objekt fra parameter, denne noden er her ikke lenket enda
        Node nyNode = new Node(o);
		
		// før man legger ny node til i lenken, sjekke om dette er aller første node
		if (anker == null) {
			
			// i så fall, la den nye noden være anker
			anker = nyNode;
			
		// hvis anker allerede finnes
		} else {	
		
			// la den nye noden peke på den eldre noden ...
			nyNode.neste = anker;
			
			// ... og sette den nye noden som anker
			// den nye noden er nå første node, mens den tidligere første noden er nest først
			anker = nyNode;
		}
	}
	
	
	// erstatt objekt i node med et annet objekt gitt i parameter
	public void sett(int oensketIndeks, T erstattendeObjekt) {
		
		// peker til noden man håndterer for øyeblikket, man starter på ankeret
		Node naavaerendeNode = anker;	
		
		// finne hvilken indeks nyeste node, ankeret, den som har høyest indeks, har
		// trekke fra 1 fordi størrelse 1 er indeks 0, osv.
		int naavaerendeIndeks = stoerrelse() - 1;		
		
		// passe på å fange ugyldige indekser
		if (oensketIndeks > stoerrelse() - 1 || oensketIndeks < 0) {
			throw new UgyldigListeIndeks(naavaerendeIndeks);
		}
			
		// nå skal man telle seg baklengs til ønsket indeks, fra ankeret
		// så lenge man ikke har kommet langt nok tilbake til ønsket indeks enda
		while (naavaerendeIndeks > oensketIndeks) {	

			// gå ett steg baklengs i listen
			naavaerendeNode = naavaerendeNode.neste;
		
			// registrere at et steg er gått
			naavaerendeIndeks--;
		}
		
		// passe på å fange ugyldige indekser
		if (naavaerendeNode == null) {
			throw new UgyldigListeIndeks(naavaerendeIndeks);
		}
		
		// når man har kommet til rett indeks
		// sett rett indeks til nytt objekt 
		naavaerendeNode.objekt = erstattendeObjekt;
	}
	

	// hente objekt fra en node på indeks gitt som parameter
	// husk at indeks 0, altså eldste node, er underst, mens ankeret, nyeste node, er øverst
	// man må altså bla seg baklengs fra høyeste indeks
	public T hent(int oensketIndeks) {
		
		// finne hvilken indeks nyeste node, ankeret, den som har høyest indeks, har
		// trekke fra 1 fordi størrelse 1 er indeks 0, osv.
		int naavaerendeIndeks = stoerrelse() - 1;
		
		// peker til noden man håndterer for øyeblikket, man starter på ankeret
		Node naavaerendeNode = anker;						
		
		// passe på å fange ugyldige indekser
		if (oensketIndeks > stoerrelse() - 1) {
			throw new UgyldigListeIndeks(naavaerendeIndeks);
		}
		
		// nå skal man telle seg baklengs til ønsket indeks, fra ankeret
		// så lenge man ikke har kommet langt nok tilbake til ønsket indeks enda
		while (naavaerendeIndeks > oensketIndeks) {	

			// gå ett steg baklengs i listen
			naavaerendeNode = naavaerendeNode.neste;
		
			// registrere at et steg er gått
			naavaerendeIndeks--;
		}
		
		// passe på å fange ugyldige indekser
		if (naavaerendeNode == null) {
			throw new UgyldigListeIndeks(naavaerendeIndeks);
		}
		
		// returner objekt fra ønsket indeks
		return naavaerendeNode.objekt;
	}
	
	
	// fjerne den første noden som ble satt inn, altså indeks 0
	// dette gjøres ved å telle tilbake til indeks 1
	// fordi indeks 1 har lenken til den noden man skal ha tak i
	// i tillegg skal man returnere objektet som var i denne noden
	public T fjern(int oensketIndeks) {
		
		// peker til noden man håndterer for øyeblikket, man starter på ankeret
		Node naavaerendeNode = anker;	
		
		// holder for det objekt som skal returneres, fordi objektets node skal jo slettes
		T objektAaReturnere = null;
	
		// finne hvilken indeks nyeste node, ankeret, den som har høyest indeks, har
		// trekke fra 1 fordi størrelse 1 er indeks 0, osv.
		int naavaerendeIndeks = stoerrelse() - 1;
	
		// hvis det bare er en node, skal den selv slettes
		// sletter like godt hele noden, siden node uten objekt er ubrukelig
		if (stoerrelse() == 1) {
			// spare objektet fra noden som skal slettes
			objektAaReturnere = naavaerendeNode.objekt;
			
			// slette koblingen til indeks 0
			anker = null;
		}
		
		// hvis det er flere noder, og nederste node skal slettes
		else if (stoerrelse() > 1 && oensketIndeks == 0) {		
		
			// nå skal man telle seg baklengs til ønsket indeks, fra ankeret
			// så lenge man ikke har kommet tilbake til ønsket indeks enda
			// + 1 for å komme til den før
			while (naavaerendeIndeks > oensketIndeks + 1) {	

				// gå ett steg baklengs i listen
				naavaerendeNode = naavaerendeNode.neste;
				
				// registrere at et steg er gått
				naavaerendeIndeks--;
			}
			
			// når man har kommet til rett indeks
			// spare objektet fra noden som skal slettes
			objektAaReturnere = naavaerendeNode.neste.objekt;
			
			// slette koblingen til indeks man skal slette
			naavaerendeNode.neste = null;
		}
		
		// hvis det er flere noder, og øverste node skal slettes,
		// må man legge ankeret til nåværende node.neste
		else if (stoerrelse() > 1 && naavaerendeIndeks == oensketIndeks) {	
		
			// spare objektet fra øverste node, som skal slettes
			objektAaReturnere = naavaerendeNode.objekt;
			
			// flytte ankerets kobling til ankerets .neste 
			anker = naavaerendeNode.neste;
		}
	
		// hvis objektet som skal fjernes er midt i
		// må man knytte både før og etter.
		else if (stoerrelse() > 2 && oensketIndeks > 0) {		
		
			// nå skal man telle seg baklengs til ønsket indeks, fra ankeret
			// så lenge man ikke har kommet tilbake til ønsket indeks enda
			// + 1 for å komme til den før
			while (naavaerendeIndeks > oensketIndeks + 1) {	

				// gå ett steg baklengs i listen
				naavaerendeNode = naavaerendeNode.neste;
				
				// registrere at et steg er gått
				naavaerendeIndeks--;
			}
			
			// når man har kommet til rett indeks
			// spare objektet fra noden som skal slettes
			objektAaReturnere = naavaerendeNode.neste.objekt;
			
			// slette koblingen til indeks man skal slette
			naavaerendeNode.neste = naavaerendeNode.neste.neste;
		}

		// passe på å fange ugyldig indeks
		if (objektAaReturnere == null) {
			throw new UgyldigListeIndeks(naavaerendeIndeks);
		}
		
		return objektAaReturnere;
	}
	
	
	// fjern uten parameter sender fjern(0)
	public T fjern() {
		return fjern(0);
	}	
	
	
	
	
	
	// for iteratoren
	public Iterator<T> iterator() {
		
		// returnere et lenkelisteiterator-objekt
		return new LenkelisteIterator(this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}