import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by alpb0130 on 11/9/15.
 * <p>
 * Twitter Coding Challenge 1
 */
public class Twitter1 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        int _len;
        _len = Integer.parseInt(in.nextLine());

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = closestNumbers(_len, _s);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    static String closestNumbers(int len, String s) {
        String[] numbersStr = s.split(" ");
        StringBuffer numberPair = new StringBuffer();
        long[] numbers = new long[len];
        for (int i = 0; i < len; i++)
            numbers[i] = Long.parseLong(numbersStr[i]);
        Arrays.sort(numbers);
        long smallDiff = numbers[1] - numbers[0];
        for (int i = 2; i < len; i++)
            if (numbers[i] - numbers[i - 1] < smallDiff)
                smallDiff = numbers[i] - numbers[i - 1];
        for (int i = 1; i < len; i++)
            if (numbers[i] - numbers[i - 1] == smallDiff) {
                numberPair.append(numbers[i - 1]);
                numberPair.append(" ");
                numberPair.append(numbers[i]);
                numberPair.append(" ");
            }
        return numberPair.toString();
    }
}
