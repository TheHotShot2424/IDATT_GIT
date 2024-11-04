package no.ntnu.idatt1003.common;

public class SavingsAccount {

    private String username;
    private double balance;
    private double interestRate;

    public SavingsAccount(String username, double balance, double interestRate) {
        this.username = username;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public String getUsername() {
        return username;
    }


    @Override
    public String toString() {
        return "SavingAccount{" +
                "username='" + username + '\'' +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                '}';
    }

}
