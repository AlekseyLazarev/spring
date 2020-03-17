package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public boolean addMembership(){
        System.out.println(getClass() + ": doing stuff: adding a membership account");
        return true;
    }

    public void goToSleep(){
        System.out.println(getClass() + ": goToSleep()");
    }
}
