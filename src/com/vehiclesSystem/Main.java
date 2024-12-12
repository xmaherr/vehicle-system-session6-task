package com.vehiclesSystem;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.BikeController;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.controller.PlaneController;
import com.vehiclesSystem.controller.VehicleController;
import com.vehiclesSystem.models.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        //save car test
        CarController carController = context.getBean("carController", CarController.class);
        Car car = context.getBean("car",Car.class);
        car.setType(Type.CAR);
        car.setBrand("toyota2");
        try {
            carController.saveVehicle(car);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //save bike test
        BikeController bikeController = context.getBean("bikeController", BikeController.class);
        Bike bike = context.getBean("bike",Bike.class);
        bike.setType(Type.BIKE);
        bike.setBrand("Halawa2");
        try {
            carController.saveVehicle(bike);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

       // save plane test
        PlaneController blaneController = context.getBean("planeController", PlaneController.class);
        Plane plane = context.getBean("plane",Plane.class);
        plane.setType(Type.PLANE);
        plane.setBrand("PlaneBrand2");
        try {
            blaneController.saveVehicle(plane);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //delete car test
        try {
            carController.deleteVehicle(21);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //update car test
        try {
            carController.updateVehicle(15,"BMW");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //search test
        try {
           Vehicle vehicle = carController.searchVehicleById(23);
            System.out.println("search result\nid: "+vehicle.getId()+"\ntype: "+vehicle.getType().toString()+"\nbrand: "+vehicle.getBrand());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        context.close();


    }
}