/* Groceries.java */

class Groceries {
 
  private String groceryName;
  private int groceryNr;
  private double price; // pris pr kilo, alltid uten moms

  public Groceries(String startGroceryName, int startGroceryNr, double startPrice) {
    groceryName = startGroceryName;
    groceryNr = startGroceryNr;
    price = startPrice;
  }

  public Groceries(String startGroceryName, int startGroceryNr) {
    groceryName = startGroceryName;
    groceryNr = startGroceryNr;
    price = 0.0;
  }

 public String getGroceryName() {
    return groceryName;
  }

  public int getGroceryNr() {6

    return groceryNr;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

    public String toString() {
    java.util.Formatter f = new java.util.Formatter();
    f.format("%.2f", price);
    return groceryNr + ": " + groceryName + ", pris pr. TEST kg kr " + f.toString() + " u.moms.";
  }
}


class Pricecalculation {
  public static void main(String[] args) {
    Groceries grocery1 = new Groceries("Norgesost", 124, 79.50);
    System.out.println(grocery1.toString());

  }
}

/* Kjoering av programmet:

124: Norgesost, pris pr. kg kr 79,50 u.moms.

*/
