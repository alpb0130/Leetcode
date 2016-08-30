/**
 * Created by alpb0130 on 2/13/16.
 * <p>
 * Merge Two Sorted Array
 * <p>
 * 将两个排序好的等长的array合并成一个
 */
public class GoDaddy2 {
    public int[] merge(int[] arr1, int[] arr2) {
        if (arr1.length == 0) return arr1;
        int l = arr1.length;
        int[] ret = new int[2 * l];
        int i = 0, j = 0, k = 0;
        while (i + j < (2 * l)) {
            if (i < l && j < l) {
                if (arr1[i] < arr2[j]) {
                    ret[k++] = arr1[i++];
                } else {
                    ret[k++] = arr2[j++];
                }
            } else {
                ret[k++] = i < l ? arr1[i++] : arr2[j++];
            }
        }
        return ret;
    }
}
