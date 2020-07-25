package com.backend.restats19api.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    @ResponseBody
    public String Hello(){
        return "-- Hello the world !! --";
    }
}

