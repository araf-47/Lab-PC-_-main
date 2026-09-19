package com.example.SalahCounter.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asf")
public class AsfController {
    @GetMapping
    public String getAsf() {
        return "My name is Ashfakul Alam. My nick name is ASF. I am a software engineer. I like the number 48";
    }
}
