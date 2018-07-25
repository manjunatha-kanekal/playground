/*
Problem: Program to print the Pascal triangle for given number of rows.
Input: Integer
Output: Pascal Triangle
 */
package org.basics;

import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println("**Pascal Triangle**");
        try (Scanner sc = new Scanner(System.in)) {
            int numberOfRows;
            while (true) {
                System.out.print("Enter number of rows: ");
                try {
                    numberOfRows = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException inexp) {
                    System.out.println("Illegal input. Try again!");
                }
            }

            printPascalTriangle(numberOfRows);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printPascalTriangle(int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
            for (int k = 0; k < numberOfRows - i; k++) {
                System.out.print(" ");
            }

            int lastNumber = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(lastNumber + " ");
                lastNumber = lastNumber * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }
}
