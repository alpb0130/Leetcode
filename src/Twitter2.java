import java.util.Scanner;
import java.io.*;

/**
 * Created by alpb0130 on 11/9/15.
 * <p>
 * Twitter Coding Challenge 2
 */
public class Twitter2 {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
//        Scanner in = new Scanner(System.in);
//        int len = in.nextInt();
//        int[] bitArray = new int[len];
//        for (int i = 0; i < len; i++) {
//            bitArray[i] = in.nextInt();
//        }
//        int maxDiff = 0;
//        int flipStartIndex = 0;
//        int flipEndIndex = 0;
//        int onesToFlip = 0;
//        int totalNumberOfOnes = 0;
//
//        int currentDiff = 0;
//        int currentStart = 0;
//        int currentOnesToFlip = 0;
//
//        for (int i = 0; i < bitArray.length; i++) {
//            if (bitArray[i] == 0) {
//                currentDiff -= 1;
//            } else {
//                currentDiff += 1;
//                currentOnesToFlip++;
//                totalNumberOfOnes++;
//            }
//            if (currentDiff < maxDiff) {
//                maxDiff = currentDiff;
//                flipStartIndex = currentStart;
//                flipEndIndex = i;
//                onesToFlip = currentOnesToFlip;
//            } else if (currentDiff > 0) {
//                currentDiff = 0;
//                currentStart = i + 1;
//                currentOnesToFlip = 0;
//            }
//        }
//        System.out.println(flipEndIndex - flipStartIndex + 1 - onesToFlip +   totalNumberOfOnes - onesToFlip);

        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] bitArray = new int[len];
        for (int i = 0; i < len; i++) {
            bitArray[i] = in.nextInt();
        }
        int lower = 0, upper = 0;
        int result = 0, sum = 0;
        for (int i = 0; i < len - 1; i++) {
            int score = bitArray[i] == 0 ? 1 : -1;
            int max = i;
            int min = i;
            for (int j = i + 1; j < len; j++) {
                int newScore = score + (bitArray[j] == 0 ? 1 : -1);
                if (newScore > score) {
                    score = newScore;
                    max = j;
                }
            }
            if (score > result) {
                result = score;
                upper = max;
                lower = i;
            }


        }
        for (int i = 0; i < len; i++) {
            if (i >= lower && i <= upper && bitArray[i] == 0)
                sum++;
            else
                sum += bitArray[i];
        }
        System.out.println(sum);

//        for(std::size_t i = 0; i < N; ++i){
//            int  score = bs[i] ? -1 : 1;
//            auto max   = i;
//
//            for(std::size_t j = i + 1; j < N; ++j){
//                auto new_score = score + (bs[j] ? -1 : 1);
//
//                if(new_score > score){
//                    score = new_score;
//                    max = j;
//                }
//            }
//            if(score > overall_score){
//                overall_score = score;
//                result = {i,max};
//            }
//        }
    }
}
