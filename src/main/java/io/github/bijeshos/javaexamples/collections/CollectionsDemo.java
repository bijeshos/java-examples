package io.github.bijeshos.javaexamples.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {
    public static void main(String[] args) {
        CollectionsDemo demo = new CollectionsDemo();
        demo.startDemo();
    }

    public void startDemo() {
        listOperations();
        mapOperations();
        setOperations();
    }

    private static void listOperations() {
        List<String> sampleList = List.of("a", "b", "c");
        sampleList.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
    }

    private static void mapOperations() {
        Map<String, String> sampleMap = Map.of("Key1", "Value1", "Key2", "Value2");
        sampleMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    private static void setOperations() {
        Set<String> sampleSet = Set.of("a", "b", "c");
        sampleSet.forEach(System.out::println);
    }
}
