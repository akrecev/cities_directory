package io.coreapp;

import io.coreapp.manager.CitiesManager;
import io.coreapp.model.City;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        File file = new File("data/cities.csv");

        CitiesManager citiesManager = new CitiesManager();
        List<City> cityList = citiesManager.loadCities(file);

        // Сортировка по наименованию города
        List<City> sortedListByName = citiesManager.sortByName(cityList);
        citiesManager.printCityList(sortedListByName);

        System.out.println("\n");
        System.out.println("_________________________________________________________________________________________");
        System.out.println("\n");

        // Сортировка по федеральному округу и наименованию города
        List<City> sortedListByDistrictAndName = citiesManager.sortByDistrictAndName(cityList);
        citiesManager.printCityList(sortedListByDistrictAndName);

    }
}
