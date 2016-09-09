import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by alpb0130 on 9/6/16.
 * <p>
 * Detect the Domain Name
 * link: https://www.hackerrank.com/challenges/detect-the-domain-name
 */
public class VMware4 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int lineNum = in.nextInt();
        Set<String> set = new HashSet<String>();
        String res = null;
        for (int i = 0; i < lineNum; i++) {
            res = getDomain(in.nextLine());
            if (res != null) set.add(res);
        }
        TreeSet<String> ts = new TreeSet<String>(set);
        StringBuilder sb = new StringBuilder("");
        for (String str : ts) {
            if (!sb.toString().equals(""))
                sb.append(";");
            sb.append(str);
        }
        System.out.println(sb.toString());
    }

    public static String getDomain(String str) {
        Pattern pattern = Pattern.compile("https?://(www.|ww2.)?(([a-zA-Z0-9]+\\.)+(com|cn|gov|cc|org|in))");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) return matcher.group(2);
        return null;
    }
}
