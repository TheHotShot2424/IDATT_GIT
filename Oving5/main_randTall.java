package Oving5;

import java.util.Scanner;

public class main_randTall {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        System.out.println("Hvilket intervall vil du være mellom?: ");
        double nedre = myScanner.nextDouble();
        double ovre = myScanner.nextDouble();

        MinRandom obj = new MinRandom(nedre, ovre);

        int resultat_heltall = obj.nestHeltall((int)nedre, (int)ovre);
        double resultat_desimal = obj.nesteDesimaltall(nedre, ovre);
        System.out.println("\nHeltall: "+resultat_heltall);
        System.out.println("Desimaltall: "+resultat_desimal);
    }
}
