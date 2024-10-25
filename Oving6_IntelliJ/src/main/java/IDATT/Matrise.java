package IDATT;

import java.util.Arrays;

public class Matrise {
  //declare instance variable/attributes
  private final int[][] matrixHoldr; //2D array, final for å være immutabel: e.g. {{0,0,0},{1,1,1},{2,2,2}}
  private final int matrixLength;

  //constructor for initialize matrix nxn
  public Matrise(int[][] OurMatrix){
    matrixLength = OurMatrix.length;
    this.matrixHoldr = new int[matrixLength][matrixLength]; //initializerer matrixHoldr

    for(int i = 0; i < OurMatrix.length; i++){  //bruker .copyOf() på 1D array, men trikser slik at vi bruker for en 2D array også
      this.matrixHoldr[i] = Arrays.copyOf(OurMatrix[i],matrixLength); //{0,0,0} = {1,2,3} , {1,1,1} = {4,5,6} etc.
    }
  }

  //methods
  public Matrise adder(Matrise TheirMatrix){
    int[][] adderingMatrix = new int[matrixLength][matrixLength]; //fersk kopi av matrixHoldr-strukturen å jobbe med

    for(int row = 0; row < matrixLength; row++){
      for(int col = 0; col < matrixLength; col++){
          adderingMatrix[row][col] = this.matrixHoldr[row][col] + TheirMatrix.matrixHoldr[row][col];
        }
      }
    return new Matrise(adderingMatrix); //lager nytt objekt fordi matrixHoldr er immutabel. Dette nye objektet lagrer vi i main og printer der.
  }
  public Matrise multipliser(Matrise TheirMatirx){
    int[][] mulitMatrix = new int[matrixLength][matrixLength];

    for(int row = 0; row < matrixLength; row++){
      for(int col = 0; col < matrixLength; col++){
        mulitMatrix[row][col] = 0; //for å overskrive gamle verdier
        for(int k = 0; k < matrixLength; k++){
          mulitMatrix[row][col] = this.matrixHoldr[row][k] * TheirMatirx.matrixHoldr[k][col]; //ganger langs kolonne i tillegg
        }
      }
    }
    return new Matrise(mulitMatrix);
  }
  public Matrise transpose(){
    int[][] transposeMatrix = new int[matrixLength][matrixLength];

    for(int row = 0; row < matrixLength; row++){
      for(int col = 0; col < matrixLength; col++){
        transposeMatrix[row][col] = this.matrixHoldr[col][row];
      }
    }
    return new Matrise(transposeMatrix);
  }

  @Override
  public String toString(){
    StringBuilder stringBuilder = new StringBuilder(); //stringbuilder er som sandbox hvor du kan putte hva du vil i.
    for(int row = 0; row < matrixLength; row++){
      for(int col = 0; col < matrixLength; col++){
        stringBuilder.append(matrixHoldr[row][col]);
        stringBuilder.append(" ");
      }
      stringBuilder.append("\n");
    }
    return stringBuilder.toString();
  }
}

