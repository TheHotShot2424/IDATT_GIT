package IDATT;

import java.util.Scanner;

public class klientProgram {
  public static void main(String[] args){
    Oppgaveoversikt obj1 = new Oppgaveoversikt();
    Scanner mScan = new Scanner(System.in);

    boolean Running = true;
    while(Running){
      System.out.println("1.Antall studenter\n2.Elevs oppgaveantall\n3.Ny student\n4.Øk elevs oppgaveantall\n5.Avslutt");
      int option = mScan.nextInt();
      mScan.nextLine();//filler
      switch (option){
        case 1 -> System.out.println("*********\n"+obj1.getAntStud()+"\n********");
        case 2 -> {
          if(obj1.getAntStud() == 0){
            System.out.println("*************\nIngen elever\n*************");
            break;
          }
          System.out.println("Skriv elevs navn: ");
          String elevNavn = mScan.nextLine();
          int antall = obj1.StudentOppgaver(elevNavn);
          System.out.println("Antall oppgaver for elev: " + antall);
        }
        case 3 -> {
          System.out.println("Navn på ny student: ");
          String nyElev = mScan.nextLine();
          obj1.nyStudent(nyElev);
        }
        case 4 -> {
          System.out.println("Skriv elevs navn: ");
          String elevNavn = mScan.nextLine();
          System.out.println("Skriv hvor mye du vil øke antall oppgaver levert: ");
          int oppg = mScan.nextInt();
          obj1.økStudentOppgave(elevNavn,oppg);
        }
        case 5 -> Running = false;
        default -> System.out.println("Skriv inn fra 1 til 4");
      }

    }


  }
}
