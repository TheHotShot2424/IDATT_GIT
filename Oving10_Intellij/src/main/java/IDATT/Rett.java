package IDATT;

public class Rett {
  private String navn;
  private String type;
  private double pris;

  public Rett(String navn, String type, double pris){
    this.navn = navn;
    this.type = type;
    this.pris = pris;
  }

  public String getNavn(){
    return navn;
  }
  public void setNavn(){
    this.navn = navn;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getPris() {
    return pris;
  }

  public void setPris(double pris) {
    this.pris = pris;
  }

  @Override
  public String toString(){
    return String.format("\n%s - %s - Pris %.2f,-",
        navn,type,pris);
  }
}
