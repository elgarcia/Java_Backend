package com.elias;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@Data
public class Suma implements Operaciones{
    private final static String NAME = "SUMA";
    private double[]            numbers;

    public Suma(double... Operands){
        this.numbers = Operands;
    }
    @Override
    public double getResults() {
        double sum = 0;
        for (double res: numbers){
            sum += res;
        }
        return (sum);
    }

    @Override
    public String toString() {
        return (NAME + Arrays.toString(numbers)
                .replace("[", "(")
                .replace("]", ")"));
    }

    @Override
    public double getOperand(int index) {
        if (index < 0 || index > this.numbers.length)
            throw new RuntimeException();
        return (this.numbers[index - 1]);
    }
}
