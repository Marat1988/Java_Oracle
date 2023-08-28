package org.example.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConvertorLengths {

    private List<Length> lengths = new ArrayList<>();

    private ListLengths originalLength; //Изначальная длина
    private ListLengths finalLength; //Конечная длина (на которую переводим)
    private int totalOriginalLength;  //Всего изначальной валюты. Например, 2 км

    private void downloadDatabase() {
        lengths.add(new Length(ListLengths.millimeters, ListLengths.centimeters, 0.1));
        lengths.add(new Length(ListLengths.millimeters, ListLengths.decimeters, 0.01));
        lengths.add(new Length(ListLengths.millimeters, ListLengths.meters, 0.001));
        lengths.add(new Length(ListLengths.millimeters, ListLengths.kilometers, 0.000001));

        lengths.add(new Length(ListLengths.centimeters, ListLengths.millimeters, 10));
        lengths.add(new Length(ListLengths.centimeters, ListLengths.decimeters, 0.1));
        lengths.add(new Length(ListLengths.centimeters, ListLengths.meters, 0.01));
        lengths.add(new Length(ListLengths.centimeters, ListLengths.kilometers, 0.00001));

        lengths.add(new Length(ListLengths.decimeters, ListLengths.millimeters, 100));
        lengths.add(new Length(ListLengths.decimeters, ListLengths.centimeters, 10));
        lengths.add(new Length(ListLengths.decimeters, ListLengths.meters, 0.1));
        lengths.add(new Length(ListLengths.decimeters, ListLengths.kilometers, 0.0001));

        lengths.add(new Length(ListLengths.meters, ListLengths.millimeters, 1000));
        lengths.add(new Length(ListLengths.meters, ListLengths.centimeters, 100));
        lengths.add(new Length(ListLengths.meters, ListLengths.decimeters, 10));
        lengths.add(new Length(ListLengths.meters, ListLengths.kilometers, 0.001));

        lengths.add(new Length(ListLengths.kilometers, ListLengths.millimeters, 1000000));
        lengths.add(new Length(ListLengths.kilometers, ListLengths.centimeters, 100000));
        lengths.add(new Length(ListLengths.kilometers, ListLengths.decimeters, 10000));
        lengths.add(new Length(ListLengths.kilometers, ListLengths.meters, 1000));
    }

    public ConvertorLengths(ListLengths originalLength, ListLengths finalLength, int totalOriginalLength) {
        downloadDatabase();
        this.originalLength = originalLength;
        this.finalLength = finalLength;
        this.totalOriginalLength = totalOriginalLength;
    }

    public int getOriginalLengthCode() {
        return originalLength.ordinal();
    }

    public int getFinalLengthCode() {
        return finalLength.ordinal();
    }

    public double convert() {
        Optional<Length> length = lengths.stream()
                .filter(item -> item.getOriginalLengthCode() == originalLength.ordinal() && item.getFinalLengthCode() == finalLength.ordinal())
                .findFirst();
        return length.map(item -> item.getIndicator() * totalOriginalLength).orElse(0.0);
    }
}
