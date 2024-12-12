package com.vehiclesSystem.models;

import com.vehiclesSystem.dao.DatabaseOperation;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@Scope("prototype")
public class Plane implements Vehicle {
    int id;
    String brand;
    Type type=Type.PLANE;

}
