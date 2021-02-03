package com.example.database;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DatabaseApplicationController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
