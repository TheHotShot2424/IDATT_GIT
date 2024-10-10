import java.util.Scanner;
import java.security.spec.ECFieldF2m;
import java.util.Random;

public class forelesning36 {
    public static void main(String[] args){
        // // Kontrollstrukturer er enten sekvensiel-del eller valg-del eller løkke-del.
        // // Scope 
        // // OOP vs. funsksjonell programmering. OOP er mer strukturert og effektiv. Java er rent OOP språk.
        
        // //initiating av løkke
        // int count = 0;

        // // Scanner myobject = new Scanner(System.in); 
        // // String line = myobject.nextLine();
        // // System.out.println(line);

        // Random randGenerator = new Random();
        // int randNum = randGenerator.nextInt(100);
        // System.out.println(randNum);

        // //løkkebetingelse
        // while(count < 5) {
        //     //løkkekroppen
        //     System.out.println("En linje " + count);
        //     //oppdatering av betingelse
        //     // count = count + 1; Incriment 
        //     count+=2;
        // }

        Scanner myObj = new Scanner(System.in);
        int choice = myObj.nextInt();

        for(int i = 0; i < choice; i++){
            for(int j = 0; j < i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }


        for(int i = 0; i < choice; i++){
            for(int j = choice-i; j > 1; j--){
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
