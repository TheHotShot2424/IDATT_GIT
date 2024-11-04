package no.ntnu.idatt1003.customer;


import no.ntnu.idatt1003.advancedbankserver.AdvancedBank;
import no.ntnu.idatt1003.bankserver.Bank;
import no.ntnu.idatt1003.common.SavingsAccount;

public class Customer  {
    private String username;
    private String password;
    private Bank bank;
    private AdvancedBank advancedBank;

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
        //this.bank = new Bank();
        this.advancedBank = new AdvancedBank();
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password;
    }

    public boolean login() {
        //return bank.validateCustomer(username, password);
        return advancedBank.validateCustomer(username, password);
    }

    public SavingsAccount getAccountInfo(String username) {
        return advancedBank.getAccountInfo(username);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
