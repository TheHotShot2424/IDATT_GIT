package IDATT;

import javax.swing.JOptionPane;

public class PrimtallSjekk {
  public static void main(String[] args){

    int Running = 0; //JOptionPane gir 0 for "Yes" og 1 for "No"
    do{ //for å kjøre kode minst en gang før noe kondisjon blir sjekket
      boolean IsPrime = true; //antar den er primtall til sjekket motsatt. Lønner seg, for da trengs ikke else{}. MÅ være inni do-while for reset boolean
      int inputInt = Integer.parseInt(JOptionPane.showInputDialog("Skriv inn tall å sjekke for primtall: ")); //la sammen showIinputDialog inni paresInt

      for(int n = 2; n < inputInt; n++){
        if(inputInt % n == 0){
          IsPrime = false;
          break;
        }
      }

      //kokt ned fra en if-else statment:
      JOptionPane.showMessageDialog(null, IsPrime ? "Primtall" : "Ikke primtall");

      //avsluttningsskjerm
      int repeter = JOptionPane.showConfirmDialog(null,"Gjenta?","Primtallsjekk", JOptionPane.YES_NO_OPTION);
      Running = repeter; //må ha Running 0 fordi repeter gir 0 på "Yes" av en grunn
    }while(Running==0);

  }
}
