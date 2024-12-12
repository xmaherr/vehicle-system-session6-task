package com.vehiclesSystem.controller;

import com.vehiclesSystem.models.Vehicle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
@Scope("prototype")
public interface VehicleController {
    Vehicle saveVehicle(Vehicle vehicle) throws SQLException;

    default Boolean deleteVehicle(int id) throws SQLException {
        return false;
    }

    Boolean updateVehicle(int id,String newBrand)throws SQLException;
    Vehicle searchVehicleById(int id)throws SQLException;

}
