package io.coreapp.manager;

import io.coreapp.exception.FileReadException;
import io.coreapp.model.City;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CitiesManager {

    final static String SEPARATOR = ";";

    public List<City> loadCities(File file) {
        List<City> cityList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] data = line.split(SEPARATOR);
                City city = new City(
                        Integer.parseInt(data[0].trim()),                             // id
                        data.length < 2 ? "" : data[1].trim(),                        // name
                        data.length < 3 ? "" : data[2].trim(),                        // region
                        data.length < 4 ? "" : data[3].trim(),                        // district
                        data.length < 5 ? 0 : Integer.parseInt(data[4].trim()),       // population
                        data.length < 6 ? "" : data[5].trim()                         // foundation
                );
                cityList.add(city);
            }

        } catch (IOException e) {
            throw new FileReadException("File reading error");
        }

        return cityList;
    }

    public List<City> sortByName(List<City> cityList) {
        cityList.sort(Comparator.comparing(City::getName));
        return  cityList;
    }

    public List<City> sortByDistrictAndName(List<City> cityList) {
        cityList.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        return  cityList;
    }

    public void printCityList(List<City> cityList) {
        for (City city : cityList) {
            System.out.println();
            System.out.println(city);
        }
    }

}
