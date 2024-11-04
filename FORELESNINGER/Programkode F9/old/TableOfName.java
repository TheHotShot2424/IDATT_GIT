/**
 * TableOfName.java
 * Et lite program som oppretter en tabell med plass til ti strengobjekter.
 * Programmet går i løkke og leser inn navn som legges i denne tabellen.
 * Løkken stopper når tabellen er full eller brukeren har trykket på Esc-tasten.
 */

import static javax.swing.JOptionPane.*;
class TableOfName {
  public static void main(String[] args) {
    String[] names = new String[10];
    int nrOfNames = 0;
    String name = showInputDialog("Oppgi navn: ");
    while (nrOfNames < names.length && name != null) {
      names[nrOfNames] = name;
      nrOfNames++;
      name = showInputDialog("Oppgi navn: ");
    }
    if (nrOfNames == names.length && name != null) {
      showMessageDialog(null, "Ikke plass til flere navn.");
    }
    String list = "Her er navnene:\n";
    for (int i = 0; i < nrOfNames; i++) {
      list += names[i] + "\n";
    }
    showMessageDialog(null, list);
  } // end main
} // end class