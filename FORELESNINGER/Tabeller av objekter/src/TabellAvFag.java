import java.util.Arrays;

public class TabellAvFag {
    public static void main(String[] args) {
        Fag[] baIngenior2019 = {new Fag("IDATT1001", "Programmering 1"),
                new Fag("INGT1001", "Ingeniørfaglig innføringsemne"),
                new Fag("IMAT1001", "Matematiske metoder 1")};

        Arrays.sort(baIngenior2019);

        System.out.println("Utskrift 1:");
        for (int i = 0; i < baIngenior2019.length; i++) {
            System.out.println(baIngenior2019[i]); // toString() blir brukt
        }

        /* Setter antall studenter til hhv. 10, 15 og 20 og skriver ut */
        baIngenior2019[0].setAntStud(95);
        baIngenior2019[1].setAntStud(90);
        baIngenior2019[2].setAntStud(92);
        System.out.println("\nUtskrift 2, skal gi antall studenter lik hhv 95, 90 og 92:");

        for (Fag f : baIngenior2019){
            System.out.println(f); // toString() blir brukt
        }
    }
}

/*
Utskrift 1:
Fag{fagkode='IDATT1001', fagnavn='Programmering 1', antstud=0}
Fag{fagkode='INGT1001', fagnavn='Ingeniørfaglig innføringsemne', antstud=0}
Fag{fagkode='IMAT1001', fagnavn='Matematiske metoder 1', antstud=0}

Utskrift 2, skal gi antall studenter lik hhv 95, 90 og 92:
Fag{fagkode='IDATT1001', fagnavn='Programmering 1', antstud=95}
Fag{fagkode='INGT1001', fagnavn='Ingeniørfaglig innføringsemne', antstud=90}
Fag{fagkode='IMAT1001', fagnavn='Matematiske metoder 1', antstud=92}

*/
