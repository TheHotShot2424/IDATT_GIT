package IDATT;

import java.util.ArrayList;

public class Meny extends MenyRegister {
  private ArrayList<Rett> meny;

  public Meny(){
    meny = new ArrayList<>();
  }

  //getter setter
  public ArrayList<Rett> getMeny(){
    return meny;
  }
  public void setMeny(ArrayList<Rett> meny){
    this.meny = meny;
  }

  //metoder
  public void registerRett(String navn, String type, double pris){
    Rett reg = new Rett(navn,type,pris);
    meny.add(reg);
  }

}
