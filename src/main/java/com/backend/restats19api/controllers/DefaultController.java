package com.backend.restats19api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> Hello(){
        try{
            return ResponseEntity.ok("-- Hello the world !! --");
        }catch (Exception e){
            return  ResponseEntity.ok(e.getCause().getStackTrace());
        }
    }
}

