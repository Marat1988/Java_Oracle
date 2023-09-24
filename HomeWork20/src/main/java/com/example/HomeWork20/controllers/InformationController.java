package com.example.HomeWork20.controllers;

import com.example.HomeWork20.service.ApartmentService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONException;
import org.json.JSONObject;

@RestController
@Slf4j
@AllArgsConstructor
public class InformationController {
    private final ApartmentService apartmentService;

    @PostMapping("/getInfo")
    public ResponseEntity<String> getInfo() throws JSONException {
        int maxPrice = apartmentService.maxPrice();
        int minPrice = apartmentService.minPrice();
        double avg = apartmentService.avgPrice();
        JSONObject resp = new JSONObject();
        resp.put("maxPrice", maxPrice);
        resp.put("minPrice", minPrice);
        resp.put("averagePrice", avg);
        return new ResponseEntity<>(resp.toString(), HttpStatus.OK);

    }
}
