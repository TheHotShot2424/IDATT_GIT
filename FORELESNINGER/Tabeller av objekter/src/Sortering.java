/**
 *  Klassemetoden kommer i to utgaver:
 *     sorterObjekter(Object[] objekter)
 *     sorterObjekter(Object[] objekter, Comparator comp)
 */
public class Sortering {
    /**
     * sorterer iht. objektenes naturlige orden (compareTo())
     * @param objekter
     */
    public static void sorterObjekter(Object[] objekter) {
        if (objekter != null && objekter.length > 0) {
            for (int start = 0; start < objekter.length; start++) {
                int hittilMinst = start;
                for (int i = start + 1; i < objekter.length; i++) {
                    Comparable dette = (Comparable) objekter[i];
                    Comparable hittilMinsteObjekt = (Comparable) objekter[hittilMinst];
                    if (dette.compareTo(hittilMinsteObjekt) < 0) {
                        hittilMinst = i;
                    }
                }
                Object hjelp = objekter[hittilMinst];
                objekter[hittilMinst] = objekter[start];
                objekter[start] = hjelp;
            }
        }
    }

    /**
     * Sorterer iht. sorteringsrekkefølgen gitt av en comparator.
     *  *  Algoritme: Sortering ved utvelgelse.
     * @param objekter
     * @param comp
     */
    public static void sorterObjekter(Object[] objekter, java.util.Comparator comp) {
        if (comp == null) {
            sorterObjekter(objekter);
        }
        if (objekter != null && objekter.length > 0) {
            for (int start = 0; start < objekter.length; start++) {
                int hittilMinst = start;
                for (int i = start + 1; i < objekter.length; i++) {
                    Object dette = objekter[i];
                    Object hittilMinsteObjekt = objekter[hittilMinst];
                    if (comp.compare(dette, hittilMinsteObjekt) < 0) {
                        hittilMinst = i;
                    }
                }
                Object hjelp = objekter[hittilMinst];
                objekter[hittilMinst] = objekter[start];
                objekter[start] = hjelp;
            }
        }
    }
}
