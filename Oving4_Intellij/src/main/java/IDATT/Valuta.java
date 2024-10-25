package IDATT;

public class Valuta {
  //declare instance variable/attributes
  private double valutaRate;

  //constructor
  public Valuta(double valutaRate){
    this.valutaRate = valutaRate;
  }

  //Methods
  public double konvertereTilNok(double belop){
    return valutaRate * belop;
  }
  public double konvertereFraNok(double belop){
    return belop / valutaRate;
  }
}
