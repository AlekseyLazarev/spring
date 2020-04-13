package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        Employee e1 = new Employee(1, "Leslie", "Andrews", "la@luv2code.com");
        Employee e2 = new Employee(2, "Emma", "Bahh", "eb@luv2code.com");
        Employee e3 = new Employee(3, "Avani", "Gupta", "ag@luv2code.com");
        employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "list-employees";
    }
}
