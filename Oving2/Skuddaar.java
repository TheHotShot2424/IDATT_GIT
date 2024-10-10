package Oving2;

import java.util.Scanner;

public class Skuddaar {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Skriv inn ditt år, og se om det er skuddår: ");

        int user_input = myScanner.nextInt();

        if(user_input % 4 == 0 & user_input % 100 != 0){
            System.out.println("Det er skuddår");
        }
        else if(user_input % 100 == 0 & user_input % 400 == 0){
            System.out.println("Det er skuddår");
        }
        else{
            System.out.println("Bare et kjedelig år...");
        }
    }
}
