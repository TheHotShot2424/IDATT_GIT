package IDATT;

import java.util.Scanner;

public class TekstAnalyse {
  //declarating instance variable/attribute/object variable?
  private int[] antallTegn = new int[27]; //[0,0,...,0] for alfabetet
  private int totalBokstaver;

  //constructor
  //vi vil ta hver char i strengen og legge dennes plass i alfabetet inn i antallTegn array:
  public TekstAnalyse(String tekst){
    for(int i = 0; i < tekst.length(); i++){ //string bruker .length()
      char tegn = tekst.charAt(i);
      if(tegn >= 'a' && tegn <= 'z'){
        antallTegn[tegn - 'a']++;
        totalBokstaver++;
      }
      else{
        antallTegn[26]++;
      }
    }
  }

  //methods
  //"aaabbcccc" gir "abc" ulike bokstaver:
  public int ulikeBokstaver(){
    int ulike = 0; //initialize
    for(int i = 0; i <= 25; i++){
      if(antallTegn[i] > 0){ //sjekke om den ikke er tom
        ulike++;
      }
    }
    return ulike;
  }
  //"aaabbbccc" gir totalt 9 bokstaver:
  public int getTotalBokstaver(){
    return totalBokstaver;
  }
  //prosent av tegn som ikke er bokstaver:
  public double annetTegnProsent(){
    int totaltAlt = getTotalBokstaver() + antallTegn[26];
    return (double)(antallTegn[26] / totaltAlt)*100;
  }
  //hvor ofte bokstav forekommer:
  public int Bokstavforekomst(char bokstav){
      return (bokstav >= 'a' && bokstav <= 'z') ? antallTegn[bokstav-'a'] : 0;
  }
  //hvilken bokstav forekommer oftest:
  public char oftestBokstav(){
    char oftestTegn = ' ';
    int gangerVist = 0;

    for(char ch = 'a'; ch < 'z'; ch++){ //innebygd java-funksjon å iterere over alfabetet
      int count = Bokstavforekomst(ch);
      if(count > gangerVist){
        gangerVist = count;
        oftestTegn = ch;
      }
    }
    return oftestTegn;
  }

}
