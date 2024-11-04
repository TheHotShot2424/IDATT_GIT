import java.util.*;

/**
 *  En klasse som administrer en telefonkatalog.
 *  Vi bruker java.util.HashMap
 *  @version 27.10 2019
 *  @author Grethe
 */
public class TelephoneBookMap {
    private HashMap<String, Person> telephoneBook = new HashMap<String, Person>();

    /**
     * Konstruktør for å opprette et objekt
     * med en initiell størrelse
     * @see TelephoneBookMap()
     * @param initCapasity start størrelse på telefonkatalogen
     */
    public TelephoneBookMap(int initCapasity){
        telephoneBook = new HashMap<String, Person>(initCapasity);
    }

    /**
     * Standardkonstruktør for å opprette objekt uten å angi initiell størrelse på telefonkatalogen.
     */
    public TelephoneBookMap(){ }

    /**
     *  Metode som registrerer en ny person i telefonkatalogen
     *  metoden sjekker om personen er registrert fra f&oslash;r
     *
     * @param p person som skal legges til
     * @return true eller false for &aring; indikere om personen ble registrert
     */
    public boolean addPerson(Person p){
        if (!telephoneBook.containsValue(p)){ // forutsetter at person har implementert equals-metoden
            telephoneBook.put (p.getName(), p);  // bruker navn som nøkkel
            return true;
        }
        return false;
    }

    /**
     *
     * @return  telefonkatalogen
     */
    public HashMap<String, Person> getTelephoneBook(){
        //   return telefonkatalog;       // returnerer referansen -
        HashMap<String,Person> clone = (HashMap<String, Person>) telephoneBook.clone();
        return clone;     // returnerer en kopi
    }

    /**
     * Metoden sletter en person fra telefonkatalogen dersom den er lagret der.
     * @param p   person en ønsker å slette fra telefonkatalogen
     * @return    true/ false avhengig av om person blir slettet eller ikke
     */
    public boolean removePerson(Person p){
        return telephoneBook.remove(p.getName(),p);
    }

    /**
     *       Metode som tar inn et navn og søker gjennom telefonkatalogen om person
     *       med dette navnet er finnes.
     *
     * @param name det som skal søkes etter
     * @return funnet person eller null dersom person ikke er registrert/ funnet
     */
    public Person getPerson(String name){
        return telephoneBook.get(name);
    }

    /**
     *     Metode som tar inn et navn og søker gjennom telefonkatalogen om personen
     *     med dette finnes.
     *
     * @param name den som skal søkes etter
     * @return  dersom funnet returneres telefonnr, hvis ikke returneres -1
     */
    public int getPhoneNumber(String name){
        Person p = telephoneBook.get(name);
        if (p != null){
            return p.getPhoneNumber();
        }else return -1; // ikke funnet
    }


    /**
     *     Metode som tar inn navn på fylke og søker gjennom telefonkatalogen etter aller personer
     *     fra dette fylket
     *
     * @param county fyllke som skal søkes etter
     * @return  dersom funnet returneres alle personer fra gitt fylke, hvis ikke returneres null
     */

    public HashMap<String, Person> getAllFromCounty(String county){
        HashMap<String, Person> fromCounty = new HashMap<String, Person>();
        Iterator<Map.Entry<String, Person>> it = telephoneBook.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Person> p = it.next();
           if (p.getValue().getCounty().equals(county)) fromCounty.put(p.getValue().getName(), p.getValue());
        }
        if (fromCounty.size()>0)return fromCounty;
        else return null; // ingen funnet
    }

    /**
     *
     *
     * @return en sortert telefonkatalogkopi
     */
    public ArrayList<Person> sortTelephoneBook(){
        ArrayList<Person> copy =  new ArrayList<Person>(telephoneBook.values());
        Collections.sort(copy);
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
        Iterator iterator = telephoneBook.entrySet().iterator();
        while(iterator.hasNext()){
            res +=  (Map.Entry)iterator.next();
            if (iterator.hasNext()) res += ", ";
        }
        return res + "]";
    }
}
