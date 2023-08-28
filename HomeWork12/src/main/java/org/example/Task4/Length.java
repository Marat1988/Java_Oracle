package org.example.Task4;

public class Length {
    private ListLengths originalLength; //Изначальная валюта
    private ListLengths finalLength; //Конечная длина (на которую переводим)
    private double indicator; //Показатель, например в 1 км 1000 метров

    public Length(ListLengths originalLength, ListLengths finalLength, double indicator) {
        this.originalLength = originalLength;
        this.finalLength = finalLength;
        this.indicator = indicator;
    }

    public ListLengths getOriginalUnits() {
        return originalLength;
    }

    public ListLengths getFinalUnits() {
        return finalLength;
    }

    public double getIndicator() {
        return indicator;
    }

    public int getOriginalLengthCode() {
        return originalLength.ordinal();
    }

    public int getFinalLengthCode() {
        return finalLength.ordinal();
    }


}
