package io.coreapp;

import io.coreapp.manager.CitiesManager;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        File file = new File("data/cities.csv");

        CitiesManager citiesManager = new CitiesManager();

        citiesManager.loadCities(file);

    }
}
