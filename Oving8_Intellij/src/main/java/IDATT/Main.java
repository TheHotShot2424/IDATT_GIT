package IDATT;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner moiScanner = new Scanner(System.in);

    Boolean Running = true;
    while(Running){

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
      ArbTaker Arbeider = new ArbTaker(personalia, arbeidsnummer, ansetelsesaar, maanedslonn, skatteprosent);



      boolean menyBar = true;
      while(menyBar){
        System.out.println("\n----Meny----:\n1. Skattetrekk\n2. Bruttolønn pr. år\n3. Skattetrekk pr år\n4. Navn og alder\n5. Ansettelseslengde\n6. Sjekk over aktuelt år\n7. Endre info\n8. Avslutt");
        int valg = moiScanner.nextInt();
        switch (valg) {
          case 8: //må ha denne øverst da om nederst forårsakes den blir utløst, tross valg ikke er 8..
            menyBar = false;
            break;
          case 1:
            System.out.println("Skattetrekk: "+Arbeider.ArbtkrSkattetrekk());
            break;
          case 2:
            System.out.println("Bruttolønn pr år: "+Arbeider.bruttolonn());
            break;
          case 3:
            System.out.println("Skattetrekk per år: "+Arbeider.skattetrekk());
            break;
          case 4:
            System.out.println("Navn: "+Arbeider.PersonaliaNavn());
            System.out.println("Alder: "+Arbeider.PeronaliaAlder());
            break;
          case 5:
            System.out.println("Antall år i bedrift: "+Arbeider.antallAar());
            break;
          case 6:
            System.out.println("\nJobbet over visst år: ");
            int AktuellAar = moiScanner.nextInt();
            System.out.println(Arbeider.OverVistAar(AktuellAar));
            break;

          // Endre verdier
          case 7:
            System.out.println("\nHvilken vil du endre?\n1. Personalia\n2. Ansettelsesår\n3. Månedslønn\n4. Skatteprosent");
            int valgEndre = moiScanner.nextInt();
            switch (valgEndre) {
              case 1:
                //endre personalia litt mer omfattende
                System.out.println("Skriv inn navn: ");
                moiScanner.nextLine(); //filler
                String Nyttnavn = moiScanner.nextLine();
                System.out.println("Skriv etternavn: ");
                String Nyttetternavn = moiScanner.nextLine();
                System.out.println("Skriv fødselsår: ");
                int Nyttfodselsaar = moiScanner.nextInt();

                Person Nyttpersonalia = new Person(Nyttnavn, Nyttetternavn, Nyttfodselsaar);

                Arbeider.setPersonalia(Nyttpersonalia);
                break;
              case 2:
                System.out.println("Skriv nytt ansettelsesår: ");
                int nyttAnsettelsesaar = moiScanner.nextInt();
                Arbeider.setAnsettelseaar(nyttAnsettelsesaar);
                break;
              case 3:
                System.out.println("Skriv ny månedslønn: ");
                int nyArbeidslonn = moiScanner.nextInt();
                Arbeider.setMaanedslonn(nyArbeidslonn);
                break;
              case 4:
                System.out.println("Skriv ny skatteprosent: ");
                int nySkatteprosent = moiScanner.nextInt();
                Arbeider.setSkatteprosent(nySkatteprosent);
                break;
              default:
                break;
            }


          default:
            break;
        }
      }



      //Resetskjerm
      boolean check = true;
      while(check){
        System.out.println("Vil du lage ny bruker? (j/n)");
        moiScanner.nextLine(); //filler
        String fortsette = moiScanner.nextLine();

        if(fortsette.toLowerCase().equals("j")){
          check = false;
        }
        else if(fortsette.toLowerCase().equals("n")){
          Running = false;
          check = false;
        }
      }
    }
    moiScanner.close();
  }
}