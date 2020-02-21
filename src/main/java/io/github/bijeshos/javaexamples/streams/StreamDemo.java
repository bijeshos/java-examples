package io.github.bijeshos.javaexamples.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        StreamDemo demo = new StreamDemo();
        demo.filterAndPrint();
        demo.filterAndCount();
        demo.reduce();
    }

    private void filterAndPrint() {
        Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");
        fruitStream.filter(s -> s.contains("a"))
                   .map(String::toUpperCase)
                   .sorted()
                   .forEach(System.out::println);
    }

    private void filterAndCount() {
        List<Integer> integerList = Arrays.asList(0, 1, 2, 3, 42);
        // sequential
        long howManyOddNumbers = integerList.stream()
                                            .filter(e -> (e % 2) == 1)
                                            .count();
        System.out.println(howManyOddNumbers); // Output: 2
    }

    private void reduce() {
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(intArray));
        System.out.println("Sum of integers: " + listOfIntegers.stream()
                                                               .reduce(Integer::sum)
                                                               .get());
        Integer.max(1, 2);
    }
}
