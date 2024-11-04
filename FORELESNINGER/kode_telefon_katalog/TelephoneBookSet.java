import java.util.*;

/**
 *  En klasse som administrer en telefonkatalog.
 *  Vi bruker java.util.HashSet
 *  @version 27.10 2019
 *  @author Grethe
 */
public class TelephoneBookSet {
    private HashSet<Person> telephoneBook = new HashSet<Person>();

    /**
     * Konstruktør for å opprette et objekt
     * med en initiell størrelse
     * @see TelephoneBookSet()
     * @param initCapasity start størrelse på telefonkatalogen
     */
    public TelephoneBookSet(int initCapasity){
        telephoneBook = new HashSet<Person>(initCapasity);
    }

    /**
     * Standardkonstruktør  for å opprette objekt uten å angi initiell størrelse på telefonkatalogen.
     */
    public TelephoneBookSet(){ }

    /**
     *  Metode som registrerer en ny person i telefonkatalogen
     *  metoden sjekker om personen er registrert fra f&oslash;r
     *
     * @param p person som skal legges til
     * @return true eller false for &aring; indikere om personen ble registrert
     */
    public boolean addPerson(Person p){
        if (!telephoneBook.contains(p)){ // forutsetter at person har implementert equals-metoden
            telephoneBook.add(p);
            return true;
        }
        return false;
    }

    /**
     *
     * @return  telefonkatalogen
     */
    public HashSet<Person> getTelephoneBook(){
        //   return telefonkatalog;       // returnerer referansen -
        return (HashSet<Person>) telephoneBook.clone();     // returnerer en kopi
    }

    /**
     * Metoden sletter en person fra telefonkatalogen dersom den er lagret der.
     * @param p   person en ønsker å slette fra telefonkatalogen
     * @return    true/ false avhengig av om person blir slettet eller ikke
     */
    public boolean removePerson(Person p){

        return telephoneBook.remove(p);
    }

    /**
     *       Metode som tar inn et navn og søker gjennom telefonkatalogen om person
     *       med dette navnet er finnes.
     *       Bruker Iterator for å gjennon listen
     *
     * @param name det som skal søkes etter
     * @return funnet person eller null dersom person ikke er registrert/ funnet
     */
    public Person getPerson(String name){
        Iterator<Person> iterator = telephoneBook.iterator();
        while(iterator.hasNext()){
            Person p = (Person)iterator.next();
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null; // Person ikke funnet
    }
    /**
     *     Metode som tar inn et navn og søker gjennom telefonkatalogen om personen
     *     med dette finnes.
     *     Bruker her utvidet for-løkke (foreach) for å iterere gjennom elementene
     *
     * @param name den som skal søkes etter
     * @return  dersom funnet returneres telefonnr, hvis ikke returneres -1
     */
    public int getPhoneNumber(String name){
        for(Person p: telephoneBook){
            if (p.getName().equals(name)){
                return p.getPhoneNumber(); // funnet - returnerer telefonnr
            }
        }
        return -1; // ikke funnet
    }
    /**
     *     Metode som tar inn navn på fylke og søker gjennom telefonkatalogen etter aller personer
     *     fra dette fylket
     *
     * @param county fyllke som skal søkes etter
     * @return  dersom funnet returneres alle personer fra gitt fylke, hvis ikke returneres null
     */

    public HashSet<Person> getAllFromCounty(String county){
        HashSet<Person> fromCounty = new HashSet<Person>();
        Iterator<Person> iterator = telephoneBook.iterator();
        while(iterator.hasNext()){
            Person p = iterator.next();
            if (p.getCounty().equals(county)) fromCounty.add(p);
        }
        if (fromCounty.size()>0)return fromCounty;
        else return null; // ingen funnet
    }

    /**
     *  Metode som lager en kopi av telefonkatalogen og sorterer denne.
     *
     * @return en sortert telefonkatalogkopi
     */
    public ArrayList<Person> sortTelephoneBook(){
        HashSet<Person> telephoneBookCopy = (HashSet<Person>)telephoneBook.clone();
        /* For å finne orden i elementene må vi gå via en List - da hashset ikke har naturlig orden..) */
        ArrayList<Person> copy = new ArrayList<Person>(telephoneBookCopy);
        Collections.sort(copy);
        Iterator<Person> telephoneBookCopyIterator = telephoneBookCopy.iterator();
        return copy;
    }

    /**
     *  Metode som generer informasjon om objektet
     *
     * @return informasjon om objektet
     */
    @Override
    public String toString() {
        String res = "[";
        for (Person p : telephoneBook){
            res += p + ", ";
        }
        return res + "]";
    }
}
