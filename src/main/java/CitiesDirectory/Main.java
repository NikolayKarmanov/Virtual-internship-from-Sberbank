package CitiesDirectory;

import com.google.gson.Gson;

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
        for (City city : cityList) {
            System.out.println(city.toString());
        }
    }
}

class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    public City(String name, String region, String district, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return "City" + gson.toJson(this);
    }
}