package io.github.bijeshos.javaexamples.algorithms.dynamicprogramming;


public class Fibonacci {
    long[] fibonacciLookUp;

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int n = 50;
        //approach 1 - regular recursion
        System.out.println("---- Approach 1: regular recursion -----");
        long startTime = System.currentTimeMillis();
        //for (int i = 1; i <= n; i++) {
        //System.out.println(n + " th fibonacci number is: " + fibonacci.findNthFibonacciNumberRecursive(n));
        //}
        //System.out.println("--- Time taken: " +(System.currentTimeMillis()-startTime)+" ms");
        //approach 2 - Using dynamic programming - memoization table
        fibonacci.fibonacciLookUp = new long[n + 1];
        System.out.println("---- Approach 2: Using dynamic programming - memoization table -----");
        startTime = System.currentTimeMillis();
        //for (int i = 1; i <= n; i++) {
        System.out.println(n + " th fibonacci number is: " + fibonacci.findNthFibonacciNumberUsingMemoization(n));
        //}
        System.out.println("--- Time taken: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private long findNthFibonacciNumberRecursive(int n) {
        if (n <= 1) {
            return n;
        } else {
            return (findNthFibonacciNumberRecursive(n - 1) + findNthFibonacciNumberRecursive(n - 2));
        }
    }

    private long findNthFibonacciNumberUsingMemoization(int n) {
        if (fibonacciLookUp[n] == 0 || fibonacciLookUp == null) {
            if (n <= 1) {
                fibonacciLookUp[n] = n;
            } else {
                fibonacciLookUp[n] = findNthFibonacciNumberUsingMemoization(n - 1) +
                                     findNthFibonacciNumberUsingMemoization(n - 2);
            }
        }
        return fibonacciLookUp[n];
    }
}
