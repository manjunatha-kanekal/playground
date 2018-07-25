/*
Problem: Program to print the factorial value of given number.
Input:	Integer
Output:	Factorial value
*/

package org.basics;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("**Factorial**");
        try (Scanner sc = new Scanner(System.in)) {
            int input;
            while (true) {
                System.out.print("Enter a number: ");
                try {
                    input = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException exp) {
                    System.out.println("Illegal input. Try again!");
                }
            }

            long result = factorial(input);
            System.out.println("Factorial value of " + input + " is: " + result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /* Recursive factorial logic */
    private static long factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
    }
}
