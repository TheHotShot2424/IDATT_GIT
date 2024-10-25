import static javax.swing.JOptionPane.*;
class Sum {
  public static void main(String[] args) {
    
    int sum = 0;
    String numberAsText = showInputDialog ("Skriv tall, avslutt med Esc");
    
    while (numberAsText != null) {
         int number = Integer.parseInt(numberAsText);
           sum += number;
          numberAsText = showInputDialog ("Skriv tall, avslutt med Esc"); 
    }
     
    showMessageDialog(null, "Summen er " + sum + ".");
   }
}