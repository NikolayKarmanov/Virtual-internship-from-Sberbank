package CitiesDirectory;

import com.google.gson.Gson;

public class City implements Comparable<City> {
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

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return "City" + gson.toJson(this);
    }

    @Override
    public int compareTo(City o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }
}