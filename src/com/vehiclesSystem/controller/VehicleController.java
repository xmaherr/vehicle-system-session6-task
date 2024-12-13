package com.vehiclesSystem.controller;

import com.vehiclesSystem.dao.DatabaseOperation;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@Scope("prototype")
public class VehicleController {
    @Autowired
    DatabaseOperation databaseOperation;

    public Vehicle saveVehicle(Vehicle vehicle) throws SQLException {

        return this.databaseOperation.saveVehicle(vehicle);
    }


    public Boolean deleteVehicle(int id) throws SQLException {
        return this.databaseOperation.deleteVehicle(id);
    }


    public Boolean updateVehicle(int id,String newBrand) throws SQLException {
        return this.databaseOperation.updateBrand(id,newBrand);
    }


    public Vehicle searchVehicleById(int id) throws SQLException {
        return this.databaseOperation.searchById(id);
    }

}
