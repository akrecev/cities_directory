package io.coreapp.manager;

import io.coreapp.exception.FileReadException;
import io.coreapp.model.City;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CitiesManager {

    final static String SEPARATOR = ";";

    public void loadCities(File file) {

        try {
            Scanner scanner = new Scanner(file);
            System.out.println();

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] data = line.split(SEPARATOR);
                City city = new City(
                        Integer.parseInt(data[0].trim()),
                        data.length < 2 ? "" : data[1].trim(),
                        data.length < 3 ? "" : data[2].trim(),
                        data.length < 4 ? "" : data[3].trim(),
                        data.length < 5 ? 0 : Integer.parseInt(data[4].trim()),
                        data.length < 6 ? "" : data[5].trim()
                );
                System.out.println(city + "\n");
            }

        } catch (IOException e) {
            throw new FileReadException("File reading error");
        }

    }

}
