package io.github.bijeshos.javaexamples.generics.model;
/*
    This class requires Number or sub classes of number only
 */

public class Statistics<T extends Number> {
    private T[] numbers;

    public Statistics(T[] numbers) {
        this.numbers = numbers;
    }

    public double average() {
        double sum = 0.0;
        for (T number : numbers) {
            sum = sum + number.doubleValue();
        }
        return sum / numbers.length;
    }

    public boolean isSameAverage(Statistics<?> otherStatistics) {
        if (average() == otherStatistics.average()) {
            return true;
        } else {
            return false;
        }
    }
}
