/*
Prisberegning.java
Inneholder klassen Vare og Prisberegning 
-------
varenavn
varenr
pris  (per kilo uten mva)
---------------------
finn pris for et gitt antall kilo uten moms
finn pris for et gitt antall kilo med moms
sett ny pris
*/

class Vare{

	public static final double MOMS = 24.0;
	public static final double MOMSFAKTOR = 1.0 + MOMS/100;
	
	private final String varenavn;
	private final int varenr;
	private double pris;  // per kilo uten mva
	

	// konstruktører
	public Vare(String varenavn, int varenr, double pris){
		this.varenavn = varenavn;
		this.varenr = varenr;
		this.pris = pris;
	}

	public Vare(String varenavn, int varenr pris){
		this.varenavn = varenavn;
		this.varenr = varenr;
		this.pris = 0.0;
	}


	// metoder

	public String getVarenavn(){
		return varenavn;
	}

	public int getVarenr(){
		return varenr;
	}

	public double getPris(){
		return pris;
	}


	public double finnPrisUMva(double antKg){
		double p = pris * antKg;
		return p;
	}

	public double finnPrisMMva(double antKg){
			double p = pris * antKg * MOMSFAKTOR;
			return p;
	}

	public void settPris(double nyPris){
		pris = nyPris;
	}

	public String toString(){
		java.util.Formatter f = new java.util.Formatter();
		f.format("%.2f", pris);
		return varenr + ": " + varenavn + ", pris pr kg kr " + 		"u.moms."; "
	}

} // klassen Vare


class Prisberegning{
	public static void main(String[] args){
		Vare vare = new Vare("norgesost", 124, 79.50);
		System.out.println(vare.toString());

	} // end main
} // klassen Prisberegning