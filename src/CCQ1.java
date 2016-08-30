import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by alpb0130 on 3/10/16.
 */
public class CCQ1 {
    private final String teamName = "Mr.Sixs";
    private final String awsAcount = "030360961012";
    private final String secretKeyX = "64266330917908644872330635228106713310880186591609208114244758680898150367880703152525200743234420230";

    public void Q1Handler(String message, String key) {

        // Get message not in spiral order
        String messageSequence = spiralparseMessage(message);

        // Get string offset from key
        BigInteger X = new BigInteger(secretKeyX);
        BigInteger Y = new BigInteger(key);
        BigInteger gcd = X.gcd(Y);
        int offset = gcd.mod(new BigInteger("25")).intValue() + 1;

        // Get original String
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < messageSequence.length(); i++) {
            int dis = messageSequence.charAt(i) - 'A';
            int newIndex = dis - offset;
            if (newIndex < 0)
                newIndex = 25 + newIndex + 1;
            str.append(Character.toString((char) ('A' + newIndex)));
        }

        // Response
        StringBuilder response = new StringBuilder();
        response.append(teamName + "," + awsAcount + "\n");
        response.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()) + "\n");
        response.append(str.toString() + "\n");
        System.out.println(response);
    }

    private String spiralparseMessage(String message) {
        StringBuilder str = new StringBuilder();
        int messageLen = message.length();
        int len = (int)Math.sqrt(messageLen);
        if (message == null || message.length() == 0) {
            return str.toString();
        }
        int upper = len - 1, lower = 0, left = 0, right = len - 1;
        while (upper >= lower && right >= left) {
            for (int i = left; i <= right; i++) {
                str.append(message.charAt(lower * len + i));
            }
            lower++;
            for (int i = lower; i <= upper; i++) {
                str.append(message.charAt(i * len + right));
            }
            right--;
            if (upper < lower) {
                break;
            }
            for (int i = right; i >= left; i--) {
                str.append(message.charAt(upper * len + i));
            }
            upper--;
            if (left > right) {
                break;
            }
            for (int i = upper; i >= lower; i--) {
                str.append(message.charAt(i * len + left));
            }
            left++;
        }
        return str.toString();
    }
}
