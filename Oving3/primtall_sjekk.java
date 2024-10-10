package Oving3;

import java.util.Scanner;

public class primtall_sjekk {
    public static void main(String[] args) {
        int check = 0;
        int running = 1;
        Scanner myScanner = new Scanner(System.in);
        
        do{
            System.out.println("Skriv inn tall, og vi skjekker om det er primtall: ");
            int tall = myScanner.nextInt();
            
            for(int n = 2; n < tall; n++){
                if(tall % n == 0){
                    check = 0;
                    break;
                }
                else{
                    check = 1;
                }
            }

            if(check == 1){
                System.out.println("Primtall!");
            }
            else{
                System.out.println("Ikke primtall");
            }
            System.out.println("Do you want another go? 1 = yes, 2 = no: ");
            running = myScanner.nextInt();

        }while(running == 1);
    }
}









 // if(tall <= 1){
        //     System.out.println("1 er ikke et primtall");
        // }

 // if(tall % 1 == 0 & tall % tall == 0){
        //     System.out.println("Primtall");
        // }
        // else{
        //     System.out.println("Ikke primtall");
        // }