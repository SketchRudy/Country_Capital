/**
 * @Author: Rudolf Sirbu
 * @Date 5/27/24
 */

import java.util.Scanner;

public class CountryCapitalDriver {
    public static void main(String[] args) {
        CountryCapital countryCapital = new CountryCapital();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter a country (or type 'exit' to quit):");
            String country = scanner.nextLine();

            if (country.equalsIgnoreCase("exit")) {
                break;
            }

            if (countryCapital.containsKey(country)) {
                System.out.println("The capital of " + country + " is " + countryCapital.getCapital(country));
            } else {
                System.out.println("Country not found");
            }
        }

        scanner.close();
    }
}
