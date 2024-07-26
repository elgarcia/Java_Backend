package com.elias;

import java.util.Arrays;

public class Sumatorio {
    private double[]    numbers;
    private int         minPos;
    private int         maxPos = -1;

    public          Sumatorio(){
        this.numbers = null;
        minPos = 0;
        maxPos = 0;
    }

    public          Sumatorio(double[] initNumbers, int initPos, int finalPos){
        this.numbers = Arrays.copyOf(initNumbers, initNumbers.length);
        this.minPos = initPos;
        this.maxPos = finalPos;
    }

    public          Sumatorio(double[] initNumbers){
        this(initNumbers, 0, initNumbers.length - 1);
    }

    public void     setMinPos(int minPos) {
        this.minPos = minPos;
    }

    public void     setMaxPos(int maxPos) {
        this.maxPos = maxPos;
    }

    public double   getSuma(){
        double  sum = 0;

        for (int i = this.minPos; i <= this.maxPos; i++){
            sum += this.numbers[i];
        }
        return (sum);
    }

    public static Builder  builder(){
        return new Builder();
    }
}

class Builder {
    private double[] nums = {};
    private int begin;
    private int end = -1;

    public Builder       addNumber(double numbs){
        this.nums = Arrays.copyOf(this.nums, this.nums.length + 1);
        this.nums[this.nums.length - 1] = numbs;
        return (this);
    }

    public Builder      setMin(int initPos){
        this.begin = initPos - 1;
        return (this);
    }

    public Builder      setMax(int finalPos){
        this.end = finalPos - 1;
        return (this);
    }

    public Sumatorio    build(){
        return (new Sumatorio(nums, begin, end < 0 ? nums.length - 1 : end));
    }
}
