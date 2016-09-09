import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alpb0130 on 9/6/16.
 */
public class VMware3 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        List<String> strList = new ArrayList<String>();
        while (in.hasNextLine()) {
            strList.add(in.nextLine());
        }
        System.out.println(getComment(strList));
    }

    public static String getComment(List<String> list) {
        boolean isComment = false;
        StringBuilder res = new StringBuilder();
        for (String str : list) {
            int index_1 = -1, index_2 = -1, index_3 = -1;
            if (!isComment) {
                if (str.contains("//")) index_1 = str.indexOf("//");
                if (str.contains("/*")) index_2 = str.indexOf("/*");
                if (str.contains("*/")) index_3 = str.indexOf("*/");
                if (index_1 != -1 && index_2 != -1) {
                    if (index_1 < index_2) {
                        res.append(str.substring(index_1));
                        res.append("\n");
                    } else if (index_1 > index_2) {
                        isComment = true;
                        if (index_3 != -1 && index_3 > index_2) {
                            res.append(str.substring(index_2, index_3 + 2));
                            isComment = false;
                        } else {
                            res.append(str.substring(index_2));
                        }
                        res.append("\n");
                        continue;
                    }
                } else if (index_1 != -1) {
                    res.append(str.substring(index_1));
                    res.append("\n");
                } else if (index_2 != -1) {
                    isComment = true;
                    if (index_3 != -1 && index_3 > index_2) {
                        res.append(str.substring(index_2, index_3 + 2));
                        isComment = false;
                    } else {
                        res.append(str.substring(index_2));
                    }
                    res.append("\n");
                    continue;
                }
            }
            if (isComment) {
                if (str.contains("*/")) {
                    index_3 = str.indexOf("*/");
                    isComment = false;
                }
                if (index_3 > index_1) res.append(str.substring(0, index_3 + 2).trim());
                else res.append(str.trim());
                res.append("\n");
            }
        }
        return res.toString();
    }
}
