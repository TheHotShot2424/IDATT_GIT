/**
 * Employee.java
 *
 * Klassen beskriver en ansatt med nr, navn, skatteprosent og timeloenn.
 * Det er mulig aa endre skatteprosent og timeloenn.
 * Det foretas ingen kontroll av at den nye skatteprosenten er under grensen.
 * Skattetrekk, netto- og bruttoloenn kan regnes ut.
 */

class Employee {
  public static final double MAKS_TAX_PROS = 60.0;

  private final int employeenr;
  private final String name;
  private double salary;
  private double tax = MAKS_TAX_PROS;

  public Employee(int employeenr, String name, double salary) {
    if (employeenr < 1000 || employeenr > 9999) {
         Throw new IllegalArgumentException(”Employee-number must have four digits”);
    }
    this.employeenr = employeenr;
    this.name = name;
    this.salary = salary;
  }
  
  public Employee(int employeenr, String name) {
    if (employeenr < 1000 || employeenr > 9999) {
         Throw new IllegalArgumentException(”Employee-number must have four digits”);
    }
    this.employeenr = employeenr;
    this.name = name;
    this.salary = 0.0;
  }
  
  public int getEmployeenr() {
    return employeenr;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public double getTax() {
    return tax;
  }

  public void setSalary(double newSalary) {
      salary = newSalary;
  }

  public void setTax(double newTax) {
    if (newTax < 0.0 || newTax > MAKS_TAX_PROS){
         throw new IllegalArgumentException("Unvalid tax");
    }
    tax = newTax;
  }
  
  public double calculateBruttosalary(double numberOfHours) {
    return numberOfHours * salary;
  }

  public double calculateDeductedTax(double numberOfHours) {
    return calculateBruttosalary(numberOfHours) * tax / 100.0;
  }

  public double calculateNettoSalary(double numberOfHours) {
    return calculateBruttosalary(numberOfHours) - calculateDeductedTax(numberOfHours);
  }

  public String toString() {
    return "Employeenr.: " + employeenr + ", name: " + name + ", salary: " + salary +
            ", tax: " + tax;
  }
}