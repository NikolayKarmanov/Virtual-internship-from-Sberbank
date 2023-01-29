package CitiesDirectory;

import java.util.Comparator;

public class ComporatorByDistrictAndName implements Comparator<City> {

    @Override
    public int compare(City a, City b) {
        String district_a = a.getDistrict();
        String district_b = b.getDistrict();
        int result = (district_a.equals(district_b)) ? 0 : district_a.compareTo(district_b);
        return result == 0 ? a.compareTo(b) : result;
    }
}
