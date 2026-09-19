package com.example.SalahCounter.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class CityController {
    @GetMapping
    public String getCities(
        @RequestParam String city, 
        @RequestParam String country
    ) {
        return "City: " + city + " . Country: " + country;
    }
}
