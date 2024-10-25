/*
 * Groceries3.java
 */

class Groceries3 {
  private static final double TAX = 24.0;
  private static final double TAXFACTOR = 1.0 + TAX / 100.0;

  private String groceryName;
  private int groceryNr;
  private double price; // pris pr kilo, alltid uten moms

  public Groceries3(String startGroceryName, int startGroceryNr, double startPrice) {
   if (startGroceryNr < 10000) {
        throw new IllegalArgumentException("Grocerynumber must have five digits");
   }
   if (startPrice < 0.50) {
    throw new IllegalArgumentException("Price must be at least 0.50");
   }
    groceryName = startGroceryName;
    groceryNr = startGroceryNr;
    price = startPrice;
  }

  public Groceries3(String startGroceryName, int startGroceryNr) {
    if (startGroceryNr < 10000) {
        throw new IllegalArgumentException("Grocerynumber must have five digits");
   }
   if (startPrice < 0.50) {
        throw new IllegalArgumentException("Price must be at least 0.50");
   }
    groceryName = startGroceryName;
    groceryNr = startGroceryNr;
    price = 0.0;
  }

 public String getGroceryName() {
    return groceryName;
  }

  public int getGroceryNr() {
    return groceryNr;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double findPriceWithoutTax(double numberOfKilo) {
    double totalPrice = price * numberOfKilo;
    if (numberOfKilo > 5){
 		totalPrice *= 0.8;
  	}
  	else if (numberOfKilo > 3){
  		totalPrice *= 0.9;
  	}
  	return totalPrice;
  }


  public double findPriceWithTax(double numberOfKilo) {
    double totalPrice = price * numberOfKilo;
    if (numberOfKilo > 5){
 		totalPrice *= 0.8;
  	}
  	else if (numberOfKilo > 3){
  		totalPrice *= 0.9;
  	}
  	return totalPrice * TAXFACTOR;
  }


  public String toString() {
    java.util.Formatter f = new java.util.Formatter();
    f.format("%.2f", price);
    return groceryNr + ": " + groceryName + ", pris pr. TEST kg kr " + f.toString() + " u.moms.";
  }
}

class Pricecalculation3 {
  public static void main(String[] args) {
    try{
		Groceries3 grocery = new Groceries3("Norgesost", 12345, 79.50);
        System.out.println(grocery.toString());

        // Leser inn antkg fra bruker
	    double numberOfKilo = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Number of kilo: "));

	    //Øensker formatert utskrift
	    java.text.DecimalFormat format = new java.text.DecimalFormat("###0.00");

	    // beregner pris med og uten moms
        while (numberOfKilo < 0.1 || numberOfKilo > 10){
		    System.out.println ("Number of kilo must be between 0.1 and 10 kilo");
		    numberOfKilo = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Number of kilo: "));
	    }
	    System.out.println(numberOfKilo + " ost koster: "  + format.format(grocery.findPriceWithoutTax(numberOfKilo)) + ",- u/mva");
    
        while (numberOfKilo < 0.1 || numberOfKilo > 10){
		    System.out.println ("Number of kilo must be between 0.1 and 10 kilo");
		    numberOfKilo = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Number of kilo: "));
	    }
        System.out.println(numberOfKilo + " ost koster: "+ format.format(grocery.findPriceWithTax(numberOfKilo)) + ",- m/mva");
    } catch (IllegalArgumentException e){
		System.out.println ("Error in contructor");
	}
  }
}

/* Kj�ring av programmet:

*/



