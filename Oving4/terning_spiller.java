package Oving4;
/**
 * A og B kaster terning annenhver gang
 * Tall på terning skal summeres sammen til poeng.
 * Hvis noen får 1, resettes summen til 0.
 * Den første over 100 poeng vinner. 
 *  
 */


import java.util.Random;
/**
 * objektvariabel sumPoeng
 * metode: getSumPoeng(), kastTerningen(), erFerdig()
 * innenfor metode kastTerningen() hentes tilfeldig tall 0,5 slik: 
 *      Int terningkast = terning.nextInt(6);
 * 
 */
public class terning_spiller {
    
    //decleration
    private char spiller;
    private int spiller_sum;

    //constructor
    /**
     * Oppretter en spiller 
     * @param spiller A eller B
     * @param spiller_sum Summen til spiller A eller B
     */
    terning_spiller(char spiller, int spiller_sum){
        this.spiller = spiller;
        this.spiller_sum = spiller_sum;
    }

    //methods
    public void kastTerningen(){
        Random terning_kast = new Random();
        int terningkast = (terning_kast.nextInt(6)) + 1;

        System.out.println(terningkast);
        if(terningkast == 1){
            System.out.println("Du rullet 1. Sum resettes tilbake til 0");
            spiller_sum = 0 - 1;
        }
        spiller_sum += terningkast;
        if (spiller_sum > 100){
            System.out.println("Overstiger. Kast subtraerer fra summen: ");
            spiller_sum -= terningkast;
        }
    }
    public boolean erFerdig(){
        if(spiller_sum == 100){
            return true;
        }
        return false; 
    }

    public void getSumPoeng(){
        System.out.println(spiller_sum);
    }
}
