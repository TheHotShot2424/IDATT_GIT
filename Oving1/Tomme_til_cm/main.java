package Tomme_til_cm;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner newObj = new Scanner(System.in);
        System.out.println("Skriv inn din tomme (den vil konverteres til cm)");
        
        double User_input = newObj.nextDouble();
        double konvert_centimeter = User_input * 2.54;

        System.out.println("I cm: " + konvert_centimeter);

    }
}
