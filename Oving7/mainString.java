package Oving7;

import java.util.Scanner;

public class mainString {
    public static void main(String[] args) throws Exception {
        Scanner minScanner = new Scanner(System.in);
        
        boolean Running = true;
        while(Running){
            //oppsett av setning og objekt
            System.out.println("Skriv inn din setning: ");
            String streng = minScanner.nextLine();
            NyString obj1 = new NyString(streng); //object variable er obj1
            tekstBehandling obj2 = new tekstBehandling(streng);
            
            //alternativsvindu
            System.out.println("\nVil du forkorte (1)\nFjerne et spesifikt ord (2)\nEller mer content (3)");
            int valg = minScanner.nextInt();
            minScanner.nextLine();  // må ha denne fordi hvis ikke blir neste linje "consumed" av tidligere 
                                    // scannere. Denne absorberer overskridelsen. Brukes bare der den "trengs". 
                                    // En må bare finne ut av dette gjennom terminal og mange runnings av koden.
    
            
            //optioner
            if(valg == 1){
                System.out.println(obj1.forkortning());
            }
            else if(valg == 2){
                System.out.println("Hvilken bokstav vil du fjerne?: ");
                String bokstavFjern = minScanner.nextLine();
    
                System.out.println(obj1.fjernOrd(bokstavFjern));
            }
            else if(valg == 3){
                obj2.valgmenydekor(); //test, for å sjekke forskjell mellom void- og return-metoder
                double gjennomsnt = obj2.gjennomsnittligOrdlengde(); //virker at obj2.gjenn- kaller sout innad i metoden
                System.out.println("Gjennomsnittslengde på ord: "+gjennomsnt); // men for å se RETURN-verdi må den lagres i egen variabel innad i main(), og deretter sout
                System.out.println("Gjennomsnitt ord per setning: "+obj2.ordPerPeriode());
                
                System.out.println("\nSkriv inn hvilke streng du vil bytte ut: ");
                String strengUt = minScanner.nextLine();
                System.out.println("Hva vil du bytte ut med?: ");
                String strengIn = minScanner.nextLine();
                System.out.println("Den endrede teksten: "+obj2.bytteOrd(strengUt, strengIn));
                System.out.println("Original tekst: " + obj1.toString());
                System.out.println("Original tekst: " + obj1.toString().toUpperCase());
            }
            else{
                throw new Exception("Må være tall 1 eller 2");
            }


            //avsluttningsskjerm
            boolean check = true;
            while(check){
                System.out.println("Vil du forsette? (j/n)");
                String fortsette = minScanner.nextLine();
                
                if(fortsette.toLowerCase().equals("j")){
                    check = false;
                    //minScanner.nextLine();
                }
                else if(fortsette.toLowerCase().equals("n")){
                    Running = false;
                    check = false;
                }
            }
        }
    }
}
