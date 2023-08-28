package org.example.Task5;

public class Weight {
    private ListWeights originalWeight;
    private ListWeights finalWeight;
    private double indicator;

    public Weight(ListWeights originalWeight, ListWeights finalWeight, double indicator) {
        this.originalWeight = originalWeight;
        this.finalWeight = finalWeight;
        this.indicator = indicator;
    }

    public ListWeights getOriginalWeight() {
        return originalWeight;
    }

    public ListWeights getFinalWeight() {
        return finalWeight;
    }

    public double getIndicator() {
        return indicator;
    }

    public int getOriginalWeightCode() {
        return originalWeight.ordinal();
    }

    public int getFinalWeightCode() {
        return finalWeight.ordinal();
    }
}


