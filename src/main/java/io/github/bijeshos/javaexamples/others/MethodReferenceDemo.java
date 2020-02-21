package io.github.bijeshos.javaexamples.others;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List fruitList = new ArrayList<>();
        fruitList.add("Apple");
        fruitList.add("Orange");
        fruitList.add("Grape");
        fruitList.add("Guava");
        fruitList.add("Pineapple");
        fruitList.forEach(System.out::println);
    }
}
