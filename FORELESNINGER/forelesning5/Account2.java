/*
 * Account2.java  B.K. 2020-08-30
 * En utgave av klassen Konto der vi bruker oere i stedet for kroner
 * for aa utnytte fordelene med heltallsberegninger.
 * Grensesnittet mot omverdenen er det samme.
 */
class Account2 {
  private long accountnr;
  private String name;
  private long saldo; //oere

  public Account2(long accountnr, String name, double saldo) {
    this.accountnr = accountnr;
    this.name = name;
    this.saldo = changeIntoOere(saldo);
  }

  public long getAccountnr() {
    return accountnr;
  }

  public String getName() {
    return name;
  }
  
  public double getSaldo() {
    double saldoKr = changeIntoKr(saldo);
    return saldoKr;
  }

  

  public boolean doTransaktion(double amount) {
    int amountOere = changeIntoOere(amount);
    if (saldo + amountOere >= 0) {
        saldo += amountOere;
        return true;
      } else {
        return false;
      }
    }

/* Hjelpemetoder */
  private int changeIntoOere(double kr) {
    return (int) (kr * 100);
  }

  private double changeIntoKr(long oere) {
    return oere * 0.01;
  }

  public String toString(){
	  return accountnr + " " + name + " " + saldo;
  }

} // Account


class TestDataAccount2 {
  public static void main(String[] args) {
    final double TOLERANCE = 0.001;
    System.out.println("Totale number of tests: 3");

    Account2 accountOle = new Account2(123456676756L, "Ole Olsen", 0.0);

    boolean transOk = accountOle.doTransaktion(1000);   // setter inn et beloep
    double nySaldo = accountOle.getSaldo();
    if (transOk && Math.abs(nySaldo - 1000) < TOLERANCE) {
      System.out.println("Account: Test 1 successfull");
    }
    
    Account2 accountPer = new Account2(223456676756L, "Per Olsen", 3000.0);
    transOk = accountPer.doTransaktion(-1000);   // tar ut et bel�p
    nySaldo = accountPer.getSaldo();
    if (transOk && Math.abs(nySaldo - 2000) < TOLERANCE) {
      System.out.println("Account: Test 2 successfull");
    }

    Account2 accountEva = new Account2(323456676756L, "Eva Olsen", 0.0);
    transOk = accountEva.doTransaktion(-100);   // fors�ker � overtrekke konto
    nySaldo = accountEva.getSaldo();
    if (!transOk && Math.abs(nySaldo - 0) < TOLERANCE) {
      System.out.println("Account: Test 3 successfull");
    }
    

  }
}


/* Utskrift:

*/