package com.example.pendataanpenduduk;

import java.io.Serializable;
import java.util.ArrayList;

public class DataModel implements Serializable {
  private String name;
  private String address;
  private String city;
  private Integer age;
  private String job;
  private Double salary;
  private String status;

  public static ArrayList<DataModel> data = new ArrayList<DataModel>();


  public DataModel(String name, String address, String city, Integer age, String job, Double salary, String status) {
    this.name = name;
    this.address = address;
    this.city = city;
    this.age = age;
    this.job = job;
    this.salary = salary;
    this.status = status;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public static ArrayList<DataModel> getData() {
    return data;
  }

  public static void setData(DataModel data_user) {
    data.add(data_user);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
