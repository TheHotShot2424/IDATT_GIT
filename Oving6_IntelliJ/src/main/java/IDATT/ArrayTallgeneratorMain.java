package IDATT;

import java.util.Random;

public class ArrayTallgeneratorMain {

  public static void main(String[] args) {
    Random random = new Random();
    int[] antall = new int[10]; //lager array [0,0,0,0,0,0,0,0,0,0]

    for(int i = 0; i < 1000; i++){ //MÅ ikke bruke "i" inni for-loop. Uansett gjentar koden seg.
      int index = random.nextInt(10);
      antall[index]++;
    }

    System.out.println("Hvor mange ganger hvert tall 1 til 10 ble trukket: ");
    for(int i = 0; i < antall.length; i++){
      System.out.print(i+1 +": "+ antall[i] + " ");

      //outputte stjerner bak svar:
      int stars = (antall[i]+5)/10; //formel for avrunde til nærmeste 10'er.
      for(int j = 0; j < stars; j++){
        System.out.print("*");
      }
      System.out.println();
    }

  }
}