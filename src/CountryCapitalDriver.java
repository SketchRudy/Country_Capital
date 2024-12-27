/**
 * Interactive command-line interface for querying country capitals.
 * Prompts the user to enter a country and displays the corresponding capital.
 * Utilizes the CountryCapital class for data management. *
 *
 * @Author: Rudolf Sirbu
 * @Date 5/27/24
 */

import java.util.Scanner;

public class CountryCapitalDriver {

    /**
     * Main method that serves as the entry point for the program.
     * Continuously prompts the user for a country name and displays its capital.
     * The program terminates when the user types "exit".
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        CountryCapital countryCapital = new CountryCapital();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter a country (or type 'exit' to quit):");
            String country = scanner.nextLine();

            // Exit condition
            if (country.equalsIgnoreCase("exit")) {
                break;
            }

            // Display the capital if the country exists
            if (countryCapital.containsKey(country)) {
                System.out.println("The capital of " + country + " is " + countryCapital.getCapital(country));
            } else {
                System.out.println("Country not found");
            }
        }

        scanner.close(); // Close the scanner resource
    }
}
