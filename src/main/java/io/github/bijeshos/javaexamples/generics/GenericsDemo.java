package io.github.bijeshos.javaexamples.generics;

import io.github.bijeshos.javaexamples.generics.model.KeyValueHolder;
import io.github.bijeshos.javaexamples.generics.model.SimpleHolder;
import io.github.bijeshos.javaexamples.generics.model.Statistics;

public class GenericsDemo {
    public static void main(String[] args) {
        basicGenericsDemo();
        keyValueHolderDemo();
        upperBoundsDemo();
        wildCardDemo();
    }

    private static void basicGenericsDemo() {
        System.out.println("-----------------------");
        SimpleHolder<Integer> firstSimpleHolder = new SimpleHolder<>(100);
        firstSimpleHolder.printMemberType();
        int firstMember = firstSimpleHolder.getMember();
        System.out.println("firstMember:" + firstMember);
        System.out.println("-----------------------");
        SimpleHolder<String> secondSimpleHolder = new SimpleHolder<>("Test");
        secondSimpleHolder.printMemberType();
        String secondMember = secondSimpleHolder.getMember();
        System.out.println("secondMember: " + secondMember);
        System.out.println("-----------------------");
    }

    private static void keyValueHolderDemo() {
        System.out.println("-----------------------");
        KeyValueHolder<String, Integer> firstKeyValueHolder = new KeyValueHolder<>("Key_1", 100);
        firstKeyValueHolder.printKeyValueTypes();
        System.out.println(
                "First: Key: " + firstKeyValueHolder.getKey() + "\t Value: " + firstKeyValueHolder.getValue());
        System.out.println("-----------------------");
        KeyValueHolder<Integer, String> secondKeyValueHolder = new KeyValueHolder<>(200, "Value_2");
        firstKeyValueHolder.printKeyValueTypes();
        System.out.println(
                "Second: Key: " + secondKeyValueHolder.getKey() + "\t Value: " + secondKeyValueHolder.getValue());
        System.out.println("-----------------------");
    }

    private static void upperBoundsDemo() {
        System.out.println("-----------------------");
        Integer[] intArray = {10, 20, 30, 40, 50};
        Statistics<Integer> intStatistics = new Statistics<>(intArray);
        System.out.println("Average of int values: " + intStatistics.average());
        System.out.println("-----------------------");
        Double[] doubleArray = {60.0, 60.1, 60.2, 60.3, 60.4};
        Statistics<Double> doubleStatistics = new Statistics<>(doubleArray);
        System.out.println("Average of double values: " + doubleStatistics.average());
        System.out.println("-----------------------");
        //Statistics<String> stringStatistics;  // This statement will give compilation error
    }

    private static void wildCardDemo() {
        System.out.println("-----------------------");
        Integer[] intArray = {10, 20, 30, 40, 50};
        Statistics<Integer> intStatistics = new Statistics<>(intArray);
        System.out.println("Average of int values: " + intStatistics.average());
        System.out.println("-----------------------");
        Double[] doubleArray1 = {10.0, 20.0, 30.0, 40.0, 50.0};
        Statistics<Double> doubleStatistics1 = new Statistics<>(doubleArray1);
        System.out.println("Average of double values: " + doubleStatistics1.average());
        System.out.println("-----------------------");
        Double[] doubleArray2 = {10.1, 20.2, 30.3, 40.4, 50.5};
        Statistics<Double> doubleStatistics2 = new Statistics<>(doubleArray2);
        System.out.println("Average of double values: " + doubleStatistics2.average());
        System.out.println("-----------------------");
        System.out.print("Average of Integer and Double 1 are ");
        if (intStatistics.isSameAverage(doubleStatistics1)) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }
        System.out.println("-----------------------");
        System.out.print("Average of Integer and Double 2 are ");
        if (intStatistics.isSameAverage(doubleStatistics2)) {
            System.out.println("same");
        } else {
            System.out.println("different");
        }
    }
}
