package Oving4;

import java.util.Scanner;

class Valuta {
    
    // Declaretion
    private double valutaRate;
    private String navn;

    // Constructor
    public Valuta(String navn, double valutaRate){
        this.navn = navn;
        this.valutaRate = valutaRate;
    }

    // Methods
    //Metoder bør ikke printe eller ta inn
    public void konverteringToNok(){ 
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Skriv inn ditt beløp i valgt valuta: ");
        double mengde = myScanner.nextDouble();
        double konvertert_beløp = valutaRate * mengde;
        System.out.println("\n****************\n"+konvertert_beløp+"\n******************");
    }
    public void konverteringFromNok(){ 
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Skriv inn ditt beløp i valgt valuta: ");
        double mengde = myScanner.nextDouble();
        double konvertert_beløp = mengde / valutaRate;
        System.out.println("\n****************\n"+konvertert_beløp+"\n******************");
    }
}
