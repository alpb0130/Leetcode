import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by alpb0130 on 1/12/16.
 * <p>
 * 313. Super Ugly Number
 * <p>
 * Write a program to find the n^th super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are
 * in the given prime list primes of size k. For example, [1, 2, 4, 7, 8,
 * 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super
 * ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * <p>
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 */
public class SuperUglyNumber {
    // Time complexity: O(nlogn). Space complexity: O(n * k). Memory limit exceeded. Use heap and set.
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) return 1;
        HashSet<Long> set = new HashSet<Long>();
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        set.add(new Long(1));
        int size = 1;
        Long previous = new Long(1);
        while (size != n) {
            for (int j = 0; j < primes.length; j++) {
                queue.offer(previous * primes[j]);
            }
            while (!set.add(queue.peek())) {
                queue.poll();
            }
            previous = queue.peek();
            queue.poll();
            size++;
        }
        return previous.intValue();
    }

    // Just use array to record number.
    // Time complexity: O(n * k). Space complexity: O(n + k).
    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] ret = new int[n];
        ret[0] = 1;
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i++) {
            ret[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                ret[i] = Math.min(ret[i], primes[j] * ret[index[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (ret[i] == primes[j] * ret[index[j]])
                    index[j]++;
            }
        }
        return ret[n - 1];
    }
}
