package IDATT;

public class RegneBrok {
  //declaring instance variable/attributes
  private int teller;
  private int nevner;

  //constructors
  public RegneBrok(int teller){
    this.teller = teller;
    this.nevner = 1;
  }
  public RegneBrok(int teller, int nevner){
    if(nevner == 0){
      throw new IllegalArgumentException("Kan ikke dele på 0");
    }
    this.teller = teller;
    this.nevner = nevner;
    simplify(); //bruker metode som lagde nedenfor
  }

  //getters
  public int getTeller() {
    return teller;
  }
  public int getNevner(){
    return nevner;
  }

  //formula-methods
  //følgende to metoder gcd og simplify bruker Euclids formula
  public int gcd(int teller, int nevner){
    if(nevner == 0){
      return teller;
    }
    return gcd(nevner, teller % nevner);
  }
  public void simplify(){
    int gcd = gcd(teller,nevner); //greatest common divisor
    this.teller = teller/gcd;
    this.nevner = nevner/gcd;
  }

  //regnemetoder
  public RegneBrok addering(RegneBrok andreBrok){  //vi tar inn andreBrok, som er av datatype RegneBrok.
    int sumTeller = this.teller * andreBrok.nevner + this.nevner * andreBrok.teller; //Bruker formel  a/b + c/d = (a*d + b*c) / (b*d) så slipper å jobbe med desimaler
    int sumNevner = this.nevner * andreBrok.nevner;
    return new RegneBrok(sumTeller,sumNevner); //lager ny instanse i RegneBrok og sender sumTeller, sumNevner i simplefied() igjen, tilfelle addering lagde ny brøk som kan simplifiseres mer.
  }
  public RegneBrok subtraering(RegneBrok andreBrok){
    int sumTeller = this.teller * andreBrok.nevner - this.nevner * andreBrok.teller;
    int sumNevner = this.nevner * andreBrok.nevner;
    return new RegneBrok(sumTeller,sumNevner);
  }
  public RegneBrok multiplisering(RegneBrok andreBrok){
    int prodTeller = this.teller * andreBrok.teller;
    int prodNevner = this.nevner * andreBrok.nevner;
    return new RegneBrok(prodTeller,prodNevner);
  }
  public RegneBrok dividering(RegneBrok andreBrok){
    if(andreBrok.nevner == 0){
      throw new IllegalArgumentException("Kan ikke dele med 0");
    }
    int DivisjonTeller = this.teller * andreBrok.nevner;
    int DivisjonNevner = this.nevner * andreBrok.teller;
    return new RegneBrok(DivisjonTeller,DivisjonNevner);
  }

  @Override
  public String toString(){
    return teller +"/"+ nevner;
  }

}