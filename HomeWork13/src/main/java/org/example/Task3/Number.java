package org.example.Task3;

import java.util.ArrayList;
import java.util.Collections;

public class Number {
    private ArrayList<Integer> numbers;

    public Number(ArrayList<Integer> numbers){
        this.numbers = numbers;
    }

    public Long getSum(){
        return numbers.stream()
                .reduce(Integer::sum)
                .get()
                .longValue();
    }

    public double getAvg(){
        return (double) numbers.stream()
                .reduce(Integer::sum)
                .get()
                .longValue() /numbers.size();
    }

    public Integer getMax(){
        return Collections.max(numbers);
    }

    public Integer getMin(){
        return Collections.min(numbers);
    }

    public void addNumber(Integer num){
        numbers.add(num);
    }
}
