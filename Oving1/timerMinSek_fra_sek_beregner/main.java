package timerMinSek_fra_sek_beregner;

import java.util.Formatter;
import java.util.Scanner;

class konverter{
    public static void main(String[] args){
        double hour = 0;
        double minute = 0;
        double second = 0;

        Scanner myObj = new Scanner(System.in);
        System.out.println("Skriv inn sekunder: ");
        double second_input = myObj.nextDouble(); 

        hour = second_input / 3600;
        minute = (hour-(int)hour) * 60;
        second = (minute-(int)minute) * 60;
        
        
        System.out.println("Følgende: \n" + (int)hour + "\n" + (int)minute + "\n" + (int)second);
    }
}