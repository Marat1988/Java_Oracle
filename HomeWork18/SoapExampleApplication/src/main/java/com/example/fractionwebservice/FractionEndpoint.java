package com.example.fractionwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_fraction_web_service.GetCalcFractionRequest;
import io.spring.guides.gs_fraction_web_service.GetCalcFractionResponse;

import io.spring.guides.gs_fraction_web_service.GetReducingFractionRequest;
import io.spring.guides.gs_fraction_web_service.GetReducingFractionResponse;

import io.spring.guides.gs_fraction_web_service.GetProperFractionRequest;
import io.spring.guides.gs_fraction_web_service.GetProperFractionResponse;

@Endpoint
public class FractionEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-fraction-web-service";

    private FractionRepository fractionRepository;

    @Autowired
    public FractionEndpoint(FractionRepository fractionRepository) {
        this.fractionRepository = fractionRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCalcFractionRequest")
    @ResponsePayload
    public GetCalcFractionResponse calcResultFraction(@RequestPayload GetCalcFractionRequest request) { //Сложение, вычитание, умножение, деление дробей
        GetCalcFractionResponse response = new GetCalcFractionResponse();
        String operation = request.getOperation();
        switch (operation) {
            case "+" -> response.setFraction(fractionRepository.plus(request.getFraction1(), request.getFraction2()));
            case "-" -> response.setFraction(fractionRepository.minus(request.getFraction1(), request.getFraction2()));
            case "*" ->
                    response.setFraction(fractionRepository.multiplication(request.getFraction1(), request.getFraction2()));
            case "/" ->
                    response.setFraction(fractionRepository.division(request.getFraction1(), request.getFraction2()));
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getReducingFractionRequest") //Сокращение дроби
    @ResponsePayload
    public GetReducingFractionResponse reducingFraction(@RequestPayload GetReducingFractionRequest request) {
        GetReducingFractionResponse response = new GetReducingFractionResponse();
        response.setFraction(fractionRepository.reducingFraction(request.getFraction()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProperFractionRequest") //Проверка на правильность дробь
    @ResponsePayload
    public GetProperFractionResponse properFraction(@RequestPayload GetProperFractionRequest request) {
        GetProperFractionResponse response = new GetProperFractionResponse();
        response.setAnswer(fractionRepository.properFraction(request.getFraction()));
        return response;
    }

}