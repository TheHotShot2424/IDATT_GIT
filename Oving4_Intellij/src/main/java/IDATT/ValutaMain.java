package IDATT;

import java.util.Scanner;

public class ValutaMain {
  public static void main(String[] args){
    Scanner scan =  new Scanner(System.in);

    Valuta Dollar = new Valuta(10.18);
    Valuta Euro = new Valuta(11.12);
    Valuta Sek = new Valuta(1.04);

    System.out.println("Velg valuta: \n1.Dollar\n2.Euro\n3.Sek");
    int hvilkenValuta = scan.nextInt();
    System.out.println("Skriv inn beløp: ");
    double belop = scan.nextDouble();
    System.out.println("1.Konvertere til NOK\n2.Konvertere fra NOK");
    int tilFraNok = scan.nextInt();

    switch(hvilkenValuta){
      case 1:
        if(tilFraNok == 1) {
          System.out.println(Dollar.konvertereTilNok(belop));}
        else{
          System.out.println(Dollar.konvertereFraNok(belop));}
        break;
      case 2:
        if(tilFraNok == 1) {
          System.out.println(Euro.konvertereTilNok(belop));}
        else{
          System.out.println(Euro.konvertereFraNok(belop));}
        break;
      case 3:
        if(tilFraNok == 1) {
          System.out.println(Sek.konvertereTilNok(belop));}
        else{
          System.out.println(Sek.konvertereFraNok(belop));}
        break;
      default:
        System.out.println("ERROR");
    }


  }
}
