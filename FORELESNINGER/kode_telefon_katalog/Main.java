import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("/* ArrayList - utgave */");
        TelephoneBook tk = new TelephoneBook();
        tk.addPerson(new Person("Line Olsen", "Trøndelag", 98989898));
        tk.addPerson(new Person("Anita Olsen", "Viken", 89898989));
        tk.addPerson(new Person("Lina Olsen", "Viken", 98989898));
        //  tk.removePerson(new Person("Line Olsen", 30, 98989898));
        System.out.println(tk);

        ArrayList<Person> telphoneBookOrderedCopy = tk.sortTelephoneBook();
        System.out.println("Sortert kopi: " + telphoneBookOrderedCopy);
        System.out.println("Sortert kopi - comparable: " + tk.easySortPhoneBook());

        // vi lager en kopi og legger til en ny der,.
        ArrayList<Person> copy = tk.getTelephoneBook();
        copy.add(new Person("Tore Olsen", "Innlandet", 78787878));

        System.out.println("Kopi: " + copy);
        System.out.println("Orginal: " + tk);

        Person p1 = tk.getPerson("Line Olsen");
        if (p1 != null) System.out.println("P1 funnet: " + p1);
        else System.out.println("P1 ikke funnet");

        Person p2 = tk.getPerson("Trine Rein");
        if (p2 != null) System.out.println(p2);
        else System.out.println("P2 ikke funnet");

        System.out.println(" Allefra Viken: " + tk.getAllFromCounty("Viken")+ "\n\n");

        System.out.println("/* HashSet - utgave */");
        TelephoneBookSet tks = new TelephoneBookSet();
        tks.addPerson(new Person("Line Olsen", "Trøndelag", 98989898));
        tks.addPerson(new Person("Anita Olsen", "Viken", 89898989));
        tks.addPerson(new Person("Lina Olsen", "Viken", 98989898));
        System.out.println(tks);

        ArrayList<Person> telphoneBookOrderedCopySet = tks.sortTelephoneBook();
        System.out.println("Sortert kopi: " + telphoneBookOrderedCopySet);


        // vi lager en kopi og legger til en ny der,.
        HashSet<Person> copySet = tks.getTelephoneBook();
        copySet.add(new Person("Tore Olsen", "Innlandet", 78787878));

        System.out.println("Kopi: " + copy);
        System.out.println("Orginal: " + tks);

        Person p1Set= tks.getPerson("Line Olsen");
        if (p1Set != null) System.out.println("P1 funnet: " + p1Set);
        else System.out.println("P1 ikke funnet");

        Person p2Set = tks.getPerson("Trine Rein");
        if (p2Set != null) System.out.println(p2Set);
        else System.out.println("P2 ikke funnet");
        System.out.println("Alle fra Viken: " + tks.getAllFromCounty("Viken")+ "\n\n");

        System.out.println("/* HashMap - utgave */");
        TelephoneBookMap tkm = new TelephoneBookMap();
        tkm.addPerson(new Person("Line Olsen", "Trøndelag", 98989898));
        tkm.addPerson(new Person("Anita Olsen", "Viken", 89898989));
        tkm.addPerson(new Person("Lina Olsen", "Viken", 98989898));
        System.out.println(tkm);

        List<Person> telphoneBookOrderedCopyMap = tkm.sortTelephoneBook();
        System.out.println("Sortert kopi " + telphoneBookOrderedCopyMap);


        // vi lager en kopi og legger til en ny der,.
        HashMap<String, Person> copyMap = tkm.getTelephoneBook();
        copyMap.put("Tore Olsen", new Person("Tore Olsen", "Innlandet", 78787878));

        System.out.println("Kopi: " + copy);
        System.out.println("Orginal: " + tkm);

        Person p1Map= tkm.getPerson("Line Olsen");
        if (p1Map != null) System.out.println("P1 funnet: " + p1Map);
        else System.out.println("P1 ikke funnet");

        Person p2Map = tkm.getPerson("Trine Rein");
        if (p2Map != null) System.out.println(p2Map);
        else System.out.println("P2 ikke funnet");
        System.out.println("Alle fra Viken: " + tkm.getAllFromCounty("Viken")+ "\n\n");
    }
}
