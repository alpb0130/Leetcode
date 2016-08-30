import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by alpb0130 on 2/13/16.
 * <p>
 * Same Elements in Two Arrays
 * <p>
 * a1 = [1, 2, 3, 5, 6, 2, 7]
 * a2 = [2, 5, 2, 8, 9, 4]
 * output：[5, 2, 2]
 */
public class SameElementInTwoArray {
    public ArrayList<Integer> sameElement(int[] arr1, int[] arr2) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) return ret;

        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr1.length; i++) {
            if (hash.get(arr1[i]) == null) {
                hash.put(arr1[i], 1);
            } else {
                hash.put(arr1[i], hash.get(arr1[i]) + 1);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            Integer count = hash.get(arr2[i]);
            if (count != null && count > 0) {
                ret.add(arr2[i]);
                hash.put((arr2[i]), hash.get(arr2[i]) - 1);
            }
        }
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
        ret.sort(c);
        return ret;
    }
}
