package IDATT;

import java.util.Scanner;

public class TekstAnalyseMain {
  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);

    while(true){
      System.out.println("\nSkriv inn en tekst: ");
      String tekst = scanner.nextLine();

      TekstAnalyse obj1 = new TekstAnalyse(tekst);

      System.out.println("Antall ulike bokstaver brukt: "+obj1.ulikeBokstaver());
      System.out.println("Totalt antall bokstaver: "+obj1.getTotalBokstaver());
      System.out.println("Prosent av ikke-bokstaver brukt: "+obj1.annetTegnProsent()+"%");
      System.out.println("Oftest bokstav: "+obj1.oftestBokstav());

      System.out.println("Skriv inn bokstaven du ønsker vite hvor mange ganger forekom: ");
      char tegn = scanner.nextLine().charAt(0); //fins ingen nextChar(), så vi gjør nextLine() og umiddelbart tar første bokstav i "stringen", som er det samme som char.
      System.out.println("Forekommelser av "+tegn+": "+obj1.Bokstavforekomst(tegn));

    }
  }

}
