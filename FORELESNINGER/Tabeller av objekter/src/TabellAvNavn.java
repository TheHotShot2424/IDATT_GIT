import static javax.swing.JOptionPane.*;

public class TabellAvNavn {
    public static void main(String[] args) {
        String[] navneliste = new String[10];
        int antNavn = 0;
        String navn = showInputDialog("Oppgi navn: ");
        while (antNavn < navneliste.length && navn != null) {
            navneliste[antNavn] = navn;
            antNavn++;
            navn = showInputDialog("Oppgi navn: ");
        }
        if (antNavn == navneliste.length && navn != null) {
            showMessageDialog(null, "Ikke plass til flere navn.");
        }
        String liste1 = "Her er navnene:\n";
        for (int i = 0; i < antNavn; i++) {
            liste1 += navneliste[i] + "\n";
        }
        showMessageDialog(null, liste1);

        // Alternativt
        String liste2 = "Her er navnene - hentet vha utvidet for-løkke:\n";
        for(String s : navneliste){
            liste2 += s + "\n";
        }
        showMessageDialog(null, liste2);
    }
}
