package Oving6;


import java.util.Scanner;

/*
 * Lag klasse Tekstanalyse
 * Lag array int[] antallTegn = new int[30]
 * antallTegn har [a,b...,å,tegn], hvor siste 29. er alt annet enn alfabetet. Skiller ikke mellom store/små bokstaver
 * Ha et objekt String, få tak i tegnet på bestemt posisjon med chatAt(), lengde med length()
 * Lag metode. Konstuktør tar inn teksten og fyller opp array antallTegn med antall av hvert tegn. 
 * Klient skal se følgende:
 * - Finn antall forskjellige bokstaver, BARE boktaver, ikke andre tegn
 * - Totalt antall bokstaver i teksten.
 * - Hvor stor prosent av teksten er ikke bokstaver
 * - Antall forekomster av bestemt bokstav. Bokstav skal være parameter til metode.
 * - Hvilke(n) bokstave(r) forekommer oftest, om det er flere.
 * Legg alt i en while-loop. 
 */

public class tekstAnalyse {
    //decleration of instance variable. Vi deklarerer den først, og lar den bli brukt i konstruktør.
    private int[] antallTegn = new int[27]; // [0,0,....,0] 
    private int totalBokstaver = 0;

    //constructor analysere tekst
    public tekstAnalyse(String tekst){
        for(int i = 0; i < tekst.length(); i++){ // lengde på et Streng objekt må bruke length()
            char tegn = tekst.charAt(i); // få tak i bestemt tegn på index
            if(tegn >= 'a' && tegn <= 'z'){
                antallTegn[tegn-'a']++; //hvis tegn mellom små alfabet; tegn-'a' gir index og inkrementerer plass, f.eks. 'h'-'a' = 7 index, og da skal 7. plass i array ++ fra 0
                totalBokstaver++;
            }
            else{
                antallTegn[26]++; //inkrementerer index i array som er ansvarlig for alt annet enn bokstaver
            }
        }
    }

    //METODER for klients ønskede informasjoner
    //metode for finne antall ulike bokstaver, BARE bokstaver. F.eks. abbbc = 3 ulike bokstaver.
    public int ulikeBOKSTAVER(){
        int forskjellige = 0;
        for(int i = 0; i <= 25; i++){
            if (antallTegn[i] > 0){
                forskjellige++;
            }
        }return forskjellige;
    }
    //metode for alle bokstaver totalt. abbbc = 5 bokstaver. 
    public int totBOKSTAVER(){
        return totalBokstaver;
    }
    //metode Prosent av tekst er IKKE bokstaver
    public double ikkeBokstaver(){
        int totaltALT = totalBokstaver + antallTegn[26];
        return ((double)antallTegn[26]/totaltALT)*100;
    }
    //metode bokstavforekomster
    public int BokstavForekomster(char bokstav){
        if(bokstav >= 'a' && bokstav <= 'z'){
            return antallTegn[bokstav - 'a'];
        }return 0;
    }
    //metode Hvilke bokstav forekommer oftest. Bokstaver om flere like mye
    public char oftestBokstav(){
        char oftestTegn = ' ';
        int gangerTegnVist = 0;

        for(char ch = 'a'; ch <= 'z'; ch++){
            int count = BokstavForekomster(ch);
            if(count > gangerTegnVist){
                System.out.println(ch + ":" + count);
                gangerTegnVist = count;
                oftestTegn = ch;
            }
        }
        return oftestTegn;
    }

    public static void main(String[] args){
        Scanner myScan = new Scanner(System.in);

        while(true){
            System.out.println("\nSkriv inn en tekst: ");
            String tekst = myScan.nextLine();
    
            tekstAnalyse obj1 = new tekstAnalyse(tekst);

            System.out.println("Antall ulike bokstaver brukt: "+obj1.ulikeBOKSTAVER());
            System.out.println("Totalt antall bokstaver: "+obj1.totBOKSTAVER());
            System.out.println("Prosent av ikke-bokstaver brukt: "+obj1.ikkeBokstaver()+"%");
            System.out.println("Oftest bokstav: "+obj1.oftestBokstav());
    
            System.out.println("Skriv inn bokstaven du ønsker vite hvor mange ganger forekom: ");
            char tegn = myScan.nextLine().charAt(0); //jukser til med nextLine() som egt. beregnet for String
            System.out.println("Forekommelser av "+tegn+": "+obj1.BokstavForekomster(tegn));
        }
    }

    
}
