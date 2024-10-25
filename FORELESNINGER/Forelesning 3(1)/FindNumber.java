import java.util.Random;
class FindNumber {
    public static void main(String[] args) {
      final int limit1 = 0;
      final int limit2 = 70;
      final int limit3 = 80;
      final int limit4 = 100;
  
      Random numberGen = new Random();
      int oKNumber = 0;  
      int number =limit1 + numberGen.nextInt(limit4 - limit1 + 1); 
      while (number < limit2 || number > limit3) {
        oKNumber++;
        System.out.println(number);
        number = limit1 + numberGen.nextInt(limit4 - limit1 + 1);
      }
      System.out.println("Vi måtte trekke " + oKNumber + " tall til vi fant et ugyldig: " + number);
     }
   }