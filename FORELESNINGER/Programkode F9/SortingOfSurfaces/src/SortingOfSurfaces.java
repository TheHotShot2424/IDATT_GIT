// Dette prosjektet inneholder 3 stk klasser: Surface, Sorting, Sorting OfSurfaces

/* Surface.java
 * Klassen Surface tilbyr metoder for beregning av area og circumference.
 */
class Surface implements Comparable<Surface> {
    private final String name;  // til identifikasjon
    private final double length;
    private final double with;
    public final static double TOLERANCE = 0.001;
    private final static java.text.Collator KOLLATOR = java.text.Collator.getInstance();

    // Konstruktøren kaster IllegalArgumentException hvis ugyldige argumenter.
    public Surface(String name, double length, double with)
            throws IllegalArgumentException {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Surfacen sitt navn må være oppgitt.");
        }
        if (length <= 0.0 || with <= 0.0) {
            throw new IllegalArgumentException(
                    "Både lengde og bredde må være positive tall.\n" +
                            "Inndata til konstruktøren var: lengde = " + length + ", bredde = " + with);
        }
        this.name = name;
        this.length = length;
        this.with = with;
    }

    // get metoder
    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }

    public double getWith() {
        return with;
    }

    // beregningsmetoder
    public double calculateArea() {
        return length * with;
    }

    public double calculateCircumference() {
        return 2.0 * (length + with);
    }

    public int compareTo(Surface theOther) {
        return KOLLATOR.compare(name, theOther.name);
    }

    // To flater defineres som identiske hvis de har samme navn.
    public boolean equals(Object theOther) {
        if (!(theOther instanceof Surface)) {
            return false;  // RETUR. Raskt uthopp hvis feil objekttype.
        }
        if (this == theOther) {
            return true;  // RETUR. Raskt uthopp hvis samme objekt.
        }
        return compareTo((Surface) theOther) == 0; // konsistens med compareTo()
    }

    // toString
    public String toString() {
        java.util.Formatter f = new java.util.Formatter();
        f.format("Surface: %s, bredde: %.2f m, lengde: %.2f m.", name, with, length);
        return f.toString();
    }
}

    /* Sorting.java
     * Klassemetoden kommer i to utgaver:
     *      sorterObjekter(Object[] objekter)
     *      sorterObjekter(Object[] objekter, Comparator comp)
     * der den første sorterer iht. objektenes naturlige orden (compareTo()),
     * og den andre sorterer iht. sorteringsrekkefølgen gitt av en comparator.
     * Algoritme: Sortering ved utvelgelse.
     */
    class Sorting {
        public static void sortObjects(Object[] objects) {
            if (objects != null && objects.length > 0) {
                for (int start = 0; start < objects.length; start++) {
                    int leastSoFar = start;
                    for (int i = start + 1; i < objects.length; i++) {
                        Comparable thisObject = (Comparable) objects[i];
                        Comparable leastObjectSoFar = (Comparable) objects[leastSoFar];
                        if (thisObject.compareTo(leastObjectSoFar) < 0) {
                            leastSoFar = i;
                        } // end if
                    } // end for2
                    Object help = objects[leastSoFar];
                    objects[leastSoFar] = objects[start];
                    objects[start] = help;
                } // end for1
            } // end if
        } // end SortObjects naturlig orden

        public static void sortObjects(Object[] objects, java.util.Comparator comp) {
            if (comp == null) {
                sortObjects(objects);
            }
            if (objects != null && objects.length > 0) {
                for (int start = 0; start < objects.length; start++) {
                    int leastSoFar = start;
                    for (int i = start + 1; i < objects.length; i++) {
                        Object thisObject = objects[i];
                        Object leastObjectSoFar = objects[leastSoFar];
                        if (comp.compare(thisObject, leastObjectSoFar) < 0) {
                            leastSoFar = i;
                        }
                    }
                    Object help = objects[leastSoFar];
                    objects[leastSoFar] = objects[start];
                    objects[start] = help;
                }
            }
        }
    } // end Sorting

    // SurfaceKompArea.java. Komparator for klassen Surface der arealet sammenlignes.
    class SurfaceKompArea implements java.util.Comparator<Surface> {
        public final static double TOLERANCE = 0.001;
        public int compare(Surface surface1, Surface surface2) {
            double area1 = surface1.calculateArea();
            double area2 = surface2.calculateArea();
            if (Math.abs(area2 - area1) < TOLERANCE) {
                return 0;
            } else if (area1 < area2) {
                return -1;
            } else {
                return 1;
            }
        } // end compare
    } // SurfaceKompArea

/* SortingOfSurfaces.java
* Prøver sorteringsmetodene på en tabell av Surface-objekter */
    public class SortingOfSurfaces {
        public static void main(String[] args) {
            Surface[] surface = {new Surface("E", 10, 5), new Surface("B", 1, 5),
                    new Surface("F", 5, 5), new Surface("A", 5, 5),
                    new Surface("K", 25, 10), new Surface("C", 3, 2)};
            System.out.println("Standardsortering (iht. navn)");
            Sorting.sortObjects(surface);
            for (int i = 0; i < surface.length; i++) {
                System.out.println(surface[i] + " Areal = " + surface[i].calculateArea() + ".");
            }

            System.out.println("\nSortering iht. areal (med komparator)");
            Sorting.sortObjects(surface, new SurfaceKompArea());
            for (int i = 0; i < surface.length; i++) {
                System.out.println(surface[i] + " Areal = " + surface[i].calculateArea() + ".");
            }
        } // End main
    } // SortingOfSurfaces



/* Utskrift:
Standardsortering (iht. navn)
Flate: A, bredde: 5,00 m, lengde: 5,00 m. Areal = 25.0.
Flate: B, bredde: 5,00 m, lengde: 1,00 m. Areal = 5.0.
Flate: E, bredde: 5,00 m, lengde: 10,00 m. Areal = 50.0.
Flate: F, bredde: 5,00 m, lengde: 5,00 m. Areal = 25.0.

Sortering iht. areal (med komparator)
Flate: B, bredde: 5,00 m, lengde: 1,00 m. Areal = 5.0.
Flate: A, bredde: 5,00 m, lengde: 5,00 m. Areal = 25.0.
Flate: F, bredde: 5,00 m, lengde: 5,00 m. Areal = 25.0.
Flate: E, bredde: 5,00 m, lengde: 10,00 m. Areal = 50.0.
*/

/**  Testdatasett for å teste klassen Surface
    public static void main(String[] args) {
        final double TOLERANSE = 0.001;
        System.out.println("Totalt antall tester: 4");
        Surface s1 = new Surface("A", 12.5, 7.3); // areal 91,25 - omkrets 39,6
        if (Math.abs(s1.beregnAreal() - 91.25) < TOLERANSE) {
            System.out.println("Surface: Test 1 vellykket");
        }
        if (Math.abs(f1.beregnOmkrets() - 39.6) < TOLERANSE) {
            System.out.println("Surface: Test 2 vellykket");
        }
        Surface s2 = new Surface("A", 20.5, 43);
        if (s1.equals(s2)) {  // likhet - samme navn (ulike ellers, men det registreres ikke)
            System.out.println("Surface: Test 3 vellykket");
        }
        Surface s3 = new Surface("B", 20.5, 43);
        if (!s2.equals(s3)) {  // ulikhet
            System.out.println("Surface: Test 4 vellykket");
        }
    }
}   */