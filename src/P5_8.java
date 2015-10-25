/**
 * Created by alpb0130 on 10/9/15.
 */

import java.util.Scanner;

public class P5_8 {

    public static boolean sameElements(int[] a, int[] b) {
        int lena = a.length;
        int lenb = b.length;
        boolean same = true;
        if (lena != lenb) {
            System.out.println("not the same");
            same = false;
        } else {
            for (int i = 0; i < lena; i++) {
                if (a[i] != b[i]) {
                    same = false;
                    break;
                }
            }
        }
        if (same) System.out.println("same");
        return same;
    }

//    public static void main(String[] arg) {
//        Scanner in = new Scanner(System.in);
//        int[] a = new int[10];
//        int[] b = new int[10];
//        int i = 0;
//        while (in.hasNext()) {
//            if (i < a.length) {
//                a[i] = in.nextInt();
//                i++;
//            }
//        }
//        int j = 0;
//        while (in.hasNext()) {
//            if (j < b.length) {
//                b[j] = in.nextInt();
//                j++;
//            }
//        }
//        boolean same = sameElements(a, b);
//        System.out.println("result:" + same);
//    }
}

