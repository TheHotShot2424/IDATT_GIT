package Oving2;

import java.nio.channels.Pipe.SourceChannel;

public class Kjottdeig_billigst {
    public static void main(String[] args){
        
        double kjøttA_PrisPerGram = 450 / 35.90;
        double kjøttB_PrisPerGram = 500 / 39.50;

        if(kjøttA_PrisPerGram > kjøttB_PrisPerGram){
            System.out.println("Kjøttmerke A er billigere");
        }
        else{
            System.out.println("Kjottmerke B er billigst");
        }
    }
}
