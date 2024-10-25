package IDATT;

import java.util.Scanner;

public class RegneBrokMain {
  public static void main(String[] args) {
    Scanner newScan = new Scanner(System.in);

    System.out.println("Skriv teller");
    int teller1 = newScan.nextInt();
    System.out.println("Skriv nevner");
    int nevner1 = newScan.nextInt();
    System.out.println("Skriv teller");
    int teller2 = newScan.nextInt();
    System.out.println("Skriv nevner");
    int nevner2 = newScan.nextInt();

    RegneBrok brok1 = new RegneBrok(teller1,nevner1);
    RegneBrok brok2 = new RegneBrok(teller2,nevner2);

    //addere, subtrahere, gangen og dividere
    RegneBrok resultat_add = brok1.addering(brok2);
    RegneBrok resultat_sub = brok1.subtraering(brok2);
    RegneBrok resultat_mult = brok1.multiplisering(brok2);
    RegneBrok resultat_div = brok1.dividering(brok2);
    System.out.println("Addert: "+resultat_add);
    System.out.println("Subtrahert: "+resultat_sub);
    System.out.println("Mulitplisert: "+resultat_mult);
    System.out.println("Dividert: "+resultat_div);

    newScan.close();
  }
}
