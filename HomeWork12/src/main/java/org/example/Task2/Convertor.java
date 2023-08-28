package org.example.Task2;

public class Convertor {
    private Currency originalCurrency; //Изначанальная валюта
    private int totalOriginalCurrency;  //Всего денег. Например 2 доллара.
    private double course; //Курс
    private Currency finalCurrency; //Валюта перевода

    public Convertor(Currency oridinalCurrency, int totalOridinalCurrency, double course, Currency finalCurrency) {
        this.originalCurrency = oridinalCurrency;
        this.totalOriginalCurrency = totalOridinalCurrency;
        this.course = course;
        this.finalCurrency = finalCurrency;
    }

    public int getOriginalCurrencyCode() {
        return originalCurrency.ordinal();
    }

    public int getTotalOriginalCurrency() {
        return totalOriginalCurrency;
    }

    public double getCourse() {
        return course;
    }

    public int getFinalCurrencyCode() {
        return finalCurrency.ordinal();
    }

    public double calcConvertor() {
        return totalOriginalCurrency * course;
    }
}
