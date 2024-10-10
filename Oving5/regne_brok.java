package Oving5;

public class regne_brok {
    //decleration
    private int teller;
    private int nevner;

    //constructor1
    public regne_brok(int teller){
        this.teller = teller;
        this.nevner = 1;
    }
    //constructor2
    public regne_brok(int teller, int nevner){
        if(nevner == 0){
            throw new IllegalArgumentException("Nevner er 0");
        }
        this.teller = teller;
        this.nevner = nevner;
        simplify();
    }

    //forenkler-metode
    public void simplify(){
        int gcd = gcd(teller,nevner);
        this.teller = teller / gcd;
        this.nevner = nevner / gcd;
    }
    /*
    Euclids formula under gjør slik at vi tar nevner og subtraherer fra teller, helt til vi får fellestallet 
    mellom de to. Vi bruker modulo, siden dette er det samme som å subtraere mange ganger.
    Du tar inn 6/2. Metoden sjekker om nevner er 0, noe den ikke er. Så den går videre til return-statement
    og recurer seg inn igjen. Da blir det slik: (2, 6%2) -> (2, 0). Inn i gcd metoden igjen sjekkes det om 
    nevner er null, noe den er. Da returneres teller, som er 2, og bare 2 returneres. Dette er fellestall.
    I eksempel 7/2 vil vi ende opp med (2, 7%2) -> (2,1). Og siden nevner ikke er null sendes den enda en gang
    inn i gcd metode: (1, 2%1) -> (1,0). Da er fellestall 1, og 1 sendes ut. I praksis skjer ingenting med 
    brøken da. 
    */
    public int gcd(int teller, int nevner){
        if(nevner == 0){
            return teller;
        }
        return gcd(nevner, teller % nevner);
    }

    //getter-metoders
    public int get_teller(){
        return this.teller;
    }
    public int get_nevner(){
        return this.nevner;
    }

    //metoder
    //Bruker formula: a/b + c/d = (a*d + b*c) / (b*d)
    public regne_brok addere(regne_brok andre_brok){
        int sum_teller = (this.teller*andre_brok.nevner) + (this.nevner*andre_brok.teller);
        int sum_nevner = (this.nevner*andre_brok.nevner);
        return new regne_brok(sum_teller, sum_nevner);
    }
     // Subtract 
     public regne_brok subtrahere(regne_brok andre_brok) {
        int diff_teller = (this.teller * andre_brok.nevner) - (this.nevner * andre_brok.teller);
        int diff_nevner = (this.nevner * andre_brok.nevner);
        return new regne_brok(diff_teller, diff_nevner);
    }
    // Multiply 
    public regne_brok multiplisere(regne_brok andre_brok) {
        int prod_teller = this.teller * andre_brok.teller;
        int prod_nevner = this.nevner * andre_brok.nevner;
        return new regne_brok(prod_teller, prod_nevner);
    }
    // Divide 
    public regne_brok dele(regne_brok andre_brok) {
        if (andre_brok.teller == 0) {
            throw new IllegalArgumentException("Kan ikke dele med 0");
        }
        int div_teller = this.teller * andre_brok.nevner;
        int div_nevner = this.nevner * andre_brok.teller;
        return new regne_brok(div_teller, div_nevner);
    }

    @Override
    public String toString(){
        return teller + "/" + nevner;
    }
}
