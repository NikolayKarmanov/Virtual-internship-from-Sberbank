package CitiesDirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<City> cityList = new LinkedList<>();
        Scanner scanner = new Scanner(new File("Cities.csv"));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] properties = line.split(";");
            String name = properties[1];
            String region = properties[2];
            String district = properties[3];
            String population = properties[4];
            String foundation = properties[5];
            cityList.add(new City(name, region, district, Integer.parseInt(population), foundation));
        }
        scanner.close();

        // filling Map with names of region and number of cities
        Map<String, Integer> regions = new LinkedHashMap<>();
        for (int i = 0; i < cityList.size(); i++) {
            String name_of_region = cityList.get(i).getRegion();
            if (regions.containsKey(name_of_region)) {
                regions.replace(name_of_region, regions.get(name_of_region) + 1);
            } else {
                regions.put(name_of_region, 1);
            }
        }

        for (String region : regions.keySet()) {
            System.out.println(region + " - " + regions.get(region));
        }

    }
}