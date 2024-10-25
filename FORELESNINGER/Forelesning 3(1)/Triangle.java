/**
 * Triangle.java
 * @author GS
 */
import java.util.Scanner;
class Triangle {
    public static void main(String[] args){

        /* Isosceles triangle */
        char symbol = '*';
        int numberOfLines = 5;

        /* read values runtime 
        Scanner reader = new Scanner(System.in);
        System.out.println("Antall linjer: ");
        numberOfLines = reader.nextInt();
        System.out.println("Hvilket symbol vil du bruke?");
        symbol = reader.next().charAt(0); // next() return a String. charAt(0) gets the first char from that String.
        reader.close(); */

        String output = "" + symbol;  // prepare the first line
        for (int i=0; i<numberOfLines; i++){
            System.out.println(output);
            output += symbol; // prepare next line
        }

        /* Equal-sided triangle */
        System.out.println("Equal-sided triangle");
        for (int i=0; i<numberOfLines; i++){
            int numberOfSymbols = 1 + 2*i; // gets the uneven numbers 1 - 3- 5 - 7..
            int numberOfSpaces = numberOfLines - i; 
            output = ""; // clear output for next line to print
            for (int j=0; j<numberOfSpaces; j++){
                output += " "; // add space at the start of the line
            }
            for (int k=0; k<numberOfSymbols; k++){
                output += symbol; // add symbols to the output string
            }
            System.out.println(output);  // print the new line
        }

    }
}