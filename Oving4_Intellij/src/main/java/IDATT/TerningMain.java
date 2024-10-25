package IDATT;

public class TerningMain {

  public static void main(String[] args) {
    Terning spillerA = new Terning('A');
    Terning spillerB = new Terning('B');

    char starterPlayer = 'A';
    int round = 0;

    while(true){
      round++;
      Terning currentPlayer = (starterPlayer == 'A' ? spillerA : spillerB); //for å ikke gjenta to blokker som er lik bare med spillerA og spillerB

      int roll = currentPlayer.terningkast();
      System.out.println("Runde "+round+". Spiller A ruller: "+roll);

      if(roll == 1){
        System.out.println("Rullet 1. Resettes... ");
      }
      System.out.println("Summen: "+currentPlayer.getSumPoeng());
      boolean checkWin = currentPlayer.erFerdig();
      if(checkWin){
        System.out.println("\n********************\nA vinner!\n********************");
        break;
      }

      starterPlayer = 'B';
    }

  }
}