package IDATT;

import java.util.Arrays;
//for å lage testklasse - control + shift + t

public class tekstBehandling {
  //decleration of instance variable/attributes
  private final String EnStreng;

  //constructor
  public tekstBehandling(String streng){
    this.EnStreng = streng;
  }

  //methods
  public void valgmenydekor(){
    System.out.println("\n---------------- ");
  }

  public int antallOrd(){
    int counter = EnStreng.length();
    return counter;
  }
  public double gjennomsnittligOrdlengde(){
    String[] s = EnStreng.split("[ .]+"); //regex sier mellomrom, punktum og + tilfell "..." som blir behandlet som "."
    System.out.println("Ekstra informasjon: ");
    double snitt = 0.0;
    for(int i = 0; i < s.length; i++){
      snitt += s[i].length();
    }
    double resultat = snitt / s.length;
    return resultat;
  }
  public double ordPerPeriode(){
    String[] s = EnStreng.split("[.:!?]+"); // .split tror "." er en regex wildcard, så en må putte \\ for å få den til å skjønne det er bokstavelig talt "." vi snakker om
    double snitt = 0.0;
    for(int i = 0; i < s.length; i++){
      String ny_s = s[i].trim();
      String[] flereOrd = ny_s.split(" ");
      snitt += flereOrd.length;
    }
    double resultat = snitt / s.length;
    return resultat;
  }
  public String bytteOrd(String byttUt, String byttInn){
    String a = EnStreng;
    a = a.replace(byttUt, byttInn);
    return a;
  }
}
