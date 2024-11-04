import java.util.Arrays;

public class Fagkatalog {
    private Fag[] fagene = new Fag[3];  // lite for testformål, kan her vurdere å sette lik 0 og utvide ved behov
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
            utvidTabell();  // hjelpemetode nedenfor
        }
        fagene[antFag] = new Fag(fagkode, fagnavn);
        antFag++;
        return true;
    }
    /* Hjelpemetode for å "utvide" tabellen */
    private void utvidTabell() {
        Fag[] nyTab = new Fag[fagene.length + 2];  // ny og større tabell
        for (int i = 0; i < fagene.length; i++) {  // kopierer data over til ny tabell
            nyTab[i] = fagene[i];  // aggregering
        }
        fagene = nyTab;

        // alternativ - kopier vha Arrays.copyOf og utvider med 1 - ved behov
        Fag[] nyT = Arrays.copyOf(fagene, fagene.length + 1);
        fagene = nyT;
    }
    /**
     * Returnerer antall fag registrert.
     */
    public int getAntFag() {
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
     * Finn totalt antall studenter i alle fagene tilsammen
     */
    public int getTotAntStud(){
        int totAntStud = 0;
        for(Fag f : fagene) totAntStud += f.getAntStud();
        return totAntStud;
    }

    /**
     *
     * hvilket fag, eller hvilke, dersom det er flere, som har flest studenter.
     */
    public Fag[] maksStud(){
        int maks = getMaksAntall();
        Fag[] tmp = new Fag[fagene.length];
        int antFunnet = 0;
        for(Fag f: fagene){
            if (f.getAntStud() == maks){
                tmp[antFunnet] = f;
                antFunnet++;
            }
        }
        if (antFunnet<fagene.length){
            Fag[] resultatTab = new Fag[antFunnet];
            for(int i=0; i<antFunnet; i++){
                resultatTab[i] = tmp[i];
            }
            return resultatTab;
        } else return tmp;
    }

    private int getMaksAntall(){
        int maks = 0;
        for(Fag f: fagene){
            if (maks < f.getAntStud()) {
                maks = f.getAntStud();
            }
        }
        return maks;
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



    /**
     *
     * Testprogram for klassen. Ett testsett per metode.
     * Tester med tom katalog og katalog med fire fag, slik at utvidTabell() blir prøvd.
     */
    public static void main(String[] args) {
        System.out.println("Totalt antall tester: 6");
        Fagkatalog kat0 = new Fagkatalog(); // tom katalog
        Fagkatalog kat = new Fagkatalog(); // blir fylt med fire fag
        boolean ok1 = kat.registrerNyttFag("INGT1001", "Ingeniørfaglig innføringsemne");
        boolean ok2 = kat.registrerNyttFag("IDATT1001", "Programmering 1");
        boolean ok3 = kat.registrerNyttFag("IMAT1001", "Matematiske metoder 1");
        boolean ok4 = kat.registrerNyttFag("IDATT1001", "Programmering 1");
        boolean ok5 = kat.registrerNyttFag("TDAT3001", "Bachelor oppgave dataingeniør");
        if (ok1 && ok2 && ok3 && !ok4 && ok5) {
            System.out.println("Fagkatalog: Test 1 vellykket");
        }

        if (kat.getAntFag() == 4 && kat0.getAntFag() == 0) {
            System.out.println("Fagkatalog: Test 2 vellykket");
        }

        Fag f1 = kat.finnFagGittIndeks(2);
        Fag f2 = kat.finnFagGittIndeks(4);
        Fag ff1 =  kat0.finnFagGittIndeks(0);
        if (f1.getFagkode().equals("IMAT1001") && f2 == null && ff1 == null) {
            System.out.println("Fagkatalog: Test 3 vellykket");
        }

        Fag f3 = kat.finnFagGittKode("IDATT1001");
        Fag f4 = kat.finnFagGittKode("IMAT1001");
        Fag f5 = kat.finnFagGittKode("IMAT1002");
        Fag ff2 = kat0.finnFagGittKode("LC191D");
        if (f3.getFagnavn().equals("Programmering 1")
                && f4.getFagnavn().equals("Matematiske metoder 1") && f5 == null && ff2 == null) {
            System.out.println("Fagkatalog: Test 4 vellykket");
        }

        boolean ok6 = kat.oppdaterAntStud("INGT1001", 30);
        boolean ok7 = kat.oppdaterAntStud("TEINGT1001", 30);
        boolean okk1 = kat0.oppdaterAntStud("INGT1001", 30);
        Fag f6 = kat.finnFagGittKode("INGT1001");
        if (ok6 && !ok7 &&  f6.getAntStud() == 30 && !okk1) {
            System.out.println("Fagkatalog: Test 5 vellykket");
        }

        boolean ok8 = kat.slettFag("TDAT3001");  // nå er det tre fag igjen
        boolean okk2 = kat0.slettFag("IDATT1001");
        kat0.registrerNyttFag("IDATT1001", "Programmering 1");
        boolean okk3 = kat0.slettFag("IDATT1001");  // sletter ett fag
        if (ok8 && kat.getAntFag() == 3 && !okk2 && okk3 && kat0.getAntFag() == 0) {
            System.out.println("Fagkatalog: Test 6 vellykket");
        }
    }
}
