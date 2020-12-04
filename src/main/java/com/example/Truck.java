package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication




public class Truck implements Car{
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Autowired
    private DataSource dataSource;

	
	String make;
	String model;
	int year;
	String color;
	int mileage;
	double price;

	public Truck() {
        super();
        this.make = "";
        this.model = "";
        this.year = 0;
        this.color = "";
        this.mileage = 0;
        this.price = 0.00;  
    }
     
    public void setMake(String make) {
        this.make = make;
    }
 
    public String getMake() {
        return make;
    }
    
    public void setModel(String model) {
    	this.model = model;
    }
    
    public String getModel() {
    	return model;
    }

    public void setYear(int year) {
    	this.year = year;
    }
    
    public int getYear() {
    	return year;
    }
    
    public void setColor(String color) {
    	this.color = color;
    }
    
    public String getColor() { return color; }
    
    public void setMileage(int mileage) {
    	this.mileage = mileage;
    }
    
    public String getMileage() {
    	return "The mileage of the chosen car is "+mileage+".";
    }
    
    public void setPrice(double price) {
    	this.price = price;
    }
    
    public String getPrice() {
    	return "The price for the car chosen is "+price+".";
    }


    public List<Truck> getTrucksFromDB() {
        List<Truck> carsList = new ArrayList<Truck>();

        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM car_inventory WHERE car_type like '%Truck%'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            String make, model2, color;
            int year, mileage;
            double price;

            while (rs.next()) {
                make = rs.getString("make");
                model2 = rs.getString("model");
                year = rs.getInt("year");
                mileage = rs.getInt("mileage");
                color = rs.getString("color");
                price = rs.getDouble("price");

                Truck testCar = new Truck();
                testCar.setMake(make);
                testCar.setModel(model2);
                testCar.setYear(year);
                testCar.setMileage(mileage);
                testCar.setColor(color);
                testCar.setPrice(price);

                carsList.add(testCar);
            }

            return carsList;

        } catch (Exception e) {
            Truck errorCar = new Truck();

            errorCar.setMake("-1");
            errorCar.setModel("-1");
            errorCar.setYear(-1);
            errorCar.setMileage(-1);
            errorCar.setColor("-1");
            errorCar.setPrice(-1);

            carsList.add(errorCar);

            return carsList;
        }
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        if (dbUrl == null || dbUrl.isEmpty()) {
            return new HikariDataSource();
        } else {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            return new HikariDataSource(config);
        }
    }
    
}
