package com.demo.details.controller;


import com.demo.details.entity.Detailsmodel;
import com.demo.details.service.DetaisService;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
@CrossOrigin("*")
public class Detailscontroller {
    private final DetaisService detailsService;
    public Detailscontroller(DetaisService detailsService) {
        this.detailsService = detailsService;
    }
    @PostMapping("/submit")
    public String detailsAdd(@RequestBody Detailsmodel details){
        return detailsService.saveDetails(details);
    }
    @GetMapping("/allUsers")
    public List<Map<String, Object>> getAllUsersWithDetails() {
        return detailsService.getAllUsersWithDetails();
    }
}
