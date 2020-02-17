package io.github.bijeshos.javaexamples.lambda;


public class CalculatorWithLambda {
    public static void main(String... args) {
        CalculatorWithLambda myApp = new CalculatorWithLambda();
        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;
        System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    interface IntegerMath {
        int operation(int a, int b);
    }
}
