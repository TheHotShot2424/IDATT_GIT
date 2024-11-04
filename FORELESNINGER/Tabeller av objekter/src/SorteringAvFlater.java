public class SorteringAvFlater {
    public static void main(String[] args) {
        Flate[] flater = {new Flate("E", 10, 5), new Flate("B", 1, 5),
                new Flate("F", 5, 5), new Flate("A", 5, 5)};

        System.out.println("Standardsortering (iht. navn)");
        Sortering.sorterObjekter(flater);
        for (int i = 0; i < flater.length; i++) {
            System.out.println(flater[i] + " Areal = " + flater[i].beregnAreal() + ".");
        }

        System.out.println("\nSortering iht. areal (med komparator)");
        Sortering.sorterObjekter(flater, new FlateKompAreal());
        for (int i = 0; i < flater.length; i++) {
            System.out.println(flater[i] + " Areal = " + flater[i].beregnAreal() + ".");
        }
    }
}
