package IDATT;

// Spør bruker om år
//int aar = 2024;
//  int maaned = 11;
//  int dag = 6;
//
//
//  int dato = aar*100_000_000 + maaned * 1_000_000 + dag * 10_000;
//  mellomDatoTidspunkt(dato, dato + 2359);

import IDATT.ArrangementRegister.Sorteringskriteria;
import java.util.List;
import java.util.Scanner;

public class ArrangementMain {
  public static void main(String[] args) {
    Scanner myScan = new Scanner(System.in);
    ArrangementRegister arrReg = new ArrangementRegister();

    System.out.println("Skriv inn arrangements navn: ");
    String navn = myScan.nextLine();
    System.out.println("Skriv inn sted dette holdes: ");
    String sted = myScan.nextLine();
    System.out.println("Skriv inn ditt nummer: ");
    int nummer = myScan.nextInt();
    myScan.nextLine();//filler
    System.out.println("Skriv inn type arrangement (sirkus,tivoli etc.): ");
    String type = myScan.nextLine();
    System.out.println("Skriv inn hvem arrangør er: ");
    String arrangor = myScan.nextLine();
    System.out.println("Skriv inn tidspunkt (yyyyMMddKKKK)");
    long datoTid = myScan.nextLong();
    Arrangement arr = new Arrangement(nummer, datoTid, navn, sted, arrangor, type);
    arrReg.registereNyttArrangement(arr);

    boolean Running = true;
    while(Running){
      System.out.println("\n1.Finne alle arrangementer i gitt sted"
          + "\n2.Finne arrangment på en dato (eller mellom to datoer)"
          + "\n3.Sorter arrangementer"
          + "\n4.Legg til nytt arrangement"
          + "\n5.Avslutt");
      int valg = myScan.nextInt();
      myScan.nextLine();//filler
      switch (valg){
        case 1 -> {
          System.out.println("Skriv inn sted: ");
          String stedet = myScan.nextLine();
          System.out.println(arrReg.finneAlleArrGittSted(stedet));
        }
        case 2 -> {
          System.out.println("Skriv inn første dato: ");
          long forDato = myScan.nextLong();
          System.out.println("Skriv inn siste dato (0 om ingen dato): ");
          long etterDato = myScan.nextLong();
          System.out.println(arrReg.DatoTidspunkt(forDato));
          System.out.println(arrReg.DatoTidspunkt(forDato,etterDato));
        }
        case 3 -> {
          System.out.println("\n1.Sorter etter sted alfabetisk\n2.Sorter etter dato\n3.Sorter etter tid");
          int choice = myScan.nextInt();
          switch (choice){
            case 1:
              List<Arrangement> ListSortSted = arrReg.SortertArr(Sorteringskriteria.STED);
              System.out.println(ListSortSted);
              break;
            case 2:
              List<Arrangement> ListSortDato = arrReg.SortertArr(Sorteringskriteria.DATO);
              System.out.println(ListSortDato);
              break;
            case 3:
              List<Arrangement> ListSortTid = arrReg.SortertArr(Sorteringskriteria.TID);
              System.out.println(ListSortTid);
              break;
          }
        }
        case 4 -> {
          System.out.println("Skriv inn arrangements navn: ");
          String NyNavn = myScan.nextLine();
          System.out.println("Skriv inn sted dette holdes: ");
          String NySted = myScan.nextLine();
          System.out.println("Skriv inn ditt nummer: ");
          int NyNummer = myScan.nextInt();
          myScan.nextLine();//filler
          System.out.println("Skriv inn type arrangement (sirkus,tivoli etc.): ");
          String NyType = myScan.nextLine();
          System.out.println("Skriv inn hvem arrangør er: ");
          String NyArrangor = myScan.nextLine();
          System.out.println("Skriv inn tidspunkt (yyyyMMddKKKK)");
          long NyDatoTid = myScan.nextLong();
          Arrangement NyArr = new Arrangement(NyNummer, NyDatoTid, NyNavn, NySted, NyArrangor, NyType);
          arrReg.registereNyttArrangement(NyArr);
        }
        case 5 -> Running = false;
      }
    }


  }
}