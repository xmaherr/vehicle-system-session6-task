package com.vehiclesSystem;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.VehicleController;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        VehicleController vehicleController = context.getBean("vehicleController",VehicleController.class);
        try {
            vehicleController.saveVehicle(new Vehicle("BMW-X6","CAR"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
           Vehicle vehicle = vehicleController.searchVehicleById(54);
            if(vehicle != null)System.out.println(vehicle.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            vehicleController.updateVehicle(54,"KIV");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Vehicle vehicle =vehicleController.searchVehicleById(54);
            if(vehicle != null) System.out.println(vehicle.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            vehicleController.deleteVehicle(54);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            Vehicle vehicle = vehicleController.searchVehicleById(54);
            if(vehicle != null) System.out.println(vehicle.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        context.close();


    }
}