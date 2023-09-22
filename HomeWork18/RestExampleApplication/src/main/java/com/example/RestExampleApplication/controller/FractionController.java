package com.example.RestExampleApplication.controller;

import com.example.RestExampleApplication.model.Fraction;
import com.example.RestExampleApplication.service.FractionService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FractionController {
    private final FractionService fractionService;

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public ResponseEntity<Fraction> getResult(@RequestBody ObjectNode objectNode) {
        JsonNode jsonNodeFraction1 = objectNode.findValue("fraction1");
        JsonNode jsonNodeFraction2 = objectNode.findValue("fraction2");
        Fraction fraction1 = new Fraction(jsonNodeFraction1.get("numerator").asInt(), jsonNodeFraction1.get("denominator").asInt(), "");
        Fraction fraction2 = new Fraction(jsonNodeFraction2.get("numerator").asInt(), jsonNodeFraction2.get("denominator").asInt(), "");
        String operation = objectNode.findValue("operation").asText();
        Fraction newFraction = new Fraction();
        switch (operation) {
            case "+" -> newFraction = fractionService.plus(fraction1, fraction2);
            case "-" -> newFraction = fractionService.minus(fraction1, fraction2);
            case "*" -> newFraction = fractionService.multiplication(fraction1, fraction2);
            case "/" -> newFraction = fractionService.division(fraction1, fraction2);
        }
        return new ResponseEntity<>(newFraction, HttpStatus.OK);
    }
    
    @PostMapping(value = "/checkCorrect")
    public ResponseEntity<Fraction> checkCorrectFraction(@RequestBody Fraction fraction) {
        fraction.setOperation(fractionService.correctFraction(fraction) ? "Дробь правильная" : "Дробь не правильная");
        return new ResponseEntity<>(fraction, HttpStatus.OK);
    }

    @PostMapping(value = "/reduction")
    public ResponseEntity<Fraction> reductionFraction(@RequestBody Fraction fraction) {
        fraction.setOperation("Сокращение дроби");
        fractionService.reductionFraction(fraction);
        return new ResponseEntity<>(fraction, HttpStatus.OK);
    }
}
