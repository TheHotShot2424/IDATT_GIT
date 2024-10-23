package IDATT;

public class Person {
  //decleration instance variable/attributes
  private final String fornavn;
  private final String etternavn;
  private final int fodselsaar;

  //constructor
  public Person(String fornavn, String etternavn, int fodselsaar){
    this.fornavn = fornavn;
    this.etternavn = etternavn;
    this.fodselsaar = fodselsaar;
  }

  //-------methods-------
  //getters
  public String getFornavn() {
    return fornavn;
  }
  public String getEtternavn() {
    return etternavn;
  }
  public int getFodselsaar() {
    return fodselsaar;
  }
}
