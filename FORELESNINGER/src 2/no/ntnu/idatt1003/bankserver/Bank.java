package no.ntnu.idatt1003.bankserver;

import no.ntnu.idatt1003.bankdatabase.Database;
import no.ntnu.idatt1003.customer.Customer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {

    public Bank() {}

    public boolean validateCustomer(String username, String password) {
        // checking hardcoded credentials
        /*
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
        */

        // using database and loops
        List<Customer> userDatabase = new Database().getCustomers();
        for (Customer customer : userDatabase) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password))
                return true;
        }
        return false;



        // using database, lambda and streams
        /*
        List<Customer> userDatabase = new Database().getCustomers();

        List<Customer> match = userDatabase.stream()
                .filter(customer -> customer.getUsername().equals(username) && customer.getPassword().equals(password))
                .toList();

        return !match.isEmpty();
        */
    }
}
