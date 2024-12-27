import java.util.TreeMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 *Manages a mapping of countries and their capitals using a case-insensitive TreeMap.
 * Includes functionality to preload default values, load additional data from a file,
 * and query the capital of a country.
 *
 * @Author
 */
public class CountryCapital {
    private TreeMap<String, String> countryCapitalMap;

    public CountryCapital() {
        countryCapitalMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        addDefaultValues();
        loadFromFile("KeyValue.txt");
    }

    // Adding default values to the TreeMap (case-insensitive TreeMap automatically handles case)
    public void addDefaultValues() {
        countryCapitalMap.put("USA", "Washington, D.C.");
        countryCapitalMap.put("Canada", "Ottawa");
        countryCapitalMap.put("Brazil", "Brasilia");
        countryCapitalMap.put("Japan", "Tokyo");
        countryCapitalMap.put("France", "Paris");
    }

    // Loading data from a file
    public void loadFromFile(String filepath) {
        try (Scanner scanner = new Scanner(new File(filepath))) {
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");
                if (line.length == 2) {
                    String country = line[0].trim();
                    String capital = line[1].trim();
                    countryCapitalMap.put(country, capital);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filepath);
        }
    }

    // Check if the country exists in the map
    public boolean containsKey(String country) {
        return countryCapitalMap.containsKey(country);
    }

    // Get the capital of the country
    public String getCapital(String country) {
        return countryCapitalMap.get(country);
    }
}
