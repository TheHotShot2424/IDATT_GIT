package IDATT;

import java.util.Scanner;

public class RandomNumMain {
  public static void main(String[] args){
    Scanner myScanner = new Scanner(System.in);

    System.out.println("Hvilket intervall vil du være mellom?: ");
    double nedre = myScanner.nextDouble();
    double ovre = myScanner.nextDouble();

    RandomNum randomGenerator = new RandomNum(nedre, ovre);

    int resultat_heltall = randomGenerator.heltallRand((int)nedre, (int)ovre);
    double resultat_desimal = randomGenerator.desimalRand(nedre, ovre);
    System.out.println("\nHeltall: "+resultat_heltall);
    System.out.println("Desimaltall: "+resultat_desimal);
  }
}
