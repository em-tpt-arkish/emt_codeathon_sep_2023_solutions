/*
 * Core Java Problem Solving - Codeathon.
 * A.R. Kishore Kumar ~ (c) 2023 ~ -- ~ Tirupati, Andhra Pradesh, India ~
 *
 */

package codeathon;

import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Codeathon02_Kishore
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // Number of Elements in customers
        List<String> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {    // Number of times trade by Customers
            customers.add( sc.next() );
        }
        List<String> result = ActiveTraders.mostActive(customers);

        // Print the result in alphabetical order
        Collections.sort(result);
        for (String customer : result) {
            System.out.println(customer);
        }
    }
}
class ActiveTraders
{
    public static List<String> mostActive(List<String> customers)
    {
        int n = customers.size();
        Map<String, Integer> customerCounts = new HashMap<>();

        // Count the occurrences of each customer
        for (int i = 0; i < customers.size(); i++)
        {
            String customer = customers.get(i);

            if (customerCounts.containsKey(customer)) {
                int count = customerCounts.get(customer);
                customerCounts.put(customer, count + 1);
            } else {
                customerCounts.put(customer, 1);
            }
        }

        // Calculate the threshold for 5% of total trades
        int threshold = (int) Math.ceil(n * 0.05);
        // Find customers with trades >= threshold
        List<String> activeCustomers = new ArrayList<>();
        for (String customer : customerCounts.keySet()) {
            if (customerCounts.get(customer) >= threshold) {
                activeCustomers.add(customer);
            }
        }
        return activeCustomers;
    }
}
