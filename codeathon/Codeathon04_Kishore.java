/*
 * Core Java Problem Solving - Codeathon.
 * A.R. Kishore Kumar ~ (c) 2023 ~ -- ~ Tirupati, Andhra Pradesh, India ~
 *
 */

package codeathon;

import java.util.Scanner;
interface LambdaOperation
{
    boolean perform(int x);
}

public class Codeathon04_Kishore
{
    public static void main(String args[])
    {
        // Check given number is even or odd
        LambdaOperation isOdd = n -> {
            boolean check = false;
            if (n % 2 != 0)
                check = true;
            return check;
        };

        //check given number is prime or composite
        LambdaOperation isPrime = n -> {
            boolean check = true;
            for (int i = 2; i < n - 1; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
            return check;
        };

        //check given number is palindrome or not
        LambdaOperation isPalindrome = n -> {
            boolean check = false;
            int p, r=0, k = n;
            while ( n != 0)
            {
                p = n%10;
                r = r*10 + p;
                n = n/10;
            }
            if( k == r)
                return true;
            else
                return false;
        };

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        String output[] = new String[3];

        for (int i = 0; i < num; i++)
        {
            int ch = scanner.nextInt();
            int no = scanner.nextInt();
            switch (ch)
            {
                case 1:
                    if (isOdd.perform(no))
                        output[i] = "ODD";
                    else
                        output[i] = "EVEN";
                    break;

                case 2:
                    if (isPrime.perform(no))
                        output[i] = "PRIME";
                    else
                        output[i] = "COMPOSITE";
                    break;
                case 3:
                    if (isPalindrome.perform(no))
                        output[i] = "PALINDROME";
                    else
                        output[i] = "NOT A PALINDROME";
            }
        }
        for(int i=0;i<3;i++)
            System.out.println(output[i]);
    }
}
