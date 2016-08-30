import java.util.Arrays;

/**
 * Created by alpb0130 on 1/6/16.
 * <p>
 * 274. H-Index
 * <p>
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index
 * h if h of his/her N papers have at least h citations each, and the other N − h
 * papers have no more than h citations each."
 * <p>
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations each
 * and the remaining two with no more than 3 citations each, his h-index is 3.
 * <p>
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 * Time complexity: O(nlogn)
 * Space complexity: O(1)
 */
public class HIndex {
    // Sort the array first.
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int l = citations.length - 1, h = 1;
        for (int i = l - 1; i >= 0; i--) {
            if (citations[i] >= h) h++;
            else break;
        }
        return --h;
    }

    // More efficient method
    public int hIndex1(int[] citations) {
        int l = citations.length;
        int[] count = new int[l + 1];
        for (int i = 0; i < l; i++) {
            if (citations[i] >= l) count[l]++;
            else count[citations[i]]++;
        }
        int num = 0;
        for (int i = l; i >= 0; i--) {
            num += count[i];
            if (num >= i) return i;
        }
        return 0;
    }
}
