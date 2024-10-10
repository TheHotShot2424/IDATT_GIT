package Oving5;
/*
 * Lag klassen minrandom som tilbyr nextInt(x) og nextDouble().
 * 
 */

import java.util.Random;

public class MinRandom {
    Random randTall = new Random();

    //declaration
    private double nedre, ovre;

    //constructor
    public MinRandom(double nedre, double ovre){
        this.nedre = nedre;
        this.ovre = ovre;
    }
    
    //methods
    public int nestHeltall(int nedre, int ovre){
        return randTall.nextInt(nedre,ovre);
    }
    /*formel nextDouble gir bare verdi mellom 0 og 1 (1 ikke inklusiv). Vi må bruke en formel for 
    * å kunne få en desimalverdi over 1. 
    * Formelen har to deler; før pluss og etter. Før pluss forteller lower bound og etter pluss gir
    * upper-bound. Formelen tar og genererer først et tall mellom 0 og 1 og ganger da dette med ovre
    * minus nedre for å skalerer opp mot ønsket range. Den må minuseres, hvis ikke er den +1 for høyt opp. 
    * Dermed må du så ha nedre for å forskyve nedre side opp mot den ønsket lavre bound. 
    */
    public double nesteDesimaltall(double nedre, double ovre){
        return  nedre + (randTall.nextDouble() * (ovre-nedre));
    }
}
