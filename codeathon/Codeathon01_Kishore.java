/*
 * Core Java Problem Solving - Codeathon.
 * A.R. Kishore Kumar ~ (c) 2023 ~ -- ~ Tirupati, Andhra Pradesh, India ~
 *
 */

package codeathon;

import java.util.Scanner;

public class Codeathon01_Kishore
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();                  // To store number of user names
        String usernames[] = new String[n];    // To store an array of user names
        String results[];                     // To store YES / NO  values

        for (int i = 0; i < n; i++)                    // Storing n number of user names
            usernames[i] = sc.next();

        //calling method possibleChanges with usernames
        results = UsernamesDictionaryLogic.possibleChanges(usernames);

        //displaying the results of possible changes YES / NO for user names
        for (int i = 0; i < n; i++)
            System.out.println(results[i] + "\t");
    }
}

class UsernamesDictionaryLogic
{
    // method to know possible changes in each user name
    public static String[] possibleChanges(String usernames[])
    {
        int n = usernames.length;
        String results[] = new String[n];

        int check;
        // starting from first user name, checking each user name for possible changes
        for(int i=0;i<n;i++)
        {
            check=0;
            String dummy = usernames[i].toLowerCase();
            // checking for possible change in the user name by comparing the characters
            for(int j=1; j<dummy.length(); j++)
            {
                if ((dummy.charAt(j-1))> (dummy.charAt(j)))
                {
                    check++;
                }
            }
            if (check > 0)
                results[i]="YES";
            else
                results[i]="NO";
        }
        return results;
    }
}

