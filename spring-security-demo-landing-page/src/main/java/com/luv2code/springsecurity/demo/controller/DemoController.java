package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Class DemoController
 * <p>
 * Date: 31.03.2020
 *
 * @author a.lazarev
 */
@Controller
public class DemoController {
    @GetMapping("/")
    public String showLanding() {
        return "landing";
    }

    @GetMapping("/employees")
    public String showHome() {
        return "home";
    }
}
