/**
 * Created by alpb0130 on 10/10/15.
 */

import java.util.Scanner;

public class P6_23 {
//    public static void main(String[] args) {
//        String[] ary = new String[100];
//        String[] name = new String[100];
//        int[] count = new int[100];
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("please enter the number of the line:");
//        int line = in.nextInt();
//        System.out.println("please enter the name and value of each line:");
//        int size = 0;
//        while (size < line) {
//            ary[size] = in.nextLine();
//            size++;
//        }
//        // using num to find where the name ends and the number starts
//        for (int j = 0; j < line; j++) {
//            int num = 0;
//            while (!Character.isDigit(ary[j].charAt(num))) {
//                num++;
//            }
//            name[j] = ary[j].substring(0, num);
//            count[j] = Integer.parseInt(ary[j].substring(num));
//            name[j] = name[j].trim();
//            // trim method returns the string with all white space at the beginning and the end removed
//        }
//
//        int max = count[0];
//        for (int j = 0; j < line; j++) {
//            if (count[j] > max) {
//                max = count[j];
//            }
//
//        }
//        // System.out.println(max);
//        for (int i = 0; i < line; i++) {
//            if (count[i] == max) {
//                System.out.print(name[i]);
//                for (int j = 0; j < 40; j++) {
//                    System.out.print("*");
//                }
//                System.out.println("");
//            }
//            if (count[i] != max && max != 0) {
//                System.out.print(name[i]);
//                double duo = (double) count[i] / max;
//                int len = (int) (duo * 40);
//
//                for (int j = 0; j < len; j++) {
//                    System.out.print("*");
//                }
//
//                System.out.println("");
//
//            }
//
//        }
//
//    }
}
