package Oving6;


/**
 * Lag immutabel klasse Matrise som inneholder todimensjonell tabell 3x3 matrise. 
 * Lag metoder addere, mulitplisere, transponere.
 * Om operasjon er umulig, returner 0. 
 */

public class Matrise {
    //declaration 
    private final int[][] matrix_holder; //legger til "final" for å gjøre den immutable. Den kan nå ikke bli reassigned til andre arrays
    private int matrixLength = 0;

    //constructor to initialize matrix 3x3
    public Matrise(int[][] matrix){
        matrixLength = matrix.length; //for lengde

        this.matrix_holder = new int[matrix.length][matrix.length]; //initialize internal array 
        for(int i = 0; i < matrix.length; i++){
            System.arraycopy(matrix[i], 0, this.matrix_holder[i], 0, matrix.length); //kopierer rader fra matrix til matrix_holder. Kopierer i tillegg elementer (3 i dette tilfelle)
        }
    }

    //metode addisjon
    public Matrise add(Matrise matrix){

        int C[][] = new int[matrixLength][matrixLength];

        for(int row = 0; row < matrixLength; row++){
            for(int col = 0; col < matrixLength; col++){
                C[row][col] = this.matrix_holder[row][col] + matrix.matrix_holder[row][col]; //bruker objektets matrix, og adderer med parameterens matrix
            }
        }
        return new Matrise(C); //lager nytt objekt og returnerer dette
    }
    //metode mulitplikasjon
    public Matrise multiply(Matrise matrix){
        
        int C[][] = new int[matrixLength][matrixLength];

        for(int row = 0; row < matrixLength; row++){
            for(int col = 0; col < matrixLength; col++){
                C[row][col] = 0; //initialize to 0. Må gjøre dette for å skrive over noen evt. gamle verdier på [0][0]
                for(int k = 0; k < matrixLength; k++){
                    C[row][col] = this.matrix_holder[row][k] * matrix.matrix_holder[k][col]; //bruker objekts matrix ganger parameter matrix
                }
            }
        }
        return new Matrise(C);
    }

    //metode transponering
    public Matrise transpose(){
        int[][] C = new int[matrixLength][matrixLength];

        for(int row = 0; row < matrixLength; row++){
            for(int col = 0; col < matrixLength; col++){
                C[row][col] = this.matrix_holder[col][row];
            }
        }
        return new Matrise(C);
    }

    @Override
    public String toString(){
        StringBuilder stringbuild = new StringBuilder(); //stringbuilder er perfekt å bruke i toString metode, da den lar deg manipulerer streng svært
        for(int row = 0; row < matrixLength; row++){
            for(int col = 0; col < matrixLength; col++){
                stringbuild.append(matrix_holder[row][col]);
                stringbuild.append(" ");
            }
            stringbuild.append("\n");
        }
        return stringbuild.toString();
    }


    public static void main(String[] args){
        int[][] matrix1array = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2array = {{9,8,7},{6,5,4},{3,2,1}};
        // int[][] matrix1array = {{1,2},
        //                         {4,5}};
        // int[][] matrix2array = {{9,8},
        //                         {6,5}};
        

        Matrise matrise1 = new Matrise(matrix1array);
        Matrise matrise2 = new Matrise(matrix2array);

        Matrise printAdd = matrise1.add(matrise2);
        Matrise printMult = matrise1.multiply(matrise2);
        Matrise printTrans = matrise1.transpose();

        Matrise printAdd2 = matrise2.add(matrise1);
        Matrise printMult2 = matrise2.multiply(matrise1);
        Matrise printTrans2 = matrise2.transpose();

        System.out.println("Addisjon gir: \n"+printAdd);
        System.out.println("Mulitplikasjon gir: \n"+printMult);
        System.out.println("Transponering matrise A gir: \n"+printTrans);

        System.out.println("Addisjon motsatt gir: \n"+printAdd2);
        System.out.println("Mulitplikasjon motsatt gir: \n"+printMult2);
        System.out.println("Transponering matrise B gir: \n"+printTrans2);
    }
}
