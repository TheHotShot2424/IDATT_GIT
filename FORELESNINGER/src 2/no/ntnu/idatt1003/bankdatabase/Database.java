package no.ntnu.idatt1003.bankdatabase;

import no.ntnu.idatt1003.common.SavingsAccount;
import no.ntnu.idatt1003.customer.Customer;

import java.util.*;

public class Database {

    public Database() {}

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("admin", "admin"));
        customers.add(new Customer("user", "password1"));
        customers.add(new Customer("user2", "password2"));
        customers.add(new Customer("user3", "passwordx"));
        return customers;
    }

    public List<SavingsAccount> getSavingAccounts() {
        List<SavingsAccount> savingsAccounts = new ArrayList<>();
        savingsAccounts.add(new SavingsAccount("admin", 1000, 0.05));
        savingsAccounts.add(new SavingsAccount("user", 2000, 0.1));
        return savingsAccounts;
    }
}
