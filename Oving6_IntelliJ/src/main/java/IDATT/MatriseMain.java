package IDATT;

public class MatriseMain {
  public static void main(String[] args){
    int[][] matrix1array = {{1,2,3},
                            {4,5,6},
                            {7,8,9}};

    int[][] matrix2array = {{9,8,7},
                            {6,5,4},
                            {3,2,1}};

    Matrise matrise1 = new Matrise(matrix1array);
    Matrise matrise2 = new Matrise(matrix2array);

    Matrise printAdd = matrise1.adder(matrise2); //her lages nye objektet fra add()-metoden
    Matrise printMult = matrise1.multipliser(matrise2);
    Matrise printTrans = matrise1.transpose();

    Matrise printAdd2 = matrise2.adder(matrise1);
    Matrise printMult2 = matrise2.multipliser(matrise1);
    Matrise printTrans2 = matrise2.transpose();

    System.out.println("Addisjon gir: \n"+printAdd);
    System.out.println("Mulitplikasjon gir: \n"+printMult);
    System.out.println("Transponering matrise A gir: \n"+printTrans);

    System.out.println("Addisjon motsatt gir: \n"+printAdd2);
    System.out.println("Mulitplikasjon motsatt gir: \n"+printMult2);
    System.out.println("Transponering matrise B gir: \n"+printTrans2);
  }
}
