/**
 * Fagkatalog.java  - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Klasse for � vedlikeholde en fagkatalog.
 */

class Fagkatalog {
  private Fag[] fagene = new Fag[3];  // lite for testform�l
  private int antFag = 0;

  /**
   * Registrerer nytt fag.
   * Returnerer false hvis fag med denne koden eksisterer fra f�r.
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
   * Oppdaterer antall studenter p� bestemt fag.
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

          /* Sletter ved � sette fagene[i] lik siste element i tabellen og reduserer antFag */
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
   * Bygger opp en resultatstreng ved � sende toString()-meldingen til hvert
   * enkelt fagobjekt. Legger inn linjeskift mellom hvert fag.
   */
  public String toString() {
    String resultat = "";
    for (int i = 0; i < antFag; i++) {
      resultat += fagene[i].toString() + "\n";
    }
    return resultat;
  }

  /* Hjelpemetode for � "utvide" tabellen */
  private void utvidTabell() {
    Fag[] nyTab = new Fag[fagene.length + 2];  // ny og st�rre tabell
    for (int i = 0; i < fagene.length; i++) {  // kopierer data over til ny tabell
      nyTab[i] = fagene[i];
    }
    fagene = nyTab;
  }

  /**
   *
   * Testprogram for klassen. Ett testsett per metode.
   * Tester med tom katalog og katalog med fire fag, slik at utvidTabell() blir pr�vd.
   */
   public static void main(String[] args) {
     System.out.println("Totalt antall tester: 6");
     Fagkatalog kat0 = new Fagkatalog(); // tom katalog
     Fagkatalog kat = new Fagkatalog(); // blir fylt med fire fag
     boolean ok1 = kat.registrerNyttFag("LC191D", "Videreg�ende programmering");
     boolean ok2 = kat.registrerNyttFag("LV172D", "Programmering i Java");
     boolean ok3 = kat.registrerNyttFag("LO347D", "Web-applikasjoner");
     boolean ok4 = kat.registrerNyttFag("LV172D", "Programmering i Java");
     boolean ok5 = kat.registrerNyttFag("LC331D", "IT, milj� og samfunn");
     if (ok1 && ok2 && ok3 && !ok4 && ok5) {
       System.out.println("Fagkatalog: Test 1 vellykket");
     }

     if (kat.finnAntFag() == 4 && kat0.finnAntFag() == 0) {
       System.out.println("Fagkatalog: Test 2 vellykket");
     }

     Fag f1 = kat.finnFagGittIndeks(2);
     Fag f2 = kat.finnFagGittIndeks(4);
     Fag ff1 =  kat0.finnFagGittIndeks(0);
     if (f1.getFagkode().equals("LO347D") && f2 == null && ff1 == null) {
       System.out.println("Fagkatalog: Test 3 vellykket");
     }

     Fag f3 = kat.finnFagGittKode("LC191D");
     Fag f4 = kat.finnFagGittKode("LC331D");
     Fag f5 = kat.finnFagGittKode("LO331D");
     Fag ff2 = kat0.finnFagGittKode("LC191D");
     if (f3.getFagnavn().equals("Videreg�ende programmering")
        && f4.getFagnavn().equals("IT, milj� og samfunn") && f5 == null && ff2 == null) {
       System.out.println("Fagkatalog: Test 4 vellykket");
     }

    boolean ok6 = kat.oppdaterAntStud("LC191D", 30);
    boolean ok7 = kat.oppdaterAntStud("LV191D", 30);
    boolean okk1 = kat0.oppdaterAntStud("LV191D", 30);
    Fag f6 = kat.finnFagGittKode("LC191D");
    if (ok6 && !ok7 &&  f6.getAntStud() == 30 && !okk1) {
      System.out.println("Fagkatalog: Test 5 vellykket");
    }

    boolean ok8 = kat.slettFag("LC331D");  // n� er det tre fag igjen
    boolean okk2 = kat0.slettFag("LC191D");
    kat0.registrerNyttFag("LC191D", "Videreg�ende programmering");
    boolean okk3 = kat0.slettFag("LC191D");  // sletter ett fag
    if (ok8 && kat.finnAntFag() == 3 && !okk2 && okk3 && kat0.finnAntFag() == 0) {
      System.out.println("Fagkatalog: Test 6 vellykket");
    }
  }
}