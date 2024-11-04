package no.ntnu.idatt1003.advancedbankserver;

import no.ntnu.idatt1003.bankdatabase.Database;
import no.ntnu.idatt1003.common.SavingsAccount;

public class AccountService {

    private Database database;

    public AccountService() {
        this.database = new Database();
    }

    public SavingsAccount getAccountInfo(String username) {
        // using for loop

        /*
        for (SavingsAccount account : this.database.getSavingAccounts()) {
            if (account.getUsername().equals(username)) {
                return account;
            }
        }
        return null;
        */


        // using stream and lambda
       return this.database
               .getSavingAccounts()
               .stream()
               .filter(acc -> acc.getUsername().equals(username))
               .findFirst().orElse(null);
    }
}
