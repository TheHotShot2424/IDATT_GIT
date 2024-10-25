package IDATT;

import java.util.Random;

public class Terning {
  //decleration instanse variable/attributes
  private char spiller;
  private int spillerSum;

  //constructor
  public Terning(char spiller){
    this.spiller = spiller;
  }

  //methods
  public int terningkast(){
    int terningkast = new Random().nextInt(6)+1; //koket ned fra "Random terningast = new[...]"

    if(terningkast == 1) spillerSum = - 1; //Reset. Er tillatt å skrive slik, men ikke anbefalt fordi uoversiktelig
    spillerSum +=terningkast;
    if(spillerSum > 100) spillerSum -= terningkast; //om sum går over hundre subtraeres istedet

    return terningkast;
  }

  public boolean erFerdig(){
    return spillerSum == 100; //returnerer true
  }
  public int getSumPoeng(){
      return spillerSum;
  }
}
