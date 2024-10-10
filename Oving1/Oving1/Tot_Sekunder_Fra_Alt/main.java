package Oving1.Tot_Sekunder_Fra_Alt;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner objt = new Scanner(System.in);

        System.out.println("Write how many hour(s), minute(s) and/or second(s) you want to sum to seconds: ");
        int hour = objt.nextInt();
        int minute = objt.nextInt();
        int second = objt.nextInt();

        int hour_convrt = hour * 3600;
        int minute_convrt = minute * 60;

        int tot_sec = hour_convrt + minute_convrt + second;

        System.out.println("Total amount of seconds: " + tot_sec);
    }
}
