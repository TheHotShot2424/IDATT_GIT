/**
 * Read numbers and sum them up. Not allowed to add the same number in a row.
*/
import static javax.swing.JOptionPane.*;
class SumOddNumbers {
  public static void main(String[] args) {
    int countNumberInSum = 0;
    int sum = 0;
    String preveousNumberAsText = "";
    String numberAsText = showInputDialog ("Skriv ett tall av gangen, avslutt med Esc: ");
    
     while (numberAsText != null) {
        if (!numberAsText.equals(preveousNumberAsText)){
          int tall = Integer.parseInt(numberAsText);
          sum += tall;
          countNumberInSum++;
        }
        preveousNumberAsText = numberAsText;
        numberAsText = showInputDialog ("Skriv ett tall av gangen, avslutt med Esc"); 
      }
    showMessageDialog(null, "Summen er " + sum + ". Vi har summert " + countNumberInSum + " tall.");
   }
 }
