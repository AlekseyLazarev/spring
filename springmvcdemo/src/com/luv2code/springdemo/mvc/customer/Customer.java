package com.luv2code.springdemo.mvc.customer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class Customer
 * <p>
 * Date: 07.01.2020
 *
 * @author a.lazarev
 */
public class Customer {
    private String firstName;

    @NotNull()
    @Size(min = 1, message = "is required")
    private String lastName;

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
}
