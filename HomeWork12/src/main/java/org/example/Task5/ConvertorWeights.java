package org.example.Task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConvertorWeights {
    private List<Weight> weights = new ArrayList<>();
    private ListWeights originalWeights;
    private ListWeights finalWeight;
    private int totalOriginalWeight;

    private void downloadDatabase() {
        weights.add(new Weight(ListWeights.milligrams, ListWeights.gram, 0.001));
        weights.add(new Weight(ListWeights.milligrams, ListWeights.kilogram, 0.000001));
        weights.add(new Weight(ListWeights.milligrams, ListWeights.centner, 0.00000001));
        weights.add(new Weight(ListWeights.milligrams, ListWeights.ton, 0.000000001));

        weights.add(new Weight(ListWeights.gram, ListWeights.milligrams, 1000));
        weights.add(new Weight(ListWeights.gram, ListWeights.kilogram, 0.001));
        weights.add(new Weight(ListWeights.gram, ListWeights.centner, 0.00001));
        weights.add(new Weight(ListWeights.gram, ListWeights.ton, 0.000001));

        weights.add(new Weight(ListWeights.kilogram, ListWeights.milligrams, 1000000));
        weights.add(new Weight(ListWeights.kilogram, ListWeights.gram, 1000));
        weights.add(new Weight(ListWeights.kilogram, ListWeights.centner, 0.01));
        weights.add(new Weight(ListWeights.kilogram, ListWeights.ton, 0.001));

        weights.add(new Weight(ListWeights.centner, ListWeights.milligrams, 100000000));
        weights.add(new Weight(ListWeights.centner, ListWeights.gram, 100000));
        weights.add(new Weight(ListWeights.centner, ListWeights.kilogram, 100));
        weights.add(new Weight(ListWeights.centner, ListWeights.ton, 0.1));

        weights.add(new Weight(ListWeights.ton, ListWeights.milligrams, 1000000000));
        weights.add(new Weight(ListWeights.ton, ListWeights.gram, 1000000));
        weights.add(new Weight(ListWeights.ton, ListWeights.kilogram, 1000));
        weights.add(new Weight(ListWeights.ton, ListWeights.centner, 10));
    }

    public ConvertorWeights(ListWeights originalWeights, ListWeights finalWeight, int totalOriginalWeight) {
        downloadDatabase();
        this.originalWeights = originalWeights;
        this.finalWeight = finalWeight;
        this.totalOriginalWeight = totalOriginalWeight;
    }

    public int getOriginalWeightCode() {
        return originalWeights.ordinal();
    }

    public int getFinalWeightCode() {
        return finalWeight.ordinal();
    }

    public double convert() {
        Optional<Weight> weight = weights.stream()
                .filter(item -> item.getOriginalWeightCode() == originalWeights.ordinal() && item.getFinalWeightCode() == finalWeight.ordinal())
                .findFirst();
        return weight.map(item -> item.getIndicator() * totalOriginalWeight).orElse(0.0);
    }
}
