/*
 * Account.java  B.K. 2020-08-30
 *
 */
class Account {
  private long accountnr;
  private String name;
  private double saldo;

  public Account(long accountnr, String name, double saldo) {
    this.accountnr = accountnr;
    this.name = name;
    this.saldo = saldo;
  }

  public Account(long accountnr, String name) {
    this.accountnr = accountnr;
    this.name = name;
    this.saldo = 0;
  }

  public long getAccountnr() {
    return accountnr;
  }

  public double getSaldo() {
    return saldo;
  }

  public String getName() {
    return name;
  }

  public boolean doTransaktion(double amount) {
    if (saldo + amount >= 0) {
        saldo += amount;
        return true;
      } else {
        return false;
      }
    }

  public String toString(){
	  return accountnr + " " + name + " " + saldo;
  }

} // Account


class TestDataAccount {
  public static void main(String[] args) {
    final double TOLERANCE = 0.001;
    System.out.println("Totale number of tests: 4");

    Account accountOle = new Account(123456676756L, "Ole Olsen", 0.0);

    if (accountOle.getAccountnr() == 123456676756L &&    // pr�ver get-metodene
        accountOle.getName().equals("Ole Olsen") &&
        accountOle.getSaldo() == 0.0) {
      System.out.println("Account: Test 1 successfull");
    }
    
    boolean transOk = accountOle.doTransaktion(1000);   // setter inn et bel�p
    double nySaldo = accountOle.getSaldo();
    if (transOk && Math.abs(nySaldo - 1000) < TOLERANCE) {
      System.out.println("Account: Test 2 succcessfull");
    }

    Account accountPer = new Account(223456676756L, "Per Olsen", 3000.0);
    transOk = accountPer.doTransaktion(-1000);   // tar ut et bel�p
    nySaldo = accountPer.getSaldo();
    if (transOk && Math.abs(nySaldo - 2000) < TOLERANCE) {
      System.out.println("Account: Test 3 successfull");
    }

    Account accountEva = new Account(323456676756L, "Eva Olsen", 0.0);
    transOk = accountEva.doTransaktion(-100);   // fors�ker � overtrekke konto
    nySaldo = accountEva.getSaldo();
    if (!transOk && Math.abs(nySaldo - 0) < TOLERANCE) {
      System.out.println("Account: Test 4 successfull");
    }
    

  }
}


/* Utskrift:

*/