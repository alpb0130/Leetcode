/**
 * Created by alpb0130 on 10/25/15.
 * <p>
 * Yelp V3: Sparse matrix dot product
 */

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        int length_a, length_b;
        length_a = in.nextInt();
        length_b = in.nextInt();
        int[] index_a = new int[length_a];
        int[] val_a = new int[length_a];
        int[] index_b = new int[length_b];
        int[] val_b = new int[length_b];
        for (int i = 0; i < length_a; i++) {
            index_a[i] = in.nextInt();
            val_a[i] = in.nextInt();
        }
        for (int i = 0; i < length_b; i++) {
            index_b[i] = in.nextInt();
            val_b[i] = in.nextInt();
        }
        int j = 0, k = 0, sum = 0;
        while (j < length_a && k < length_b) {
            if (index_a[j] < index_b[k])
                j++;
            else if (index_a[j] > index_b[k])
                k++;
            else if (index_a[j] == index_b[k]) {
                sum += val_a[j] * val_b[k];
                j++;
                k++;
            }
        }
        System.out.println(sum);
    }
}
