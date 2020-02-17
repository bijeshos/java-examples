package io.github.bijeshos.javaexamples.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaBasicDemo {
    public static void main(String[] args) {
        threadDemo();
        //-------------------------------
        arrayDemo();
        //---method reference
        //Function<T, R>
    }

    private static void arrayDemo() {
        String[] sampleArray = {"123456", "123", "1234", "12345", "12345"};
        //regular way of writing
        Comparator<String> sampleComparator = new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        };
        Arrays.sort(sampleArray, sampleComparator);
        //System.out.println("Without Lambda:"+sampleArray.toString());
        String[] sampleArray2 = {"aaaaaa", "bbb", "cccc", "ddddd", "eeeeeee"};
        //writing with lambda
        Comparator<String> sampleComparatorLambda = (String s1, String s2) -> Integer.compare(s1.length(), s2.length());
        Arrays.sort(sampleArray2, sampleComparatorLambda);
        //System.out.println("With Lambda:"+sampleArray2.toString());
    }

    private static void threadDemo() {
        //regular way of writing
        Runnable runTask = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Without Lambda:" + i);
                }
            }
        };
        //System.out.println("-----------");
        new Thread(runTask).start();
        //writing with lambda
        Runnable runTaskLambda = () -> {
            for (int i = 10; i < 20; i++) {
                System.out.println("---With Lambda:" + i);
            }
        };
        new Thread(runTaskLambda).start();
    }
}
