/**
 * Created by alpb0130 on 9/25/15.
 */
import java.util.Arrays;
public class Imc1 {
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int mergeTime = 0;
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++){

            mergeTime += (A.length - i) * A[i];
        }
        mergeTime -= A[0];
        return mergeTime;
    }
}
