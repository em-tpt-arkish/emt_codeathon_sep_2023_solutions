/*
 * Core Java Problem Solving - Codeathon.
 * A.R. Kishore Kumar ~ (c) 2023 ~ -- ~ Tirupati, Andhra Pradesh, India ~
 *
 */

package codeathon;

import java.util.*;
public class Codeathon06_Kishore
{
    public static void main(String[] args)
    {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // Number of Elements in each List

        System.out.println("List 1");
        for (int i = 0; i < n; i++) {    // Storing first list of values
            list1.add( sc.next() );
        }

        System.out.println("List 2");
        for (int i = 0; i < n; i++) {    // Storing second list of values
            list2.add( sc.next() );
        }

        // storing matching fruits to resultMap and displaying final output
        Map<String, List<String>> resultMap = new HashMap<>();
        for (String text : list1)
        {
            List<String> matchingFruits = findMatchingFruits(text, list2);
            resultMap.put(text, matchingFruits);
        }
        for (String list1String : list1)
        {
            List<String> matchingFruits = resultMap.get(list1String);

            System.out.print(list1String + ": ");
            if (matchingFruits.isEmpty()) {
                System.out.println("[No Fruit]");
            }
            else
            {
                System.out.println(String.join(", ", matchingFruits));
            }
        }
    }

    // method for finding matched fruits
    private static List<String> findMatchingFruits(String numberString, List<String> list2) {
        char alphabet = findAlphabetCharacter(numberString);
        List<String> matchingFruits = new ArrayList<>();

        for (String fruit : list2)
        {
            if (fruit.length() == alphabet - 'A' + 1)
            {
                matchingFruits.add(fruit);
            }
        }
        return matchingFruits;
    }

    // Method to know no of letters Based on Alphabet
    private static char findAlphabetCharacter(String text) {
        for (char c : text.toCharArray())
        {
            if (Character.isLetter(c)) {
                return Character.toUpperCase(c);
            }
        }
        return ' ';
    }
}
