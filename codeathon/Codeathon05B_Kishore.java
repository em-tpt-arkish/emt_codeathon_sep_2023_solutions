/*
 * Core Java Problem Solving - Codeathon.
 * A.R. Kishore Kumar ~ (c) 2023 ~ -- ~ Tirupati, Andhra Pradesh, India ~
 *
 */

package codeathon;

import java.util.Scanner;
public class Codeathon05B_Kishore
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("var1 = ");
        int var1 = sc.nextInt();
        System.out.print("var2 = ");
        int var2 = sc.nextInt();
        // logic to swap two numbers without using thrid variable in
        // a single line
        var1 = (var1+var2) - (var2 = var1);
        var1 = (int) Math.round (var1* 0.10 )  ;
        var2 = (int) Math.round (var2* 0.20 )  ;
        System.out.println("var1=" + var1 + ", var2=" + var2);
    }
}
