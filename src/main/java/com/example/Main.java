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


  List<Sedan> getSedansFromDB() {
    List<Sedan> carsList = new ArrayList<Sedan>();

    try (Connection connection = dataSource.getConnection()) {
      String query = "SELECT * FROM car_inventory WHERE car_type like '%Sedan%'";
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

  List<Truck> getTrucksFromDB() {
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

  List<SUV> getSUVsFromDB() {
    List<SUV> carsList = new ArrayList<SUV>();

    try (Connection connection = dataSource.getConnection()) {
      String query = "SELECT * FROM car_inventory WHERE car_type like '%SUV%'";
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

        SUV testCar = new SUV();
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
      SUV errorCar = new SUV();

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

  List<Coupe> getCoupesFromDB() {
    List<Coupe> carsList = new ArrayList<Coupe>();

    try (Connection connection = dataSource.getConnection()) {
      String query = "SELECT * FROM car_inventory WHERE car_type like '%Coupe%'";
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

        Coupe testCar = new Coupe();
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
      Coupe errorCar = new Coupe();

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


  @RequestMapping("/search")
  public String search(@RequestParam(defaultValue="errorSearch") String FULL_SEARCH, Model model) {
    CarFactory testFactory = new CarFactory();

    String[] values = FULL_SEARCH.split(",");

    int amountOfResults = 0;


    if (values[0].equals("Sedan")) {
      List<Sedan> dbCarList = getSedansFromDB();
      String model2 = "";
      String make = "";

      amountOfResults = dbCarList.size();

      ArrayList<String> output = new ArrayList<String>();

      for (int i = 0; i < amountOfResults; i++) {
        double doubledays = Math.round((Math.random() * (30 - 1)) + 1);
        int days = (int) doubledays;
        model2 = dbCarList.get(i).getModel();
        make = dbCarList.get(i).getMake();
        year = dbCarList.get(i).getYear();
        miles = dbCarList.get(i).getMileage();
        price = dbCarList.get(i).getPrice();

        output.add(
          "                <div class=\"d-flex w-100 justify-content-between\">\n" +
          "                    <h5 class=\"mb-1\" >" + model2 + "</h5>\n" +
          "                    <small>" + days + " days ago </small>\n" +
          "                </div>\n" +
          "                <p class=\"mb-1\"> " + make + "</p>\n" +
                          "<h5 class=\"mb-1\" >" + year + miles + price + "</h5>\n" +
          "                <small blah\">blahblah</small>\n"
        );
      }

      model.addAttribute("messages", output);

      return "search";

    }
    else if (values[0].equals("Truck") ) {

      List<Truck> dbCarList = getTrucksFromDB();
      String model2;
      String make;

      amountOfResults = dbCarList.size();

      ArrayList<String> output = new ArrayList<String>();

      for (int i = 0; i < amountOfResults; i++) {
        double doubledays = Math.round((Math.random() * (30 - 1)) + 1);
        int days = (int) doubledays;
        model2 = dbCarList.get(i).getModel();
        make = dbCarList.get(i).getMake();

        output.add(
                "                <div class=\"d-flex w-100 justify-content-between\">\n" +
                        "                    <h5 class=\"mb-1\" >" + model2 + "</h5>\n" +
                        "                    <small>" + days + " days ago </small>\n" +
                        "                </div>\n" +
                        "                <p class=\"mb-1\"> " + make + "</p>\n" +
                        "                <small blah\">blahblah</small>\n"
        );
      }

      model.addAttribute("messages", output);

      return "search";
    }
    else if (values[0].equals("SUV") ) {

      List<SUV> dbCarList = getSUVsFromDB();
      String model2;
      String make;

      amountOfResults = dbCarList.size();

      ArrayList<String> output = new ArrayList<String>();

      for (int i = 0; i < amountOfResults; i++) {
        double doubledays = Math.round((Math.random() * (30 - 1)) + 1);
        int days = (int) doubledays;
        model2 = dbCarList.get(i).getModel();
        make = dbCarList.get(i).getMake();

        output.add(
                "                <div class=\"d-flex w-100 justify-content-between\">\n" +
                        "                    <h5 class=\"mb-1\" >" + model2 + "</h5>\n" +
                        "                    <small>" + days + " days ago </small>\n" +
                        "                </div>\n" +
                        "                <p class=\"mb-1\"> " + make + "</p>\n" +
                        "                <small blah\">blahblah</small>\n"
        );
      }

      model.addAttribute("messages", output);

      return "search";
    }
    else if (values[0].equals("Coupe") ) {

      List<Coupe> dbCarList = getCoupesFromDB();
      String model2;
      String make;

      amountOfResults = dbCarList.size();

      ArrayList<String> output = new ArrayList<String>();

      for (int i = 0; i < amountOfResults; i++) {
        double doubledays = Math.round((Math.random() * (30 - 1)) + 1);
        int days = (int) doubledays;
        model2 = dbCarList.get(i).getModel();
        make = dbCarList.get(i).getMake();

        output.add(
                "                <div class=\"d-flex w-100 justify-content-between\">\n" +
                        "                    <h5 class=\"mb-1\" >" + model2 + "</h5>\n" +
                        "                    <small>" + days + " days ago </small>\n" +
                        "                </div>\n" +
                        "                <p class=\"mb-1\"> " + make + "</p>\n" +
                        "                <small blah\">blahblah</small>\n"
        );
      }

      model.addAttribute("messages", output);

      return "search";
    }
    else {
      model.addAttribute("messages", "                <div class=\"d-flex w-100 justify-content-between\">\n" +
              "                    <h1 class=\"mb-1\" > No Results :(</h1>\n" +
              "                </div>\n");
    }


    return "?";
  }



  @RequestMapping("/car_inventory")
  String car_inventory(Model model) {
    List<Sedan> SedanDBCarList = getSedansFromDB();
    List<Coupe> CoupeDBCarList = getCoupesFromDB();
    List<Truck> TruckDBCarList = getTrucksFromDB();
    List<SUV> SUVDBCarList = getSUVsFromDB();

    String model2;
    String make;

    int amountOfSedanResults = SedanDBCarList.size();
    int amountOfCoupeResults = CoupeDBCarList.size();
    int amountOfTruckResults = TruckDBCarList.size();
    int amountOfSUVResults = SUVDBCarList.size();

    ArrayList<String> output = new ArrayList<String>();

    for (int i = 0; i < amountOfSedanResults; i++) {
      double doubledays = Math.round((Math.random() * (30 - 1)) + 1);
      int days = (int) doubledays;
      model2 = SedanDBCarList.get(i).getModel();
      make = SedanDBCarList.get(i).getMake();

      output.add(
              "                <div class=\"d-flex w-100 justify-content-between\">\n" +
                      "                    <h5 class=\"mb-1\" >" + model2 + "</h5>\n" +
                      "                    <small>" + days + " days ago </small>\n" +
                      "                </div>\n" +
                      "                <p class=\"mb-1\"> " + make + "</p>\n" +
                      "                <small blah\">blahblah</small>\n"
      );
    }

    for (int i = 0; i < amountOfSUVResults; i++) {
      double doubledays = Math.round((Math.random() * (30 - 1)) + 1);
      int days = (int) doubledays;
      model2 = SUVDBCarList.get(i).getModel();
      make = SUVDBCarList.get(i).getMake();

      output.add(
              "                <div class=\"d-flex w-100 justify-content-between\">\n" +
                      "                    <h5 class=\"mb-1\" >" + model2 + "</h5>\n" +
                      "                    <small>" + days + " days ago </small>\n" +
                      "                </div>\n" +
                      "                <p class=\"mb-1\"> " + make + "</p>\n" +
                      "                <small blah\">blahblah</small>\n"
      );
    }

    for (int i = 0; i < amountOfTruckResults; i++) {
      double doubledays = Math.round((Math.random() * (30 - 1)) + 1);
      int days = (int) doubledays;
      model2 = TruckDBCarList.get(i).getModel();
      make = TruckDBCarList.get(i).getMake();

      output.add(
              "                <div class=\"d-flex w-100 justify-content-between\">\n" +
                      "                    <h5 class=\"mb-1\" >" + model2 + "</h5>\n" +
                      "                    <small>" + days + " days ago </small>\n" +
                      "                </div>\n" +
                      "                <p class=\"mb-1\"> " + make + "</p>\n" +
                      "                <small blah\">blahblah</small>\n"
      );
    }

    for (int i = 0; i < amountOfCoupeResults; i++) {
      double doubledays = Math.round((Math.random() * (30 - 1)) + 1);
      int days = (int) doubledays;
      model2 = CoupeDBCarList.get(i).getModel();
      make = CoupeDBCarList.get(i).getMake();

      output.add(
              "                <div class=\"d-flex w-100 justify-content-between\">\n" +
                      "                    <h5 class=\"mb-1\" >" + model2 + "</h5>\n" +
                      "                    <small>" + days + " days ago </small>\n" +
                      "                </div>\n" +
                      "                <p class=\"mb-1\"> " + make + "</p>\n" +
                      "                <small blah\">blahblah</small>\n"
      );
    }



    model.addAttribute("messages", output);



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
