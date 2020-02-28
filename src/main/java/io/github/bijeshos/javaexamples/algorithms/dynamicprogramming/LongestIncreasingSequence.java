package io.github.bijeshos.javaexamples.algorithms.dynamicprogramming;

public class LongestIncreasingSequence {
    static int maxLisLength; // stores the final LIS

    // Driver program to test the functions above
    public static void main(String args[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};
        int n = arr.length;
        System.out.println("Length of LIS is " + lisWrapper(arr, n));
    }

    // The wrapper function for lis()
    static int lisWrapper(int arr[], int n) {
        maxLisLength = 1; // stores the final LIS
        // maxLisLength is declared static above
        // so that it can maintain its value
        // between the recursive calls of lis()
        lis(arr, n);
        return maxLisLength;
    }


    // Recursive implementation for calculating the LIS
    static int lis(int arr[], int n) {
        // base case
        if (n == 1) {
            return 1;
        }
        int currentLisLength = 1;
        for (int i = 0; i < n - 1; i++) {
            // Recursively calculate the length of the LIS
            // ending at arr[i]
            int subProblemLisLength = lis(arr, i);
            // Check if appending arr[n-1] to the LIS
            // ending at arr[i] gives us an LIS ending at
            // arr[n-1] which is longer than the previously
            // calculated LIS ending at arr[n-1]
            if (arr[i] < arr[n - 1] && currentLisLength < (1 + subProblemLisLength)) {
                currentLisLength = 1 + subProblemLisLength;
            }
        }
        // Check if currently calculated LIS ending at
        // arr[n-1] is longer than the previously calculated
        // LIS and update maxLisLength accordingly
        if (maxLisLength < currentLisLength) {
            maxLisLength = currentLisLength;
        }
        return currentLisLength;
    }


}


/*
Problem statement:

The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 such that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for {10,
 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.


More Examples:

Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}

 */
