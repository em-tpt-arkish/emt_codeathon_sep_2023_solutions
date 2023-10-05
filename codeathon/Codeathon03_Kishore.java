/*
 * Core Java Problem Solving - Codeathon.
 * A.R. Kishore Kumar ~ (c) 2023 ~ -- ~ Tirupati, Andhra Pradesh, India ~
 *
 */

package codeathon;

import java.util.Scanner;
public class Codeathon03_Kishore
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          // Total Number of Trees
        int[] heights = new int[n];    // Heights of the Trees
        for (int i = 0; i < n; i++)
        {
            heights[i] = sc.nextInt();
        }
        int maxTravelTime = 0;
        int clockwiseLength, anticlockwiseLength, shorterLength, totalLength;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                clockwiseLength = (n - j + i) % n;         // clockwise length
                anticlockwiseLength = (j - i + n) % n;     // anti-clockwise  length
                shorterLength = Math.min(clockwiseLength, anticlockwiseLength);
                totalLength = shorterLength + heights[i] + heights[j];  // maximum path length
                if (totalLength > maxTravelTime)
                {
                    maxTravelTime = totalLength;      // maximum travel time
                }
            }
        }
        System.out.println(maxTravelTime);
    }
}
