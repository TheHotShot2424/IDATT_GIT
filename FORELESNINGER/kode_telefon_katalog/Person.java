import java.util.Objects;

/**
 * En klasse som representerer en Person.
 * @version 0.01 2019
 * @author Grethe
 */
public class Person implements Comparable<Person>{
    private String name;
    private String county;
    private int phoneNumber;

    /**
     *  Konstruktør
     * @param name Navnet på en person
     * @param county Fylke personen hører til
     * @param phoneNumber Personens telefonnummer
     */
    public Person(String name, String county, int phoneNumber){
        this.name = name;
        this.county = county;
        this.phoneNumber = phoneNumber;
    }

    /**
     *
     * @return returner navnet til personen
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return Returnerer personens tilhørssted
     */
    public String getCounty(){
        return county;
    }

    /**
     *
     * @return  returnerer personens tlfnr
     */
    public int getPhoneNumber(){
        return phoneNumber;
    }

    /**
     *
     * @param newValue nytt område for person
     */
    public void setCounty(String newValue){
        county = newValue;
    }

    /**
     *
     * @param newValue Legg inn nytt/ endret telefonnummer for personen
     */
    public void setPhoneNumber(int newValue){
        phoneNumber = newValue;
    }

    /**
     * Metoden sjekker likhet: To personer er like dersom navnene er like
     * identisklikhet - to referanser til samme objekt
     * innholdslikethet - to objekters innhold sammenlignes.
     *
     * @param obj det vi sammenligner med
     * @return returner true hvis likhet, false ved ulikhet
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj instanceof Person){
            Person tmp = (Person)obj;
            return this.getName().equals(tmp.getName());
        }
        return false;
    }
    /**
     * Metoden sjekker to personers naturlige orden: To personer er like dersom navnene er like,
     * størrelse avhenger av alfabetisk plassering
     *
     * this.name = name: returneres 0
     *
     * this.name < theOther.name. returneres 1
     *
     * this.name > theOther.name: return -1
     *
     * brukes for å kunne sortere personer alfabetisk på navn
     *
     * @param otherPerson det vi sammenligner med
     * @return returner true hvis likhet, false ved ulikhet
     */
  public int compareTo(Person otherPerson){
        return this.getName().compareToIgnoreCase(otherPerson.getName());
    }

    /**
     * Returnerer på formen name age phoneNumber
     * ....
     * ,,,
     * @return innholdet av informasjon som er registrert om en person
     */
    @Override
    public String toString(){
        return name + " " + county + " " + phoneNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhoneNumber());
    }
}
