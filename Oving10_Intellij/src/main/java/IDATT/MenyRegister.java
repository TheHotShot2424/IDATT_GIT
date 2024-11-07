package IDATT;

import java.util.ArrayList;
import java.util.List;

public class MenyRegister {
  //declaring attribute/instance variable/object
  private ArrayList<ArrayList<Rett>> matretter;  //en arrayList i en arrayList for å få meny av ulike retter

  //constructor
  public MenyRegister(){
    matretter = new ArrayList<>();
  }

  //getter setter
  public ArrayList<ArrayList<Rett>> getMatretter() {
    return matretter;
  }
  public void setMatretter(ArrayList<ArrayList<Rett>> matretter) {
    this.matretter = matretter;
  }

  //metoder
  public void registrerMeny(ArrayList<Rett> meny){
    matretter.add(meny);
  }
  public List<Rett> finneRettGittNavn(String navn){
    return matretter.stream().
        flatMap(ArrayList::stream) //flatten til ArrayList<Rett>, slik at vi jobber med kun Retter-objekter. Kan skrives (m) -> m.stream() også.
        .filter( (r) -> r.getNavn().equalsIgnoreCase(navn))
        .toList();
  }
  public List<Rett> finneAlleRettGittType(String type){
    return matretter.stream().
        flatMap(ArrayList::stream)
        .filter( (r) -> r.getType().equalsIgnoreCase(type))
        .toList();
  }
  public double sumAlleRetter(){
    return matretter.stream()
        .flatMap( (m) -> m.stream()) //bruker flatMap for å kollapse alt til én stream, til kun ett element om nødvendig
        .mapToDouble(Rett::getPris)
        .sum();
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("*******Meny*******");
    for(ArrayList<Rett> meny : matretter){
      sb.append("\n");
      for(Rett rett : meny){
        sb.append(rett);
      }
    }
    return sb.toString();
  }

}
