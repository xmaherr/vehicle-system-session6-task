package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component
@Scope("singleton")
public class DatabaseOperation {
    @Value("${database.url}")
    private String url;
    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;
    private Connection connection;

    public DatabaseOperation() {
        System.out.println("DatabaseOperation called");
    }

    @PostConstruct
    void connectToDatabase(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("connecting to database..");
    }

    public Vehicle saveVehicle(Vehicle vehicle) throws SQLException {
            String query = "INSERT INTO Vehicle (type, brand) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,vehicle.getType().toString() );
            preparedStatement.setString(2, vehicle.getBrand());
            preparedStatement.executeUpdate();
            System.out.println("Vehicle of type "+vehicle.getType().toString()+" and brand"+vehicle.getBrand()+" saved.");
            return vehicle;
        }
    public Boolean deleteVehicle(int id){
        String query = "DELETE FROM Vehicle WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehicle with id " + id + " deleted successfully.");
                return true;
            } else {
                System.out.println("Vehicle with id " + id + " not found.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while deleting vehicle with id " + id);
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateBrand(int id, String newBrand) {
        String query = "UPDATE Vehicle SET brand = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newBrand);
            preparedStatement.setInt(2, id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehicle with id " + id + " updated successfully.");
                return true;
            } else {
                System.out.println("Vehicle with id " + id + " not found.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while updating vehicle with id " + id);
            e.printStackTrace();
            return false;
        }
    }

    public Vehicle searchById(int id) {
        String query = "SELECT * FROM Vehicle WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id); // Set the vehicle ID

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Retrieve data from the result set
                int vehicleId = resultSet.getInt("id");
                String brand = resultSet.getString("brand");
                String type = resultSet.getString("type");
                return new Vehicle(vehicleId,brand,type);

            } else {
                System.out.println("Vehicle with id " + id + " not found.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while searching for vehicle with id " + id);
            e.printStackTrace();
            return null;
        }
    }

    @PreDestroy
    void disconnectFromDatabase() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from database.");
            } catch (SQLException e) {
                throw new RuntimeException("Error while disconnecting from database", e);
            }
        } else {
            System.out.println("No active connection to disconnect.");
        }
    }
}
