

import java.util.Collections;

// for brukerinput fra keyboard
import java.util.Scanner;


// hovedprogram for brukeroperasjon av legesystem
public class Legesystem {
	
	// liste over pasienter
	private static Liste<Pasient> pasientListe = new Lenkeliste<Pasient>();
	
	// liste over leger
	private static Liste<Fastlege> legeListe = new Lenkeliste<Fastlege>();
	
	// liste over legemidler
	private static Liste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
	
	// liste over resepter
	private static Liste<Resept> reseptListe = new Lenkeliste<Resept>();	
	
	// opprette scanner av keyboard-input
	private static Scanner inputScanner = new Scanner(System.in);
	
	// variabel for å lagre brukerinput fra keyboard
	private static int brukerInput;
	
	// hovedmetoden som kjører når programmet starter
	public static void main(String[] args) {
		
		// velkomstbeskjed
		wipeScreen();
		System.out.println();
		System.out.println("Velkommen til Legesystem 2000");
		
		// skrive meny til skjerm
		skrivHovedmeny();
	}
	
	// skrive hovedmeny til skjerm
	private static void skrivHovedmeny() {
		
		// skrive meny til skjerm
		wipeScreen();
		System.out.println("### HOVEDMENY ###");
		System.out.println();
		System.out.println("1: Se oversikt over alle data");
		System.out.println("2: Legge til element");
		System.out.println("3: Bruk resept");
		System.out.println("4: Skriv ut statistikk");
		System.out.println("0: Avslutt programmet");
		System.out.println();
		
		// ta imot brukers menyvalg
		mottaMenyvalg("hovedmeny");
	}
	
	// skrive adderingsmeny til skjerm
	private static void skrivAdderingsmeny() {
		
		// skrive meny til skjerm
		wipeScreen();
		System.out.println("Hva ønsker du å legge til?");
		System.out.println();
		System.out.println("1: Pasient");
		System.out.println("2: Lege");
		System.out.println("3: Legemiddel");
		System.out.println("4: Resept");
		System.out.println("0: Tilbake til hovedmeny");
		System.out.println();
		
		// ta imot brukers menyvalg
		mottaMenyvalg("adderingsmeny");
	}
	

	// skrive statistikkmeny til skjerm
	private static void skrivStatistikkmeny() {
		
		// skrive meny til skjerm
		wipeScreen();
		System.out.println("Hva ønsker du å se tall på?");
		System.out.println();
		System.out.println("1: Utskrevne resepter på vanedannende legemidler");
		System.out.println("2: Vanedannende resepter utskrevet til militære");
		System.out.println("3: Statistikk om mulig misbruk");
		System.out.println("0: Tilbake til hovedmeny");
		System.out.println();
		
		// ta imot brukers menyvalg
		mottaMenyvalg("statistikkmeny");
	}
		
	
	
	
	
	// ta imot brukerinput fra tastatur, med parameter hvilken meny man er i
	private static void mottaMenyvalg(String meny) {
		
		// sjekke om bruker tastet gyldig type
		
		try {
			
			// ta imot brukerinput
			
			brukerInput = Integer.parseInt(inputScanner.nextLine());
			
		// hvis ugyldig type,
		} catch (Exception e) {
			wipeScreen();
			System.out.println("Ugyldig input, må være integer.");
			System.out.print("Trykk Enter for å fortsette.");
			inputScanner.nextLine();
			
			// hvis man var i hovedmenyen, gå tilbake til hovedmeny
			if (meny == "hovedmeny") {
				skrivHovedmeny();				
			}
			
			else if (meny == "adderingsmeny") {
				skrivAdderingsmeny();				
			}
			
			else if (meny == "statistikkmeny") {
				skrivStatistikkmeny();
			}
		
			
		}

		// sjekke hvilket menyvalg bruker tastet
		sjekkMenyvalg(meny);
	}
	
	
	private static void sjekkMenyvalg(String meny) {
		
		// hvis det var fra hovedmenyen bruker valgte menyelement
		if (meny == "hovedmeny") {
			
			// sjekke hva bruker valgte
			switch (brukerInput) {
				
				case 1:
				
					// skriv ut oversikt
					skrivUtOversikt();
					break;
				
				case 2:
				
					// legg til et element
					leggTilElement();
					break;
					
				case 3:
				
					// bruk resept
					brukResept();
					break;
					
				case 4:
				
					// skriv ut statistikk
					skrivUtStatistikk();
					break;	
						
				case 0:
				
					// avslutt
					System.out.println("Avslutter programmet ...");			
					break;	
					
					
						   
				// hvis bruker tastet noe annet
				default: 
					wipeScreen();
					System.out.println("Ugyldig menyvalg.");
					System.out.print("Trykk Enter for å fortsette.");
					inputScanner.nextLine();
							
					skrivHovedmeny();				
			}
		}
		
		// hvis det var fra adderingsmenyen bruker valgte menyelement
		if (meny == "adderingsmeny") {
			
			// sjekke hva bruker valgte
			switch (brukerInput) {
				case 1:
				
					// legg til en pasient
					leggTilPasient();
					break;
				case 2:
				
					// legg til en lege
					leggTilLege();
					break;
				case 3:
				
					// legg til et legemiddel
					leggTilLegemiddel();
					break;
					
				case 4:
				
					// legg til en resept
					leggTilResept();
					break;
					
				
				case 0:
				
					// tilbake til hovedmeny
					skrivHovedmeny();
					break;	
			
				// hvis bruker tastet noe annet
				default: 
					wipeScreen();
					System.out.println("Ugyldig menyvalg.");
					System.out.print("Trykk Enter for å fortsette.");
					inputScanner.nextLine();
							
					skrivAdderingsmeny();				
			}
		}
		
		
		
		
		// hvis det var fra statistikkmenyen bruker valgte menyelement
		if (meny == "statistikkmeny") {
			
			// sjekke hva bruker valgte
			switch (brukerInput) {
				case 1:
				
					// skriv ut vanedannende resepter
					skrivUtVanedannende();
					break;
					
				case 2:
				
					// skriv ut vanedannende resepter for militære
					skrivUtVanedannendeMilitaere();
					break;
					
				case 3:
				
					// skriv ut statistikk for mulig misbruk
					skrivUtMisbrukStatistikk();
					break;
				
				case 0:
				
					// tilbake til hovedmeny
					skrivHovedmeny();
					break;	
			
				// hvis bruker tastet noe annet
				default: 
					wipeScreen();
					System.out.println("Ugyldig menyvalg.");
					System.out.print("Trykk Enter for å fortsette.");
					inputScanner.nextLine();
							
					skrivAdderingsmeny();				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	private static void leggTilElement() {
		skrivAdderingsmeny();
	}
	
	private static void leggTilPasient() {
		
		// preparere skjermen for å legge til ny pasient
		wipeScreen();
		System.out.println("Du har valgt å legge til ny pasient.");
		
		// hente navn fra brukerinput
		System.out.println("Hva er pasientens navn?");
		String pasientNavn = inputScanner.nextLine();
		
		// hente fødselsnummer fra brukerinput
		System.out.println("Hva er pasientens fødselsnummer?");
		String foedselsnummer = inputScanner.nextLine();
		
		// legge ny pasient til pasientlisten
		System.out.println("\nPrøver å legge til ny pasient i pasientlisten.");
		pasientListe.leggTil(new Pasient(pasientNavn, foedselsnummer));
		System.out.println("Vellykket.");
		
		// finne tilbake til pasienten i listen, på fødselsnummer, for å sjekke at det gikk bra
		int pasientListeIndeks = 0;
			
		try {
			while (pasientListe.hent(pasientListeIndeks) != null) {

				if (pasientListe.hent(pasientListeIndeks).hentFoedselsnummer() == foedselsnummer) {
					System.out.println("Du la til pasient " + pasientListe.hent(pasientListeIndeks).hentNavn());
				}		
				pasientListeIndeks++;
			}
			
		} catch (Exception UgyldigListeIndeks) {
			// det finnes ikke flere objekter
		}
		
		System.out.println("Trykk Enter for å fortsette.");
		inputScanner.nextLine();	
		skrivHovedmeny();
	}
	
	private static void leggTilLege() {
		
		// preparere skjermen for å legge til ny pasient
		wipeScreen();
		System.out.println("Du har valgt å legge til ny lege.");
				
		// hente navn fra brukerinput
		System.out.println("Hva er legens navn?");
		String gittLegeNavn = inputScanner.nextLine();
		
		// hente avtalenummer fra brukerinput
		System.out.println("Hva er legens avtalenummer? (0 hvis ikke avtale)");
		int avtaleNummer = Integer.parseInt(inputScanner.nextLine());
		
		// legge ny pasient til pasientlisten (fastlege, fordi ???)
		System.out.println("\nPrøver å legge til ny lege i legelisten.");
		legeListe.leggTil(new Fastlege(gittLegeNavn, avtaleNummer));
		System.out.println("Vellykket.");
		
		// finne tilbake til pasienten i listen, på fødselsnummer, for å sjekke at det gikk bra
		int legeListeIndeks = 0;
			
		try {
			while (legeListe.hent(legeListeIndeks) != null) {

				if (legeListe.hent(legeListeIndeks).hentNavn() == gittLegeNavn) {
					System.out.println("Du la til lege " + legeListe.hent(legeListeIndeks).hentNavn());
				}		
				legeListeIndeks++;
			}
			
		} catch (Exception UgyldigListeIndeks) {
			// det finnes ikke flere objekter
		}
		
		System.out.print("Trykk Enter for å fortsette.");
		inputScanner.nextLine();
		
		skrivHovedmeny();
	}

	private static void leggTilLegemiddel() {
		
		Legemiddel nyttLegemiddel;
		
		// TODO: skrive info til skjerm
		
		// spørre hvilken type legemiddel bruker skal legge til
		String legemiddelType;
		System.out.print("Hvilken type legemiddel er det? (A, B, C)");
		legemiddelType = inputScanner.nextLine().toLowerCase();
		
		// spørre om navn på legemiddel
		String legemiddelNavn;
		System.out.print("Hva er legemiddelets navn?");
		legemiddelNavn = inputScanner.nextLine();

		
		// spørre om mengde virkestoff
		double virkestoff;
		System.out.print("Hvor mye virkestoff er det i legemiddelet? (mg)");
		virkestoff = Double.parseDouble(inputScanner.nextLine());

		// spørre om pris
		double legemiddelPris;
		System.out.print("Hva koster legemiddelet?");
		legemiddelPris = Double.parseDouble(inputScanner.nextLine());
	
	
		// legge nytt legemiddel til legemiddellisten
		
		if (legemiddelType.equals("a")) {
			// spørre om narkotisk styrke
			int narkotiskStyrke;
			System.out.print("Hva er legemiddelets narkotiske styrke?");
			narkotiskStyrke = Integer.parseInt(inputScanner.nextLine());
			
			nyttLegemiddel = new LegemiddelA(legemiddelNavn, virkestoff, legemiddelPris, narkotiskStyrke);
			legemiddelListe.leggTil(nyttLegemiddel);
		}
		
		else if (legemiddelType.equals("b")) {
			
			// spørre om vanedannende styrke
			int vanedannendeStyrke;
			System.out.print("Hva er legemiddelets vanedannende styrke?");
			vanedannendeStyrke = Integer.parseInt(inputScanner.nextLine());
			
			nyttLegemiddel = new LegemiddelB(legemiddelNavn, virkestoff, legemiddelPris, vanedannendeStyrke);
			legemiddelListe.leggTil(nyttLegemiddel);
		}
		
		else if (legemiddelType.equals("c")) {
			nyttLegemiddel = new LegemiddelC(legemiddelNavn, virkestoff, legemiddelPris);
			legemiddelListe.leggTil(nyttLegemiddel);
		}
		
		
		// finne tilbake til pasienten i listen, på fødselsnummer, for å sjekke at det gikk bra
		int legemiddelListeIndeks = 0;
			
		try {
			
			while (legemiddelListe.hent(legemiddelListeIndeks) != null) {

				if (legemiddelListe.hent(legemiddelListeIndeks).hentNavn() == legemiddelNavn
				    && legemiddelListe.hent(legemiddelListeIndeks).hentVirkestoffMengde() == virkestoff) {
					System.out.println("Du la til legemiddel " + legemiddelListe.hent(legemiddelListeIndeks).hentNavn());
				}		
				legemiddelListeIndeks++;
			}
			
		} catch (Exception UgyldigListeIndeks) {
			// det finnes ikke flere objekter
		}
		
		System.out.print("Trykk Enter for å fortsette.");
		inputScanner.nextLine();
		
		skrivHovedmeny();
	}
			

	private static void leggTilResept() {	
	
		// spørre hvilken type resept bruker skal legge til
		String reseptType;
		System.out.print("Hvilken type resept er det? (blaa, p, militaer)");
		reseptType = inputScanner.nextLine();		
		
		
		// ##########################################################################
		// spørre hvilket legemiddel som skal skrives ut
		System.out.print("Hvilket legemiddel er det?");
		String legemiddelNavn = inputScanner.nextLine();
		
		// holder for legemiddel som tas ut fra listen og skal sendes til resept-konstruktøren
		Legemiddel legemiddel = null;
		
		// finne legemiddel i listen, fange indeksfeil
		try {
			
			// sette indeks til nederste element
			int indeks = 0;
			
			// hvis det er et legemiddel på gitt indeks
			while (legemiddelListe.hent(indeks) != null) {

				// hvis dette er rett legemiddel
				if (legemiddelListe.hent(indeks).hentNavn().equals(legemiddelNavn)) {
					
					System.out.print("Fant legemiddel");
					legemiddel = legemiddelListe.hent(indeks);
					// gå videre, nå har vi rett legemiddel
					break;
				}	
				
				// hvis dette ikke er rett legemiddel
				else {
					
					// gå til neste legemiddelindeks for å sjekke denne
					indeks++;
					legemiddel = legemiddelListe.hent(indeks);
				}
			}
		
		} catch (Exception UgyldigListeIndeks) {
			// det finnes ikke flere objekter
		}
		
		
		// ###############################################################################
		// spørre hvilken lege som skal skrive ut
		
		// holder for å putte legen som skal som argument til resept-konstruktør
		Fastlege lege = null;
		
		// spørre hvilken lege som skal skrive ut
		System.out.print("Hvilken lege er det?");
		String legeNavn = inputScanner.nextLine();
		
		
		// finne lege i listen, fange indeksfeil
		try {
			
			// sette indeks til nederste element
			int indeks = 0;
			
			// hvis det er en lege på gitt indeks
			while (legeListe.hent(indeks) != null) {

				// hvis dette er rett lege
				if (legeListe.hent(indeks).hentNavn().equals(legeNavn)) {
					
					System.out.print("Fant lege");
					// gå videre, nå har vi rett lege
					break;
				}	
				
				// hvis dette ikke er rett lege
				else {
					
					// gå til neste legeindeks for å sjekke denne
					indeks++;
					lege = legeListe.hent(indeks);
				}
			}
		
		} catch (Exception UgyldigListeIndeks) {
			// det finnes ikke flere objekter
		}
		
		
		// ###############################################################################
		// spørre hvilken pasient det gjelder
		
		// holder for å putte pasienten som skal som argument til resept-konstruktør
		Pasient pasient = null;
		
		// spørre hvilken lege som skal skrive ut
		System.out.print("Hvilken pasient er det?");
		String pasientNavn = inputScanner.nextLine();
		
		
		// finne pasient i listen, fange indeksfeil
		try {
			
			// sette indeks til nederste element
			int indeks = 0;
			
			// hvis det er en pasient på gitt indeks
			while (pasientListe.hent(indeks) != null) {

				// hvis dette er rett pasient
				if (pasientListe.hent(indeks).hentNavn().equals(pasientNavn)) {
					
					System.out.print("Fant pasient");
					pasient = pasientListe.hent(indeks);
					// gå videre, nå har vi rett pasient
					break;
				}	
				
				// hvis dette ikke er rett pasient
				else {
					
					// gå til neste pasientindeks for å sjekke denne
					indeks++;
					pasient = pasientListe.hent(indeks);
				}
			}
		
		} catch (Exception UgyldigListeIndeks) {
			// det finnes ikke flere objekter
		}		
		
		
		// spørre hvor mange reit
		System.out.print("Hvor mange reit?");
		int reit = Integer.parseInt(inputScanner.nextLine());
		
		
		// lage resept-objekt og legge det i resept-listen, avhengig av type
		if (reseptType.equals("blaa")) {
			pasient.leggTilResept(new BlaaResept(legemiddel, lege, pasient, reit));
			System.out.print("La til resept " + pasient.getReseptListe().hent(0));
			System.out.print("La til med legemiddel " + pasient.getReseptListe().hent(0).hentLegemiddel().hentNavn());
		}
		
		else if (reseptType.equals("p")) {	
			pasient.leggTilResept(new PResept(legemiddel, lege, pasient, reit));
			System.out.print("La til resept " + pasient.getReseptListe().hent(0));
		}
		
		else if (reseptType.equals("militaer")) {
			pasient.leggTilResept(new MilitaerResept(legemiddel, lege, pasient, reit));
			System.out.print("La til resept " + pasient.getReseptListe().hent(0));

		}
		
		// vente på brukerinput for å gå tilbake til hovedmeny
		System.out.print("Trykk Enter for å fortsette.");
		inputScanner.nextLine();
		skrivHovedmeny();	
	}	
	
	
	// skrive ut oversikt over alle listene
	private static void skrivUtOversikt() {
		
		// viske ut skjermen
		wipeScreen();

		System.out.println("Informasjon om listene:");
		System.out.println("\nLeger:");
		
	    // TODO: Collections.sort(legeListe);
		
		for ( Fastlege lege : legeListe ) {
			
			System.out.println(lege.hentNavn() + ", som har avtalenummer " + lege.hentAvtalenummer());
			
		}
		
		
		System.out.println("\nPasienter:");
		
		for ( Pasient pasient : pasientListe ) {	
			
			System.out.println(pasient.hentNavn() + ", som har reseptene:");
			
			for ( Resept resept : pasient.getReseptListe()) {	
			
				if (resept.hentLegemiddel().hentType().equals("a")) {
					System.out.println("    " + resept.hentLegemiddel().hentNavn() +
									   resept.hentLegemiddel().hentVirkestoffMengde() + " mg, " +
									   ", kr. " + resept.hentLegemiddel().hentPris());
									   
									   // TODO: "styrke " + resept.hentLegemiddel().hentNarkotiskStyrke() +
				}
				
				
				if (resept.hentLegemiddel().hentType().equals("b")) {
					System.out.println("    " + resept.hentLegemiddel().hentNavn() +
									   resept.hentLegemiddel().hentVirkestoffMengde() + " mg, " +
									   ", kr. " + resept.hentLegemiddel().hentPris());
									   
									   // TODO: "styrke " + resept.hentLegemiddel().hentNarkotiskStyrke() +
				}
			}
		}
		
		
		System.out.println("\nLegemidler:");
		for (Legemiddel legemiddel : legemiddelListe ) {	
			
			System.out.println(legemiddel.hentNavn());
		}
		
		// vente på brukerinput for å gå tilbake til hovedmeny
		System.out.print("Trykk Enter for å fortsette.");
		inputScanner.nextLine();
		skrivHovedmeny();
		
	}

	
	// metode for å bruke resept
	private static void brukResept() {
		
		Pasient pasient = null;
		
		// spørre hvilken pasient som skal bruke resept
		System.out.print("Hvilken pasient er det?");
		String pasientNavn = inputScanner.nextLine();
		

		
		// finne pasient i listen, fange indeksfeil
		try {
			
			// sette indeks til nederste element
			int indeks = 0;
			
			// hvis det er en pasient på gitt indeks
			while (pasientListe.hent(indeks) != null) {

				// hvis dette er rett pasient
				if (pasientListe.hent(indeks).hentNavn().equals(pasientNavn)) {
					
					System.out.print("Fant pasient");
					pasient = pasientListe.hent(indeks);
					// gå videre, nå har vi rett pasient
					break;
				}	
				
				// hvis dette ikke er rett pasient
				else {
					
					// gå til neste pasientindeks for å sjekke denne
					indeks++;
					pasient = pasientListe.hent(indeks);
				}
			}
		
		} catch (Exception UgyldigListeIndeks) {
			// det finnes ikke flere objekter
		}		
		
		
		
		// spørre hvilket legemiddel det gjelder
		System.out.print("Hvilket legemiddel er det?");
		String legemiddelNavn = inputScanner.nextLine();
		
		// finne legemiddelet i reseptlisten
		for (Resept resept : pasient.getReseptListe()) {	
		
			if (resept.hentLegemiddel().hentNavn().equals(legemiddelNavn)) {
				if (resept.bruk()) {
					System.out.println("Brukte en reit, " + resept.hentReit() + " reit igjen.");
				}
				
				else {
					System.out.println("Resepten er tom");
				}
			}
		}
		
		
		// vente på brukerinput for å gå tilbake til hovedmeny
		System.out.print("Trykk Enter for å fortsette.");
		inputScanner.nextLine();
		skrivHovedmeny();	
		
		
	}
	
	
	
	// metode for å skrive ut statistikk
	private static void skrivUtStatistikk() {
		skrivStatistikkmeny();
	}
	
	private static void skrivUtVanedannende(){
		
		System.out.println("Her er alle utskrevne resepter for vanedannende legemidler:");
		
		// teller for antall vanedannende legemidler
		int counter = 0;
		
		// sjekke alle pasienters resepter for vanedannende legemidler
		for (Pasient pasient : pasientListe) {
			for (Resept resept : pasient.getReseptListe()) {
				if (resept.hentLegemiddel().hentType().equals("b")) {
					counter++;
				}
			}
		}
		
		// skrive ut antall vanedannende legemidler
		System.out.println("Antall resepter utskrevet for vanedannende legemidler: " + counter);		
		
		// vente på brukerinput for å gå tilbake til hovedmeny
		System.out.print("Trykk Enter for å fortsette.");
		inputScanner.nextLine();
		skrivHovedmeny();
	}
	
	private static void skrivUtVanedannendeMilitaere(){
		
		System.out.println("Her er alle utskrevne resepter til militære for vanedannende legemidler:");
		
		// teller for antall vanedannende legemidler for militære
		int counter = 0;
		
		// sjekke alle pasienters resepter for vanedannende legemidler for militære
		for (Pasient pasient : pasientListe) {
			for (Resept resept : pasient.getReseptListe()) {
				if (resept.hentLegemiddel().hentType().equals("b")
					&& resept.hentType().equals("militaer")) {
					counter++;
				}
			}
		}
		
		// skrive ut antall vanedannende legemidler
		System.out.println("Antall vanedannende resepter utskrevet til militære: " + counter);	
		
		// vente på brukerinput for å gå tilbake til hovedmeny
		System.out.print("Trykk Enter for å fortsette.");
		inputScanner.nextLine();
		skrivHovedmeny();
	}
					
	
	private static void skrivUtMisbrukStatistikk(){
		
		System.out.println("Her er alle utskrevne resepter til militære for vanedannende legemidler:");
		
		// TODO:
		// Collections.sort(leger);
		
		// vente på brukerinput for å gå tilbake til hovedmeny
		System.out.print("Trykk Enter for å fortsette.");
		inputScanner.nextLine();
		skrivHovedmeny();
	}
	
	
	
	
	
	
	
	
	
	
	
	// viske ut alt som vises på skjerm
	private static void wipeScreen() {
		
		// skrive 100 tomme linjer
		for (int i=0; i<100; i++) {
			System.out.println();
		}
	}
}



