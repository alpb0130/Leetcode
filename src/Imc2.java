/**
 * Created by alpb0130 on 9/26/15.
 */
public class Imc2 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int circleLen = 0;
        int index = 0;
        int tempIndex = 0;
        int count = -1;
        do {
            tempIndex = A[index];
            A[index] = count;
            index = tempIndex;
            if (A[index] < 0) {
                circleLen = A[index] - count + 1;
                break;
            }
            count--;
        } while (true);
        return circleLen;
    }
}
