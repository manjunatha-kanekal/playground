/*
Given a decimal number m. Convert it in binary string and apply n iterations,
in each iteration 0 becomes 01 and 1 becomes 10. Find kth character in the string after nth iteration.

Input:
The first line consists of an integer T i.e number of test cases.
The first and only line of each test case consists of three integers m,k,n.

Output:
Print the required output.

Constraints:
1<=T<=100
1<=m<=50
1<=n<=10
0<=k<=|Length of final string|

Example:
Input:
2
5 5 3
11 6 4

Output:
1
1
*/

package org.basics;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numberOfTestcase = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= numberOfTestcase; i++) {
                int decimalNumber = sc.nextInt();
                Stack<Integer> binaryStack = convertDecimalToBinary(decimalNumber);

                StringBuilder binaryString = new StringBuilder();
                while (!binaryStack.isEmpty()) {
                    binaryString.append(binaryStack.pop());
                }

                char result = findKthCharacterAfterNthIteration(binaryString, sc.nextInt(), sc.nextInt());
                System.out.println(result);
            }

        } catch (Exception e) {
            System.out.println("Something went wrong! " + e.toString());
        }
    }

    private static Stack<Integer> convertDecimalToBinary(int number) {
        int quotient = -1;
        Stack<Integer> bits = new Stack<>();
        while (quotient != 0) {
            quotient = number / 2;
            bits.push(number % 2);
            number = quotient;
        }
        return bits;
    }

    private static char findKthCharacterAfterNthIteration(StringBuilder binaryString, int position, int numberOfLoops) {
        while (numberOfLoops > 0) {
            StringBuilder modifiedString = new StringBuilder();
            for (int i = 0; i < binaryString.length(); i++) {
                char ch = binaryString.charAt(i);
                if (ch == '0') {
                    modifiedString.append("01");
                } else if (ch == '1') {
                    modifiedString.append("10");
                }
            }
            binaryString = modifiedString;
            numberOfLoops--;
        }
        return binaryString.charAt(position);
    }

}
