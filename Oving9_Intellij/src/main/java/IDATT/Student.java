package IDATT;

public class Student {
  //deklarere objektvariabler/attribute/insantsevariabel
  private String navn;
  private int antOppg;

  /**
   * Parameter
   * @param navn gir navnet til objektet. Studenten starten med 0 oppgaveinnleveringer.
   */
  public Student(String navn){ //kan fjerne int antOppg
    if (navn == null || navn.isEmpty()) {
      throw new IllegalArgumentException("Mangler navn");
    }
    this.navn = navn;
    this.antOppg = 0; //Om det gis en parameterverdi er dette greit, hvis ikke bør -> this.antOppg = 0
  }

  /**
   * Getter
   * @return navn til student
   */
  public String getNavn() {
    return navn;
  }
  public int getAntOppg() {
    return antOppg;
  }

  //metoder
  public void økAntOppg(int økning){
    this.antOppg += økning;
  }

  @Override
  public String toString(){
    return navn + " har levert " + antOppg + " antall oppgaver.";
  }

  //testprogram
  public static void main(String[] args){
    Student student = new Student("Ingve");
    System.out.println("\nTre tester totalt: ");

    String navn = student.getNavn();
    if (navn.equalsIgnoreCase("Ingve")) {
      System.out.println("Test1 vellykket");
    }

    int antOppg1 = student.getAntOppg();
    if (antOppg1 == 0){
      System.out.println("Test2 vellykket");
    }

    student.økAntOppg(5);
    int antOppg2 = student.getAntOppg();
    if (antOppg2 == 5){
      System.out.println("Test3 vellykket");
    }

  }

}