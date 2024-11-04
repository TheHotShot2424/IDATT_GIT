import java.util.Objects;

public class Fag implements Comparable<Fag> {
    private final String fagkode;
    private final String fagnavn;
    private int antStud;

    public Fag(String fagkode, String fagnavn) {
        if (fagkode == null || fagkode.trim().equals("")|| fagnavn == null || fagkode.trim().equals("")) {
            throw new IllegalArgumentException("Fagkode og fagnavn må oppgis.");
        }
        this.fagkode = fagkode.trim();
        this.fagnavn = fagnavn.trim();
        antStud = 0;
    }

    public String getFagkode() {
        return fagkode;
    }

    public String getFagnavn() {
        return fagnavn;
    }

    public int getAntStud() {
        return antStud;
    }

    public void setAntStud(int antStud) {
        this.antStud = antStud;
    }

    @Override
    public int compareTo(Fag o) {
        return fagkode.compareTo(o.getFagkode());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fag fag = (Fag) o;
        return getFagkode().equals(fag.getFagkode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFagkode());
    }

    @Override
    public String toString() {
        return "Fag{" +
                "fagkode='" + fagkode + '\'' +
                ", fagnavn='" + fagnavn + '\'' +
                ", antstud=" + antStud +
                '}';
    }
}
