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

        System.out.println(citiesManager.findMaxPopulation(cityList));

    }
}
