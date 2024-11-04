package IDATT;

import java.util.ArrayList;

public class Oppgaveoversikt {
  private ArrayList<Student> studenter;
  private int antStud = 0;

  /**
   * Parameter som lager array når den lages
   */
  public Oppgaveoversikt(){
    this.studenter = new ArrayList<Student>();
  }

  public int getAntStud(){
    return antStud;
  }
  public int StudentOppgaver(String name){
    return studenter.stream()
        .filter((student) -> student.getNavn().equals(name))
        .mapToInt(Student::getAntOppg)
        .sum(); //reduserer getAntOppg til kun en sum
  }
  public void nyStudent(String navn){
    Student nyStudent = new Student(navn);
    studenter.add(nyStudent);
    antStud++;
  }
  public void økStudentOppgave(String navn, int økning){
    studenter.stream()
        .filter(student -> student.getNavn().equals(navn))
        .forEach(student -> student.økAntOppg(økning)); //kan ikke bruke .map for den forventer å få returned noe tilbake, hvor den transformerer streamen til noe. Men forEach jobber med void-metoder derimot.
  }

  @Override
  public String toString(){
    return "Studeenter: " + studenter + "\nAntall studenter: " + antStud;
  }
}
