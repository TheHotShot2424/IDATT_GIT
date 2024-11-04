package no.ntnu.idatt1003;

import no.ntnu.idatt1003.customer.Customer;

import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        Customer customer = new Customer(username, password);
        boolean isLoginSuccessful = customer.login();
        if (isLoginSuccessful) {
            System.out.println("Login successful");
            System.out.println("Account info: " + customer.getAccountInfo(customer.getUsername()));
        } else {
            System.out.println("Login failed");
        }
    }
}
