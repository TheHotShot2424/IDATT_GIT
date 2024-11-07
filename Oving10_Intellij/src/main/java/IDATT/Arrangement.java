package IDATT;

public class Arrangement {
  private int nummer; //dato og klokkeslett
  private long tidspunkt;
  private String navn, sted, arrangor, type; //type - (konsert, barnetheater, foredrag etc.)

  public Arrangement(int nummer, long tidspunkt, String navn, String sted, String arrangor, String type){
    this.nummer = nummer;
    this.tidspunkt = tidspunkt;
    this.navn = navn;
    this.sted = sted;
    this.arrangor = arrangor;
    this.type = type;
  }

  public int getNummer() {
    return nummer;
  }

  public void setNummer(int nummer) {
    this.nummer = nummer;
  }

  public long getTidspunkt() {
    return tidspunkt;
  }

  public void setTidspunkt(long tidspunkt) {
    this.tidspunkt = tidspunkt;
  }

  public String getNavn() {
    return navn;
  }

  public void setNavn(String navn) {
    this.navn = navn;
  }

  public String getSted() {
    return sted;
  }

  public void setSted(String sted) {
    this.sted = sted;
  }

  public String getArrangor() {
    return arrangor;
  }

  public void setArrangor(String arrangor) {
    this.arrangor = arrangor;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  //tidspunkter
  public long aar(){
    return tidspunkt / 100_000_000;
  }
  public long maaned() {
    return (tidspunkt / 1_000_000) % 100;
  }
  public long dag() {
    return (tidspunkt / 10_000) % 100;
  }
  public long time() {
    return (tidspunkt / 100) % 100;
  }
  public long minutt(){
    return tidspunkt % 100;
  }

  public long BareDato(){
    return aar()+maaned()+dag();
  }
  public long BareTid(){
    return time()+minutt();
  }

  //methods
  @Override
  public String toString(){
    return String.format(
        "\nNavn: %s\nSted: %s\nNummer: %s\nTid: %s.%s.%s %s:%s\nArrangør: %s\n type: %s",
        navn, sted, nummer, dag(), maaned(), aar(), time(), minutt(), arrangor, type
    );
  }
}
