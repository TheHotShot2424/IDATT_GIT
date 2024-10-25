/**
 * SumWithLimits.java
 * Program som summerer flere tall helt til summen overstiger
 * en gitt grense (LIMIT)
 */
import static javax.swing.JOptionPane.*;
class SumWithLimits {
    public static void main(String[] args) {
        final int LIMIT = 10;
        boolean limitReached = false;
        int sum = 0;
        String numberAsText = showInputDialog ("Skriv tall, avslutt med Esc");
        
        while (numberAsText != null && !limitReached) {
          int number = Integer.parseInt(numberAsText);
           sum += number;
           if (sum > LIMIT){
                  limitReached = true;
            } else {
                  numberAsText = showInputDialog ("Skriv tall, avslutt med Esc"); 
          }
        }
         
        showMessageDialog(null, "Summen er " + sum + ".");
       }
     }