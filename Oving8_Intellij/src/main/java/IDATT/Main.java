package IDATT;

import java.util.Scanner;

public class Main {

  //Lar variabler og metoder være private, slik at andre klasser annen enn main ikke kan manipulere de:
  private static final Scanner moiScanner = new Scanner(
      System.in); //lager scanner utenfor main med static. Vi ønsker scanner felles for alle metoder av klassen, derfor static.

  public static void main(String[] args) {
    Boolean Running = true;
    while (Running) {

      System.out.println("Skriv inn navn: ");
      String navn = moiScanner.nextLine();
      System.out.println("Skriv etternavn: ");
      String etternavn = moiScanner.nextLine();
      System.out.println("Skriv fødselsår: ");
      int fodselsaar = moiScanner.nextInt();
      //objekt av Personklasse:
      Person personalia = new Person(navn, etternavn, fodselsaar);

      System.out.println("Skriv arbeidsnummer: ");
      int arbeidsnummer = moiScanner.nextInt();
      System.out.println("Skriv ansetelsesår: ");
      int ansetelsesaar = moiScanner.nextInt();
      System.out.println("Skriv månedslønn: ");
      int maanedslonn = moiScanner.nextInt();
      System.out.println("Skriv inn skatteprosent: ");
      int skatteprosent = moiScanner.nextInt();
      //objekt av ArbTakerklasse:
      ArbTaker Arbeider = new ArbTaker(personalia, arbeidsnummer,
          ansetelsesaar, maanedslonn, skatteprosent);

      boolean menyBar = true;
      while (menyBar) {
        System.out.println(
            "\n----Meny----:\n1. Skattetrekk\n2. Bruttolønn pr. år\n3. Skattetrekk pr år"
                + "\n4. Navn og alder\n5. Ansettelseslengde\n6. Sjekk over aktuelt år"
                + "\n7. Endre info\n8. Avslutt");
        int valg = moiScanner.nextInt();
        switch (valg) {
          case 8 ->
              menyBar = false; //må ha denne øverst da om nederst forårsakes den blir utløst, tross valg ikke er 8..
          case 1 -> System.out.println("Skattetrekk: " + Arbeider.ArbtkrSkattetrekk());
          case 2 -> System.out.println("Bruttolønn pr år: " + Arbeider.bruttolonn());
          case 3 -> System.out.println("Skattetrekk per år: " + Arbeider.skattetrekk());
          case 4 -> {
            System.out.println("Navn: " + Arbeider.PersonaliaNavn());
            System.out.println("Alder: " + Arbeider.PeronaliaAlder());
          }
          case 5 -> System.out.println("Antall år i bedrift: " + Arbeider.antallAar());
          case 6 -> {
            System.out.println("\nJobbet over visst år: ");
            int AktuellAar = moiScanner.nextInt();
            System.out.println(Arbeider.OverVistAar(AktuellAar));
          }
          case 7 -> Option7(Arbeider);
          default -> System.out.println("Prøv igjen: ");
        }
      }
      //sjekker om ny bruker
      boolean sjekk = nyBruker();
      if(!sjekk) Running=false;

    }
  }

  //Sjuende option metode
  private static void Option7(ArbTaker arbeider) {
    System.out.println(
        "\nHvilken vil du endre?\n1. Personalia\n2. Ansettelsesår\n3. Månedslønn\n4. Skatteprosent");

    int valgEndre = moiScanner.nextInt();
    switch (valgEndre) {
      case 1 -> {
        //endre personalia litt mer omfattende
        System.out.println("Skriv inn navn: ");
        moiScanner.nextLine(); //filler
        String Nyttnavn = moiScanner.nextLine();
        System.out.println("Skriv etternavn: ");
        String Nyttetternavn = moiScanner.nextLine();
        System.out.println("Skriv fødselsår: ");
        int Nyttfodselsaar = moiScanner.nextInt();

        Person Nyttpersonalia = new Person(Nyttnavn, Nyttetternavn, Nyttfodselsaar);

        arbeider.setPersonalia(Nyttpersonalia);
      }
      case 2 -> {
        System.out.println("Skriv nytt ansettelsesår: ");
        int nyttAnsettelsesaar = moiScanner.nextInt();
        arbeider.setAnsettelseaar(nyttAnsettelsesaar);
      }
      case 3 -> {
        System.out.println("Skriv ny månedslønn: ");
        int nyArbeidslonn = moiScanner.nextInt();
        arbeider.setMaanedslonn(nyArbeidslonn);
      }
      case 4 -> {
        System.out.println("Skriv ny skatteprosent: ");
        int nySkatteprosent = moiScanner.nextInt();
        arbeider.setSkatteprosent(nySkatteprosent);
      }
      default -> System.out.println("Prøv igjen: ");
    }
  }

  //Resetskjerm
  private static boolean nyBruker() {
    System.out.println("Vil du lage ny bruker? (j/n)");
    moiScanner.nextLine(); //filler
    String answer = moiScanner.nextLine();
    return answer.equalsIgnoreCase("j"); //sjekker om lik "j". Om det er tilfelle return true.
  }

}