package org.basics;

import java.util.Scanner;

public class CharacterCounter {
    public static void main(String[] args) {
        System.out.println("**Character Counter**");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Please input the string: ");
            String input = sc.nextLine();
            printCharCount(input);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printCharCount(String input) {
        int[] charCountArr = new int[Character.MAX_VALUE];

        for (int i = 0; i < input.length(); i++) {
            charCountArr[(int) input.charAt(i)]++;
        }

        /* Printing.. */
        for (int i = 0; i < charCountArr.length; i++) {
            if (charCountArr[i] > 0) {
                System.out.println((char) i + ": " + charCountArr[i]);
            }
        }
    }
}
