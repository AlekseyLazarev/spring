package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

/**
 * Class Student
 * <p>
 * Date: 05.01.2020
 *
 * @author a.lazarev
 */
public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private LinkedHashMap<String,String> countryOptions;

    public Student(){
        this.countryOptions = new LinkedHashMap<>();
        this.countryOptions.put("BR","Brazil");
        this.countryOptions.put("FR","France");
        this.countryOptions.put("DE","Germany");
        this.countryOptions.put("IN","India");
        this.countryOptions.put("US","USA");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }
}
