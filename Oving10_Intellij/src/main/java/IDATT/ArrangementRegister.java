package IDATT;

import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrangementRegister {
  private ArrayList<Arrangement> arrangementene;

  /**
   * Konstruktør som lager arrayList når den kalles
   */
  public ArrangementRegister(){
    arrangementene = new ArrayList<Arrangement>();
  }

  //getters setters
  public ArrayList<Arrangement> getArrangementene() {
    return arrangementene;
  }

  public void setArrangementene(ArrayList<Arrangement> arrangementene) {
    this.arrangementene = arrangementene;
  }


  //metoder
  public void registereNyttArrangement(Arrangement arrangement){
    arrangementene.add(arrangement);
  }
  public List<Arrangement> finneAlleArrGittSted(String sted){
    return arrangementene.stream()
        .filter((arr) -> arr.getSted().equalsIgnoreCase(sted))
        .collect(toList());
  }
  public List<Arrangement> DatoTidspunkt(long datoFor){
    return arrangementene.stream()
        .filter((d) -> d.getTidspunkt() == datoFor)
        .collect(Collectors.toList());
  }
  public List<Arrangement> DatoTidspunkt(long datoFor, long datoEtter){
    return arrangementene.stream()
        .filter((d) -> d.getTidspunkt() <= datoEtter && d.getTidspunkt() >= datoFor)
        .collect(Collectors.toList());
  }

  //comparator-metoder:
  public List<Arrangement> SortertArr(Sorteringskriteria kriterie){
    Comparator<Arrangement> comp = comparator(kriterie); //Bruker comparitor-metoden inn her

    return arrangementene.stream()
        .sorted(comp) //vil aldri bli null
        .collect(Collectors.toList());
  }
  private Comparator<Arrangement> comparator(Sorteringskriteria kriterie){
    switch (kriterie){
      case STED: return Comparator.comparing(Arrangement::getSted);
      case DATO: return Comparator.comparing(Arrangement::BareDato);
      case TID: return Comparator.comparing(Arrangement::BareTid);
    }
    return null; //må ha denne her fordi metoden krever det. Kommer aldri hit.
  }
  /**
   * Bruker enum når trenger variabler som er public, static og final. De endres aldri.
   */
  public enum Sorteringskriteria{
    STED,
    DATO,
    TID
  }

  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    for(Arrangement ar : arrangementene){
      sb.append(ar + "\n");
    }
    return sb.toString();
  }
}
