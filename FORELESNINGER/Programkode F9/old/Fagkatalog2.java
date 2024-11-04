/**
 * Fagkatalog.java  - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Klasse for å vedlikeholde en fagkatalog.
 */

class Fagkatalog2 {
  private Fag[] fagene = new Fag[3];  // lite for testformål
  private int antFag = 0;

  /**
   * Registrerer nytt fag.
   * Returnerer false hvis fag med denne koden eksisterer fra før.
   */
  public boolean registrerNyttFag(String fagkode, String fagnavn) {
    if (finnFagGittKode(fagkode) != null) {
      return false;   // RETUR. Fag er allerede registrert.
    }
    if (antFag == fagene.length) {
      utvidTabell();  // hjelpemetode nederst i klassen
    }
    fagene[antFag] = new Fag(fagkode, fagnavn);
    antFag++;
    return true;
  }

  /**
   * Returnerer antall fag registrert.
   */
  public int finnAntFag() {
    return antFag;
  }

  /**
   * Returnerer fag med bestemt indeks.
   * Returnerer null hvis ugyldig indeks.
   */
  public Fag finnFagGittIndeks(int indeks) {
    return (indeks >= 0 && indeks < antFag) ? fagene[indeks] : null;
  }

  /**
   * Returnerer fag med gitt fagkode.
   * Returnerer null hvis fag ikke finnes.
   */
  public Fag finnFagGittKode(String fagkode) {
    if (fagkode != null) {
      for (int i = 0; i < antFag; i++) {
        if (fagene[i].getFagkode().equals(fagkode.trim())) {
          return fagene[i];
        }
      }
    }
    return null;
  }

  /**
   * Oppdaterer antall studenter på bestemt fag.
   * Returnerer false hvis fag ikke finnes.
   */
  public boolean oppdaterAntStud(String fagkode, int antStud) {
    Fag f = finnFagGittKode(fagkode);
    if (f != null) {
      f.setAntStud(antStud);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Sletter et fag fra katalogen.
   * Returnerer false hvis fag ikke finnes.
   */
  public boolean slettFag(String fagkode) {
    if (fagkode != null) {
      for (int i = 0; i < antFag; i++) {
        if (fagene[i].getFagkode().equals(fagkode.trim())) { // faget er funnet

          /* Sletter ved å sette fagene[i] lik siste element i tabellen og reduserer antFag */
          fagene[i] = fagene[antFag - 1];
          antFag--;
          return true;
        }
      }
    }
    return false; // fag ikke funnet, sletter ingenting
  }

  /**
   * toString()
   * Bygger opp en resultatstreng ved å sende toString()-meldingen til hvert
   * enkelt fagobjekt. Legger inn linjeskift mellom hvert fag.
   */
  public String toString() {
    String resultat = "";
    for (int i = 0; i < antFag; i++) {
      resultat += fagene[i].toString() + "\n";
    }
    return resultat;
  }

  /* Hjelpemetode for å "utvide" tabellen */
  private void utvidTabell() {
    Fag[] nyTab = new Fag[fagene.length + 2];  // ny og større tabell
    for (int i = 0; i < fagene.length; i++) {  // kopierer data over til ny tabell
      nyTab[i] = fagene[i];
    }
    fagene = nyTab;
  }

/* SVAR PÅ OPPGAVE */

/* Oppgave 1a */
public int finnTotAntStudenter() {
  int sum = 0;
  for (int i = 0; i < antFag; i++) {
    sum += fagene[i].getAntStud();
  }
  return sum;
}

/* Oppgave 1b */
private int finnMaksAntStud() {
   if (antFag > 0) {
       int maks = fagene[0].getAntStud();
       for (int i = 1; i < antFag; i++) {
           if (fagene[i].getAntStud() > maks) {
                maks = fagene[i].getAntStud();
           }
       }
       return maks;
    }
    return 0; // ingen fag registrert
}

public Fag[] finnStørsteFag() {
   int maks = finnMaksAntStud();			// hjelpemetode, se nedenfor
   Fag[] fagMedMaks = new Fag[antFag];
   int antFagLikMaks = 0;

   for (int i = 0; i < antFag; i++) {
      if (fagene[i].getAntStud() == maks) {
    fagMedMaks[antFagLikMaks] = fagene[i];
    antFagLikMaks++;
      }
   }
   Fag[] nyTab = new Fag[antFagLikMaks];
   for (int i = 0; i < antFagLikMaks; i++) {
         nyTab[i] = fagMedMaks[i];
    }
    return nyTab;
}




/* SLUTT SVAR OPPGAVE */




  /**
   *
   * Testprogram for klassen. Ett testsett per metode.
   * Tester med tom katalog og katalog med fire fag, slik at utvidTabell() blir prøvd.
   */

   public static void main(String[] args) {
   System.out.println("Totalt antall tester: 4");

   /* Tom katalog */
   Fagkatalog2 kat0 = new Fagkatalog2();
   Fag[] fag0 = kat0.finnStørsteFag();
   if (fag0.length == 0) {
         System.out.println("Test 1 vellykket");
   }
   if (kat0.finnTotAntStudenter() == 0) {
         System.out.println("Test 2 vellykket");
   }
   /* Katalog med 5 fag */
   Fagkatalog kat = new Fagkatalog();
   kat.registrerNyttFag("LC191D", "Videregående prog");
   kat.registrerNyttFag("LV172D", "Programmering i Java");
   kat.registrerNyttFag("LO347D", "Web-applikasjoner");
   kat.registrerNyttFag("LO346D", "Java EE");
   kat.registrerNyttFag("LC331D", "IT, miljø og samfunn");

	kat.oppdaterAntStud("LC191D", 20);
	kat.oppdaterAntStud("LV172D", 30);
	kat.oppdaterAntStud("LO347D", 20);
	kat.oppdaterAntStud("LO346D", 30);
	kat.oppdaterAntStud("LC331D", 30);

	Fag[] fag = kat.finnStørsteFag();

	if (fag.length == 3 && fag[0].getFagkode().equals("LV172D")
		&& fag[1].getFagkode().equals("LO346D")
		&& fag[2].getFagkode().equals("LC331D"))
	{
        System.out.println("Test 3 vellykket");
	}
	if (kat.finnTotAntStudenter() == 130) {
        System.out.println("Test 4 vellykket");
	}
} // main
}