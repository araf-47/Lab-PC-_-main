package com.example.SalahCounter.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students/{id}")
public class StudentControllar {
    @GetMapping
    public String getStudent(@PathVariable int id) {
        if (id <= 0) {
            return "invalid id";
        } else if (id == 1){
            return "Student id: " + id + "; Name = LK John Doe";
        } else if (id == 2){
            return "Student id: " + id + "; Name = Asfakul Alam";
        } else if (id == 3){
            return "Student id: " + id + "; Name = Atiqur Rahman";
        } else if (id == 4){
            return "Student id: " + id + "; Name = Muhammad Ali";
        } else {
            return "Student not found";
        }
    }
}
