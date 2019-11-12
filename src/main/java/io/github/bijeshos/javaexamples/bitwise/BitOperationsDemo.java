package io.github.bijeshos.javaexamples.bitwise;

/*
    A class to demonstrate a few bitwise operations
 */
public class BitOperationsDemo {
    public static void main(String[] args) {
        rightShift(32, 40);
        rightShift(36, 40);

        checkOddOrEven(8);
        checkOddOrEven(9);

        leftShift(32, 40);
        leftShift(36, 40);

        isPowerOfTwo(-8);
        isPowerOfTwo(1);
        isPowerOfTwo(2);
        isPowerOfTwo(8);
        isPowerOfTwo(9);
        isPowerOfTwo(10);
        isPowerOfTwo(11);
        isPowerOfTwo(12);
        isPowerOfTwo(16);
        isPowerOfTwo(32);
        isPowerOfTwo(33);
        isPowerOfTwo(34);

        findOddOccurringNumber();

        swapNumbersWithoutTempVariable(12, 20);
        swapNumbersWithoutTempVariable(82, 123);
    }

    /*
        Problem statement:
            Swap two numbers without using any temporary variable
     */
    private static void swapNumbersWithoutTempVariable(int a, int b) {
        System.out.println("Before: a:" + a + ", b:" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After: a:" + a + ", b:" + b);
    }

    /*
        Problem statement:
            Given a set of numbers where all elements occur even number of times except one number,
            find the odd occurring number.
        Notes:
            Bitwise XOR can be used here to find the result
     */
    private static void findOddOccurringNumber() {
        int numArray[] = {12, 12, 14, 91, 14, 14, 14};
        int result = 0;
        for (int n : numArray) {
            result = result ^ n;
            //result ^=n;
        }
        System.out.println("Odd occurring number is: " + result);
    }

    /*
        Problem statement:
            Identify if the input number is a power of two
        Notes:
            For a number which is a power of 2, only 1 bit is set; eg: 8=00001000, 16=00010000.
            When 1 is subtracted with that number, result would have 1 in all set bits eg: 7=00000111, 15=00001111
            A bitwise AND (&) with n and n-1 will produce 0, if n is power of 2
     */
    private static void isPowerOfTwo(int unsignedNumber) {
        if (unsignedNumber > 0) {
            int result = unsignedNumber & (unsignedNumber - 1);
            if (result == 0) {
                System.out.println(unsignedNumber + " is a power of 2");
            } else {
                System.out.println(unsignedNumber + " is NOT a power of 2");
            }
        } else {
            System.out.println(unsignedNumber + " is not a valid input");
        }


        /*
            //Option 2:

            int result = Integer.bitCount(unsignedNumber);
            if (result == 1) {
                System.out.println(unsignedNumber + " is a power of 2");
            } else {
                System.out.println(unsignedNumber + " is NOT a power of 2");
            }

         */
        System.out.println("------------------------------------------------------");
    }

    /*
     Problem statement:
        Identify if the input number is a odd or even
     Notes:
        For even numbers, last bit will always be 0 and for odd numbers, last bit will be 1.
        Value of last bit can be extracted by doing an bitwise AND (&) with the number
     */

    private static void checkOddOrEven(int number) {
        //System.out.println("------------------------------------------------------");
        int result = number & 1;
        if (result == 1) {
            System.out.println(number + " is odd");
        } else {
            System.out.println(number + " is even");
        }
        System.out.println("------------------------------------------------------");
    }

    /*
        Problem statement:
            Divide a number by two, using bitwise operations
        Notes:
            Right shift is equivalent to division by 2
     */
    private static void rightShift(int number, int shiftCount) {
        //System.out.println("------------------------------------------------------");
        for (int i = 0; i < shiftCount; i++) {
            System.out.println("number : before shift: " + number + ", after >>[" + i + "] : " + (number >> i));
        }
        System.out.println("------------------------------------------------------");
    }

    /*
        Problem statement:
            Multiply a number by two, using bitwise operations
        Notes:
            Left Shift is equivalent to multiplied by 2
     */
    private static void leftShift(int number, int shiftCount) {
        //System.out.println("------------------------------------------------------");
        for (int i = 0; i < shiftCount; i++) {
            System.out.println("number : before shift: " + number + ", after <<[" + i + "] : " + (number << i));
        }
        System.out.println("------------------------------------------------------");
    }
}
