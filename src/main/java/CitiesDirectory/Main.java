package CitiesDirectory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

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

        int[] population = new int[cityList.size()];
        for (int i = 0; i < population.length; i++) {
            population[i] = cityList.get(i).getPopulation();
        }

        int index = 0;
        int max_population = population[index];
        for (int i = 1; i < population.length; i++) {
            if (population[i] > max_population) {
                index = i;
                max_population = population[index];
            }
        }

        System.out.println("[" + index + "] = " + max_population);

//        Collections.sort(cityList); // sort by city name
//        Collections.sort(cityList, new ComporatorByDistrictAndName()); // sort by district and city name

//        for (City city : cityList) {
//            System.out.println(city.toString());
//        }
    }
}