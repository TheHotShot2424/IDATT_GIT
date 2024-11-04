package no.ntnu.idatt1003.advancedbankserver;

import no.ntnu.idatt1003.common.SavingsAccount;

public class AdvancedBank {
    private AuthenticationService authenticationService;
    private AccountService accountService;

    public AdvancedBank() {
        this.authenticationService = new AuthenticationService();
        this.accountService = new AccountService();
    }

    public boolean validateCustomer(String username, String password) {
        return authenticationService.validateCustomer(username, password);
    }

    public SavingsAccount getAccountInfo(String username) {
        return accountService.getAccountInfo(username);
    }

}
