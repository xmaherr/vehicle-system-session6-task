package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperation;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@ToString
@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bike implements Vehicle {
    int id;
    String brand;
    Type type;
}
