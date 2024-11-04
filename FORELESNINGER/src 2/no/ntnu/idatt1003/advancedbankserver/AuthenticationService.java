package no.ntnu.idatt1003.advancedbankserver;

import no.ntnu.idatt1003.bankdatabase.Database;
import no.ntnu.idatt1003.customer.Customer;

import java.util.List;

public class AuthenticationService {

    private Database database;

    public AuthenticationService() {
        this.database = new Database();
    }

    public boolean validateCustomer(String username, String password) {
        // using for loop
        /*
        List<Customer> userDatabase = new Database().getCustomers();
        for (Customer customer : userDatabase) {
            if (customer.getUsername().equals(username) && customer.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
         */


        // using Lamda and streams
        return this.database.getCustomers().stream().anyMatch(
                cust -> cust.getUsername().equals(username) && cust.getPassword().equals(password)
        );
    }
}
