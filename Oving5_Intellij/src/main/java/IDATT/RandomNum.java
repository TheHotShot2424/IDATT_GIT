package IDATT;

import java.util.Random;

public class RandomNum {
  Random rand = new Random();

  //declaring instance variable/attributes
  private double nedre, ovre; //er lov å deklarere som dette

  //constructor
  public RandomNum(double nedre,double ovre){
    this.nedre = nedre;
    this.ovre = ovre;
  }

  //methods
  public int heltallRand(int nedre,int ovre){
    return rand.nextInt(nedre,ovre);
  }
  public double desimalRand(double nedre, double ovre){
    return rand.nextDouble(nedre,ovre);
  }
}
