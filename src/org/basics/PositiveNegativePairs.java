/*
Problem: Program to print the positive and negative pairs in a input list.

Input:
2
6
1 -3 2 3 6 -1
8
4 8 9 -4 1 -1 -8 -9

Output:
-1 1 -3 3
-1 1 -4 4 -8 8 -9 9

Info:	If no pairs are present, print 0
 */

package org.basics;

import java.util.*;

public class PositiveNegativePairs {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numberOfTestcase = sc.nextInt();
            sc.nextLine();

            for (int i = 1; i <= numberOfTestcase; i++) {
                sc.nextLine();
                String input = sc.nextLine();

                List<Integer> pairingList = findPairs(input);
                if (pairingList != null && pairingList.size() > 0) {
                    StringBuilder testcaseResult = new StringBuilder();
                    for (int m : pairingList) {
                        testcaseResult.append("-").append(m).append(" ").append(m).append(" ");
                    }
                    testcaseResult.deleteCharAt(testcaseResult.length() -  1);
                    System.out.println(testcaseResult);
                } else {
                    System.out.println("0");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Integer> findPairs(String input) {
        List<Integer> pairList = new ArrayList<>();
        if (input != null) {
            List<String> inputArr = Arrays.asList(input.split(" "));
            for (String s : inputArr) {
                int val = Integer.valueOf(s);
                if (val > 0) {
                    if (inputArr.contains("-" + val)) {
                        pairList.add(val);
                    }
                }
            }
            Collections.sort(pairList);
        }
        return pairList;
    }
}
