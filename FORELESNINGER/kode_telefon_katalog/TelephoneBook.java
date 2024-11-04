import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
     *  En klasse som administrer en telefonkatalog.
    *  Vi bruker java.util.ArrayList
     *  @version 27.10 2019
     *  @author Grethe
     */
    public class TelephoneBook {
        private ArrayList<Person> telephoneBook = new ArrayList<Person>();

        /**
         * Konstruktør for å opprette et objekt
         * med en initiell størrelse
         * @see TelephoneBook()
         * @param initCapasity start størrelse på telefonkatalogen
         */
        public TelephoneBook(int initCapasity){
            telephoneBook = new ArrayList<Person>(initCapasity);
        }

        /**
         * Standardkonstruktør  for å opprette objekt uten å angi initiell størrelse på telefonkatalogen.
         */
        public TelephoneBook(){ }

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
        public ArrayList<Person> getTelephoneBook(){
            //   return telefonkatalog;       // returnerer referansen -
            return (ArrayList<Person>) telephoneBook.clone();     // returnerer en kopi
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
         *
         * @param name dte som skla søkes etter
         * @return funnet person eller null dersom person ikke er registrert/ funnet
         */
        public Person getPerson(String name){
            for(Person p: telephoneBook){
                if (p.getName().equals(name)){
                    return p;
                }
            }
            return null; // Person ikke funnet
        }

        /**
         *     Metode som tar inn et navn og søker gjennom telefonkatalogen om personen
         *     med dette finnes.
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

    public ArrayList<Person> getAllFromCounty(String county){
            ArrayList<Person> fromCounty = new ArrayList<Person>();
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
            ArrayList<Person> telephoneBookCopy = (ArrayList<Person>)telephoneBook.clone();
            telephoneBookCopy.trimToSize();
            for(int i=0; i<telephoneBookCopy.size(); i++){
                int soFarLowest = i;
                for(int j=soFarLowest; j<telephoneBookCopy.size(); j++){
                    if (telephoneBookCopy.get(soFarLowest).getName().compareTo(telephoneBookCopy.get(j).getName())>0){
                        soFarLowest = j;
                    }
                }
                // bytt plass på i og soFarLowest
                Person tmp = new Person (telephoneBookCopy.get(soFarLowest).getName(), telephoneBookCopy.get(soFarLowest).getCounty(), telephoneBookCopy.get(soFarLowest).getPhoneNumber());
                telephoneBookCopy.set(soFarLowest, telephoneBookCopy.get(i));
                telephoneBookCopy.set(i, tmp);
            }
            return telephoneBookCopy;
        }

        /**
         *  Metode som lager en kopi av telefonkatalogen og sorterer denne.
         *
         * @return en sortert telefonkatalogkopi
         */
       public ArrayList<Person> easySortPhoneBook(){
        ArrayList<Person> telephoneBookCopy = (ArrayList<Person>)telephoneBook.clone();
        telephoneBookCopy.trimToSize();
        Collections.sort(telephoneBookCopy);
        return telephoneBookCopy;
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
