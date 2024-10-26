package IDATT;

//for å lage testklasse - control + shift + t

public class tekstBehandling {
  //decleration of instance variable/attributes
  private final String EnStreng;

  //constructor
  public tekstBehandling(String streng){
    this.EnStreng = streng;
  }

  //methods
  public void valgmenydekor(){  // bare for å teste
    System.out.println("\n---------------- ");
  }

  public int antallOrd(){
    return EnStreng.length(); // teller hver bokstav og tegn
  }
  public double gjennomsnittligOrdlengde(){
    String[] s = EnStreng.split("[ .]+"); //regex sier mellomrom, punktum og + tilfell "..." som blir behandlet som ".". {En,mann,går,der}
    System.out.println("Ekstra informasjon: ");
    double snitt = 0.0;
    for(int i = 0; i < s.length; i++){
      snitt += s[i].length(); // {En,...} -> .length() teller lengde av element 0 i array, altså lengde av ordet.
    }
    double resultat = snitt / s.length;
    return resultat;
  }
  public double ordPerPeriode(){
    String[] s = EnStreng.split("[.:!?]+"); // .split tror "." er en regex wildcard, så en må putte \\ for å få den til å skjønne det er bokstavelig talt "." vi snakker om
    double snitt = 0.0;
    for(int i = 0; i < s.length; i++){
      String ny_s = s[i].trim(); // {Hei, Tja, alt bra da} har mellomrom enda som også telles som "char". De trimmes og vi tar vanlig strenger ut.
      String[] flereOrd = ny_s.split(" "); // tar tilbake strengene og legges i ny array {Hei}, {Tja}, {alt,bra,da}
      snitt += flereOrd.length; //finn lengden av hver array
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
