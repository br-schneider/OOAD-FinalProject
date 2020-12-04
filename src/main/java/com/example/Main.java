package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

@Controller
@SpringBootApplication
public class Main {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }


  @Value("${spring.datasource.url}")
  private String dbUrl;

  @Autowired
  private DataSource dataSource;


  //////////////////////////////////////////////Start Of Where to Work//////////////////////////////////////////////////

//  public void testFunction() {
//
//  }

  @RequestMapping("/")
  String index(Map<String, Object> model) {

    return "index";
  }

  @RequestMapping("/observer_pattern")
  public String search(Map<String, Object> model) {
    //testFunction();

    CarFactory carFactory = new CarFactory();

    Car car1 = carFactory.getCar("sedan");
    car1.setMake("toyota");
    car1.setModel("Corolla");
    car1.setColor("Black");
    car1.setMileage(19981);
    car1.setYear(2020);
    car1.setPrice(17999.99);


    model.put("message1", car1.getMake());
    model.put("message2", car1.getColor());
    model.put("message3", car1.getYear());
    model.put("message4", car1.getPrice());
    model.put("message5", car1.getMileage());

    Extra etest = new Extra("sony", 120);

    Stereo mtest = new Stereo(etest);

    Extra test = new Extra("enkei",50);
    Rims rims1 = new Rims(test);

    model.put("message6", mtest.getCost());
    model.put("message7", rims1.getCost());

    return "observer_pattern";
  }



  @RequestMapping("/search")
  public String search(@RequestParam(defaultValue="Guest") String FULL_SEARCH, Map<String, Object> model) {
    model.put("message1", FULL_SEARCH);


    return "search";
  }




//  @RequestMapping("/db")
//  String db(Map<String, Object> model) {
//    try (Connection connection = dataSource.getConnection()) {
//      Statement stmt = connection.createStatement();
//      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
//      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
//      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
//
//      ArrayList<String> output = new ArrayList<String>();
//      while (rs.next()) {
//        output.add("Read from DB: " + rs.getTimestamp("tick"));
//      }
//
//      model.put("records", output);
//      return "db";
//    } catch (Exception e) {
//      model.put("message", e.getMessage());
//      return "error";
//    }
//  }


//  List<Car> getCarsFromDB() {
//    List<Car> carsList = new ArrayList<Car>();
//
//    try (Connection connection = dataSource.getConnection()) {
//      String query = "SELECT * FROM car_inventory";
//      Statement stmt = connection.createStatement();
//      ResultSet rs = stmt.executeQuery(query);
//
//      String type, make, model2, color;
//      int year, mileage;
//      double price;
//
//      swtich:
//        if truck:
//            truck truck = new truck (adsfasdfas)
//
//
//      while (rs.next()) {
//        type = rs.getString("type");
//        make = rs.getString("make");
//        model2 = rs.getString("model");
//        year = rs.getInt("year");
//        mileage = rs.getInt("mileage");
//        color = rs.getString("color");
//        price = rs.getDouble("price");
//
//        Car testCar = new Car(type, make, model2, year, mileage, color, price);
//        carsList.add(testCar);
//      }
//
//      return carsList;
//
//    } catch (Exception e) {
//      Car errorCar = new Car("-1", "-1", "-1", -1, -1, "-1", -1);
//      carsList.add(errorCar);
//
//      return carsList;
//    }
//  }

  List<Sedan> getSedansFromDB() {
    List<Sedan> carsList = new ArrayList<Sedan>();

    try (Connection connection = dataSource.getConnection()) {
      String query = "SELECT * FROM car_inventory";
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

        Sedan testCar = new Sedan();
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
      Sedan errorCar = new Sedan();

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


  @RequestMapping("/car_inventory")
  String car_inventory(Map<String, Object> model) {
    List<Sedan> dbCarList = getSedansFromDB();


    model.put("car1make", dbCarList.get(0).getMake());
    model.put("car1model", dbCarList.get(0).getModel());
    model.put("car1color", dbCarList.get(0).getColor());


//    List<Car> dbCarList = getCarsFromDB();
//
////    ArrayList<String> output = new ArrayList<String>();
//
//    model.put("car1Title", dbCarList.get(0).printMakeModelYear());
//    model.put("car1Description", dbCarList.get(0).quickDescription());
//    model.put("car1Price", dbCarList.get(0).printPricing());

//    model.put("car2Title", dbCarList.get(1).printMakeModelYear());
//    model.put("car2Description", dbCarList.get(1).quickDescription());
//    model.put("car2Price", dbCarList.get(1).printPricing());
//
//    model.put("car3Title", dbCarList.get(2).printMakeModelYear());
//    model.put("car3Description", dbCarList.get(2).quickDescription());
//    model.put("car3Price", dbCarList.get(2).printPricing());



    return "car_inventory";
  }



  @RequestMapping("/car_profile")
  String car_profile(Map<String, Object> model) {

    return "car_profile";
  }


  @RequestMapping("/create_account")
  String createAccount(Map<String, Object> model) {

    return "create_account";
  }

  @RequestMapping("/forgot_password")
  String forgot_password(Map<String, Object> model) {

    return "forgot_password";
  }

  @RequestMapping("/login")
  String login(Map<String, Object> model) {
    return "login";
  }



 //////////////////////////////////////////////End Of Where to Work/////////////////////////////////////////////////////


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
