/*
Problem: Program to print the numbers till the input value in Triangular pattern.
Input:	Integer
Output:	Number Triangle
 */
package org.basics;

import java.util.Scanner;

public class NumbersInTriangle {
    public static void main(String[] args) {
        System.out.println("**Number Triangle Pattern**");
        try (Scanner sc = new Scanner(System.in)) {
            int input;
            while (true) {
                System.out.print("Enter a number: ");
                try {
                    input = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException inexp) {
                    System.out.println("Illegal input. Try again!");
                }
            }

            printNumberTriangle(input);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printNumberTriangle(int input) {
        int numberToPrint = 1;
        for (int i = 1; i <= input; i++) {
            for (int k = 0; k < input - i; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                if (numberToPrint <= input) {
                    System.out.print(numberToPrint + " ");
                    numberToPrint++;
                }
            }
            if (numberToPrint >= input) {
                break;
            }
            System.out.println();
        }
    }
}
