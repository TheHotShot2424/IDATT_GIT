package Oving5;

import java.util.Scanner;

public class main_brok {
    public static void main(String[] args){
        Scanner newScan = new Scanner(System.in);
       
        System.out.println("Skriv teller");
        int teller1 = newScan.nextInt();
        System.out.println("Skriv nevner");
        int nevner1 = newScan.nextInt();
        System.out.println("Skriv teller");
        int teller2 = newScan.nextInt();
        System.out.println("Skriv nevner");
        int nevner2 = newScan.nextInt();

        regne_brok brok1 = new regne_brok(teller1,nevner1);
        regne_brok brok2 = new regne_brok(teller2,nevner2);
        
        //addere, subtrahere, gangen og dividere
        regne_brok resultat_add = brok1.addere(brok2);
        regne_brok resultat_sub = brok1.subtrahere(brok2);
        regne_brok resultat_mult = brok1.multiplisere(brok2);
        regne_brok resultat_div = brok1.dele(brok2);
        System.out.println("Addert: "+resultat_add);
        System.out.println("Subtrahert: "+resultat_sub);
        System.out.println("Mulitplisert: "+resultat_mult);
        System.out.println("Dividert: "+resultat_div);

        newScan.close();
    }
}
