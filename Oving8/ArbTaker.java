package Oving8;

//import java.time.LocalDate;
import java.util.GregorianCalendar;

public class ArbTaker {
    GregorianCalendar kalender = new GregorianCalendar();
    int naatidAar = kalender.get(java.util.Calendar.YEAR);

    //declerating instance variable/attributes
    private Person personalia;
    private int arbtakernr;
    private int ansettelseaar;
    private double maanedslonn;
    private double skatteprosent;

    //constructor 
    public ArbTaker(Person personalia, int arbtakernr, int ansettelseaar, int maanedslonn, double skatteprosent){
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelseaar = ansettelseaar;
        this.maanedslonn = maanedslonn;
        this.skatteprosent = skatteprosent;

    }

    //getters og setters
    //Slett de du ikke bruker! 
    public Person getPersonalia(){
        return personalia;
    }
    public void setPersonalia(Person personalia) {
        this.personalia = personalia;
    }
    public int getArbtakernr() {
        return arbtakernr;
    }
    public void setArbtakernr(int arbtakernr) {
        this.arbtakernr = arbtakernr;
    }
    public int getAnsettelseaar() {
        return ansettelseaar;
    }
    public void setAnsettelseaar(int ansettelseaar) {
        this.ansettelseaar = ansettelseaar;
    }
    public double getMaanedslonn() {
        return maanedslonn;
    }
    public void setMaanedslonn(int maanedslonn) {
        this.maanedslonn = maanedslonn;
    }
    public double getSkatteprosent() {
        return skatteprosent;
    }
    public void setSkatteprosent(double skatteprosent) {
        this.skatteprosent = skatteprosent;
    }
    
    //methods
    public double ArbtkrSkattetrekk(){
        return (getMaanedslonn() * (getSkatteprosent()/100));
    }
    public double bruttolonn(){
        return getMaanedslonn() * 12;
    }
    public double skattetrekk(){
        return (ArbtkrSkattetrekk() * 12) - ArbtkrSkattetrekk() + (ArbtkrSkattetrekk()/2);
    }
    public String PersonaliaNavn() {
        return personalia.getEtternavn() + ", " + personalia.getFornavn();
    }
    public int PeronaliaAlder(){
        return naatidAar - personalia.getFodselsaar();
    }
    public int antallAar(){
        return naatidAar - getAnsettelseaar();
    }
    public boolean OverVistAar(int aar){
        if(aar > (naatidAar - getAnsettelseaar())){
            return true;
        }
        return false;
    }  
}
