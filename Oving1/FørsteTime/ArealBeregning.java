package FørsteTime;
import java.util.*;

class ArealBeregning{

    static int testVariable = 21;
    
    public static void main(String[] args){

        final double LENGDE = 10;
        double bredde = 5.1;
        double areal = LENGDE * bredde;

        String testString = "abc";
        char tegn = 'a';


        // //Endre fra string til numb igjen.
        // int newNumb = Integer.parseInt(testString);

        System.out.println(testString);
        System.out.println(areal);
        testMethod(3,1,2);
    }

    public static void testMethod(int param1, int param2, int param3){
        // System.out.println(lengde); //Går ikke. Out of scope
        System.out.println(testVariable);
        int paramTot = param1 + param2 + param3;
        System.out.println(paramTot);
    }
}