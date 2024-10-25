package Oving6;


import java.util.Random;

public class oppgave1 {
    public static void main(String[] args){
        Random random = new Random();
        
        int[] antall = new int[10]; //lager array [0,0,0,0,0,0,0,0,0,0]
    
        for(int i = 0; i < 1000; i++){
            int index = random.nextInt(10);
            antall[index]++; //inkrementerer antall fra 0 på oppgitt index i.
        }

        System.out.println("Hvor mange ganger hvert tall 1 til 10 ble telt: ");
        for(int i = 0; i < antall.length; i++){
            System.out.print(i+1+": "+antall[i]+" ");

            int stars = (antall[i]+5)/10; //formula to round to nearest 10th: (tall + 50) / 100. Python runder alltid nedover
            for(int j = 0; j < stars; j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
