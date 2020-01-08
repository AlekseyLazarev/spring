package com.luv2code.springdemo.mvc.student;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

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
    private String favoriteLanguage;
    private String[] operatingSystems;
    private LinkedHashMap<String, String> countryOptions;
    private LinkedHashMap<String, String> languageOptions;
    private LinkedHashSet<String> operatingSystemsOptions;

    public Student() {
        this.countryOptions = new LinkedHashMap<>();
        this.countryOptions.put("BR", "Brazil");
        this.countryOptions.put("FR", "France");
        this.countryOptions.put("DE", "Germany");
        this.countryOptions.put("IN", "India");
        this.countryOptions.put("US", "USA");

        this.languageOptions = new LinkedHashMap<>();
        this.languageOptions.put("Java", "Java");
        this.languageOptions.put("C#", "C#");
        this.languageOptions.put("PHP", "PHP");
        this.languageOptions.put("Ruby", "Ruby");

        this.operatingSystemsOptions = new LinkedHashSet<>();
        this.operatingSystemsOptions.add("Linux");
        this.operatingSystemsOptions.add("Mac OS");
        this.operatingSystemsOptions.add("Windows");
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

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public LinkedHashMap<String, String> getLanguageOptions() {
        return languageOptions;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public LinkedHashSet<String> getOperatingSystemsOptions() {
        return operatingSystemsOptions;
    }
}
