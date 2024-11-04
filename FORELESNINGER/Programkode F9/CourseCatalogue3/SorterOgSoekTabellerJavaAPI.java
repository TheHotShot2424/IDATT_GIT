/**
 * SorterOgSoekTabellerJavaAPI.java  - "Programmering i Java", 4.utgave - 2009-07-01
 *
 * Klassen viser hvordan metoder i klassen java.util.Arrays kan brukes til � sortere
 * tabeller av objekter. Eksempel p� bin�rs�k er ogs� tatt med.
 */

class SorterOgSoekTabellerJavaAPI {
  public static void main(String[] args) {

    /* Legger seks flater i en tabell */
    Flate[] flater = {new Flate("D", 3, 4), new Flate("B", 2, 3.5), new Flate("G", 5, 2),
                      new Flate("A", 2, 4), new Flate("C", 4, 3), new Flate("F", 4, 2.4)};

    /* Skriver ut arealene i den opprinnelige rekkef�lgen */
    System.out.println("Opprinnelig rekkef�lge:");
    for (int i = 0; i < flater.length; i++) {
      System.out.println(flater[i].getNavn() + " har areal " + flater[i].beregnAreal());
    }

    /* Sorterer i hht standard sortering (Comparable) */
    java.util.Arrays.sort(flater);
    System.out.println("Sortert rekkef�lge (navn):");
    for (int i = 0; i < flater.length; i++) {
      System.out.println(flater[i].getNavn() + " har areal " + flater[i].beregnAreal());
    }

    /* I denne sorterte tabellen kan vi s�ke etter en flate med et bestemt navn */
    Flate s�keFlate1 = new Flate("C", 2, 3);
    int res1 = java.util.Arrays.binarySearch(flater, s�keFlate1); // finnes
    System.out.println("Flate med navn C er funnet p� indeks " + res1);

    Flate s�keFlate2 = new Flate("EE", 2, 3);
    int res2 = java.util.Arrays.binarySearch(flater, s�keFlate2); // finnes ikke
    System.out.println("Flate med navn EE er ikke funnet."
                     + " Kan eventuelt legges inn p� indeks " + (-res2 - 1));

    /* Sorterer i henhold til areal, det vil si at vi m� bruke et FlateKompAreal-objekt */
    java.util.Arrays.sort(flater, new FlateKompAreal());
    System.out.println("Sortert rekkef�lge (areal):");
    for (int i = 0; i < flater.length; i++) {
      System.out.println(flater[i].getNavn() + " har areal " + flater[i].beregnAreal());
    }
  }
}

/* Kj�ring av programmet:
Opprinnelig rekkef�lge:
D har areal 12.0
B har areal 7.0
G har areal 10.0
A har areal 8.0
C har areal 12.0
F har areal 9.6
Sortert rekkef�lge (navn):
A har areal 8.0
B har areal 7.0
C har areal 12.0
D har areal 12.0
F har areal 9.6
G har areal 10.0
Flate med navn C er funnet ps indeks 2
Flate med navn EE er ikke funnet. Kan eventuelt legges inn p� indeks 4
Sortert rekkef�lge (areal):
B har areal 7.0
A har areal 8.0
F har areal 9.6
G har areal 10.0
C har areal 12.0
D har areal 12.0
*/
