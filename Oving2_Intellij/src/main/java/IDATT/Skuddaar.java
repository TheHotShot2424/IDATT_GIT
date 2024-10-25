package IDATT;

import javax.swing.JOptionPane;

public class Skuddaar {

  public static void main(String[] args) {
    String aarstall = JOptionPane.showInputDialog("Skriv inn årstall ");
    int aarstallInt = Integer.parseInt(aarstall); //kan pakke aarstall inn her hvis du vil, men mindre oversiktelig

    boolean check = (aarstallInt % 4 == 0 && (aarstallInt & 100) != 0) || (aarstallInt % 100 == 0 && aarstallInt % 400 == 0);

    String melding = check ? "Det er skuddår!" : "Det er ikke skuddår";

    JOptionPane.showMessageDialog(null,melding);

  }
}