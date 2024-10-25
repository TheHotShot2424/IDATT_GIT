import static javax.swing.JOptionPane.*;
class Break_Continue_Example {
    public static void main(String[] args){
        final int LIMIT = 10;
        int sum = 0;
        String numberAsText = showInputDialog ("Skriv tall, avslutt med Esc");
        
        while (numberAsText != null) {
            int number = Integer.parseInt(numberAsText);
            sum += number;
            if (sum > LIMIT) break;
            numberAsText = showInputDialog ("Skriv tall, avslutt med Esc"); 
        } 
        showMessageDialog(null, "Summen er " + sum + ".");
    }
}