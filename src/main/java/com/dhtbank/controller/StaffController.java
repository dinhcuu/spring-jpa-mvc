package com.dhtbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {

    @GetMapping(value = "/staff/home")
    public String getStaffHomePage() {
        return "staff/staff-home";
    }

}
