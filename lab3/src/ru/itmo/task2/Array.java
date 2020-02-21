package ru.itmo.task2;

import java.util.Arrays;

public class Array <T extends Number> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public double sum() {
        double sum = 0;

        for (T elem : array) {
            sum += elem.doubleValue();
        }

        return sum;
    }
}
