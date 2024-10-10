/*
 * Lag minst en konstruktør
 * Lag flere methods for å beregne fra og til NOK
 * Lag klientprogram som oppretter minst tre objekter som representerer DOLLAR, EURO, SEK.
 * Bruker skal få tilbud om regne ut ulike beløp av ulike VALUTAER om til NOK.
 * Ha en meny for brukeren 1. dol 2. eur 3. sek 4. avslutt. 
 */

package Oving4;

import java.util.Scanner;

public class main_valuta {
    public static void main(String[] args){
        
        // Objects av valuta-klasse
        Valuta Dollar = new Valuta("a" , 10.18);
        Valuta Euro = new Valuta("b", 11.12);
        Valuta Sek = new Valuta("c", 1.04);
        
        Scanner myScanner = new Scanner(System.in);
    
        boolean Running = true;
        while(Running){

            System.out.println("Konvertere til eller fra NOK? \n1. Til NOK \n2. Fra NOK \n3. Avslutt");
            int Svar_fra_til = myScanner.nextInt();
            
            // må være før neste spørsmål, for da avsluttes koden momentant
            if(Svar_fra_til == 3){
                Running = false;
                break;
            }

            System.out.println("Velg hvilken valute du vil konvertere NOK til" + "\n1. Dollar\n2. Euro \n3. SEK \n4. Avslutt");
            int Svar_valuta = myScanner.nextInt();

            Valuta valgt_valuta = null;
            switch (Svar_valuta) {
                case 1:
                    valgt_valuta = Dollar;
                    break;
                case 2:
                    valgt_valuta = Euro;
                    break;
                case 3:
                    valgt_valuta = Sek;
                    break;
                case 4:
                    System.out.println("Avslutter...");
                    Running = false;
                    break;
                default:
                    System.out.println("Ugyldig input");
                    break;
            }
            
            if(Svar_fra_til == 1){
                valgt_valuta.konverteringToNok();
            }
            else if(Svar_fra_til == 2){
                valgt_valuta.konverteringFromNok();
            }
        
        }   
    }
}
