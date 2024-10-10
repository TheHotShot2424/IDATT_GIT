package Oving4;

/*
 * Objekt av klassen terning_spiller: java.util.Random terning = new java.util.Random(); //lager en tilfeldigtallsgenerator
 * 
 */

public class main_terning {
    public static void main(String[] args){
        terning_spiller spiller_A = new terning_spiller('A', 0);
        terning_spiller spiller_B = new terning_spiller('B', 0);

        char current_player = 'A';
        int round = 0;
        
        while(true){
            round++;
            if(current_player == 'A'){

                System.out.println("\nRunde: "+round +". Spiller A ruller: ");
                spiller_A.kastTerningen();
                System.out.println("Summen: ");
                spiller_A.getSumPoeng();
                boolean check = spiller_A.erFerdig();
                 
                if(check){
                    System.out.println("\n********************\nA vinner!\n********************");
                    break;
                }

                current_player = 'B';
            }
            else if(current_player == 'B'){
                
                System.out.println("\nRunde: "+round +". Spiller B ruller: ");
                spiller_B.kastTerningen();
                System.out.println("Summen: ");
                spiller_B.getSumPoeng();
                boolean check = spiller_B.erFerdig();
                
                if(check){
                    System.out.println("\n********************\nB vinner!\n********************");
                    break;
                }

                current_player = 'A';
            }
        }
    }
}
