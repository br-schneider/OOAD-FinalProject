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
public class CarFactory {
	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Autowired
	private DataSource dataSource;

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


	public static Car getCar(String carType) {
		
		if (carType == null) {
			return null;
		}
		else if(carType.equalsIgnoreCase("Sedan")) {
			return new Sedan();
		}
		else if (carType.equalsIgnoreCase("Coupe")) {
			return new Coupe();
		}
		else if (carType.equalsIgnoreCase("SUV")) {
			return new SUV();
		}
		else if (carType.equalsIgnoreCase("Hatchback")) {
			return new Hatchback();
		}
		else if (carType.equalsIgnoreCase("Truck")) {
			return new Truck();
		}
		else if (carType.equalsIgnoreCase("SportsCar")) {
			return new SportsCar();
		}
		return null;
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
