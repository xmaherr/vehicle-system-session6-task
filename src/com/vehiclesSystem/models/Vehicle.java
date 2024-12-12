package com.vehiclesSystem.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public interface Vehicle {
    int getId();
    String getBrand();
    Type getType();
}
