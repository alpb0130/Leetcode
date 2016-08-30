import java.util.Arrays;

/**
 * Created by alpb0130 on 2/13/16.
 * <p>
 * Zigzag Array. 给定一个nums数组，按照下面指定的顺序输出:
 * 最大，最小，第二大，第二小，第三大，第三小，....
 */
public class GoDaddy3 {
    public int[] zigzagArray(int[] array) {
        if (array == null || array.length < 2) return array;
        Arrays.sort(array);
        int[] ret = new int[array.length];
        int i = 0, j = array.length - 1;
        int index = 0;
        while (i <= j) {
            ret[index++] = array[j--];
            if (index == array.length) break;
            ret[index++] = array[i++];
        }
        return ret;
    }
}
