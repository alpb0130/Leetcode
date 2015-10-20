/**
 * Created by alpb0130 on 10/13/15.
 */

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Quick_Sort {

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static int Partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int index = start - 1;
        for (int i = start; i <= end - 1; i++) {
            if (nums[i] <= pivot) {
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, index + 1, end);
        return index + 1;
    }

    public static int RandomizedPartition(int[] nums, int start, int end) {
        Random random = new Random();
        int index = random.nextInt(end - start + 1) + start;
        swap(nums, index, end);
        return Partition(nums, start, end);
    }

    public static void QuickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = RandomizedPartition(nums, start, end);
        QuickSort(nums, start, pivot - 1);
        QuickSort(nums, pivot + 1, end);
    }

    // Return the kth element
    public static int QuickSelect(int[] nums, int start, int end, int k) {
        if (k > end - start + 1) return -1;
        int pivot = Partition(nums, start, end);
        int length = pivot - start + 1;
        if (length == k) {
            return nums[pivot];
        } else if (pivot - start + 1 > k) {
            return QuickSelect(nums, start, pivot - 1, k);
        } else {
            return QuickSelect(nums, pivot + 1, end, k - length);
        }
    }

    /* public static void main(String[] args) {
         int[] nums = {4,5,3,6,3};
         System.out.println(QuickSelect(nums, 0, nums.length - 1, 1));
         System.out.println(QuickSelect(nums, 0, nums.length - 1, 2));
         System.out.println(QuickSelect(nums, 0, nums.length - 1, 3));
         System.out.println(QuickSelect(nums, 0, nums.length - 1, 4));
         System.out.println(QuickSelect(nums, 0, nums.length - 1, 5));
         QuickSort(nums, 0, nums.length - 1);
         for (int i: nums) {
             System.out.print(i + " ");
         }
     }
 }*/
    public static void main(String[] args) {
        final int LENGTH = 100;
        int[] ary = new int[LENGTH];
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the values of the set, Q to quit:");
        int size = 0;
        while (in.hasNextInt()) {
            ary[size] = in.nextInt();
            size++;
        }
        System.out.println("size" + size);
        in.next();
        int[] dis1 = new int[LENGTH];
        int[] dis2 = new int[LENGTH];
        System.out.println("size" + size);
        int median = QuickSelect(ary, 0, size - 1, size / 2); // find the median of the array
        int tmp = 0, middle = 0;
        for (int i = 0; i < size; i++) {
            if (ary[i] - median != 0) {
                dis1[tmp++] = Math.abs(ary[i] - median);
            } else middle = i;  // middle is to flag the position of median, because  distinct number , it is unique
        }

        for (int i = 0; i < size - 1; i++) {
            dis2[i] = dis1[i];
        }
        System.out.println("median" + median);
        System.out.println("meddle" + middle);
        System.out.println("Please input the value of k:");
        //int k = in.nextInt();
        int k = 4;
        System.out.println("the k closest is: ");
        int kthdis = QuickSelect(dis2, 0, size - 2, k - 1);
        int[] ary2 = new int[k];
        System.out.println("kthdis" + kthdis);
      /*System.out.println("print array");
       for(int e:ary)
       {System.out.println(ary);}
    */
        int j = 0;
        for (int i = 0; i < size - 1; i++) {
            if (dis1[i] <= kthdis) {
                if (i < middle)
                    ary2[j++] = median - dis1[i];
                else ary2[j++] = median + dis1[i];
            }

        }


        for (int i = 0; i < k; i++)
            System.out.println(ary2[i]);
    }
}
