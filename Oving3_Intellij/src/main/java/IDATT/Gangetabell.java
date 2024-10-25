package IDATT;

import javax.swing.JOptionPane;

public class Gangetabell {
  public static void main(String[] args) {

    String gangetabellStart = JOptionPane.showInputDialog("Skriv inn gangetabell fra: ");
    String gangetabellSlutt = JOptionPane.showInputDialog("Skriv inn gangetabell til: ");
    int gangStartInt = Integer.parseInt(gangetabellStart);
    int gangSluttInt = Integer.parseInt(gangetabellSlutt);

    for(int grense = gangStartInt; grense < gangSluttInt+1; grense++){
      System.out.println();
      for(int i = 1; i < 11; i++){
        System.out.println(grense + " x " + i + " = " + grense*i);
      }
    }


  }
}