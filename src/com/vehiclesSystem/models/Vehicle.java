package com.vehiclesSystem.models;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@ToString
@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {
    int id;
    String brand;
    String type;

    public Vehicle(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }
}
