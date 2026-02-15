package com.example.project_one_colaboration_team.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class P1 {
    @RequestMapping("/")
    public String helloWorld(){
        return "Hello :>";
    }
}
