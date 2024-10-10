//En gangetabell som genereres ut fra brukerens ønske hvilke tall. E.g 5-7 gangen. 
package Oving3;

import java.util.Scanner;

public class gangetabell {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Skriv inn fra hvilke tall til hvilke tall vil du se gangetabellen til. E.g. (10-13): ");
        int omraade_tallA = myScanner.nextInt();
        int omraade_tallB = myScanner.nextInt();


        for(int grense = omraade_tallA; grense < (omraade_tallB+1); grense++){
            System.out.println("\n");
            for(int i = 1; i < 11; i++){
                System.out.println(grense + "x" + i + "=" + (grense * i));
            }
        }
    }
}
