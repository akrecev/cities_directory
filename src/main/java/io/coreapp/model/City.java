package io.coreapp.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private int id;
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + (population == 0 ? "" : population) +
                ", foundation='" + foundation + '\'' +
                '}';
    }
}
