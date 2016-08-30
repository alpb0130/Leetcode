/**
 * Created by alpb0130 on 2/5/16.
 * <p>
 * 168. Excel Sheet Column Title
 * <p>
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder str = new StringBuilder();
        if (n < 0) return str.toString();
        while (n != 0) {
            char c = (char) ('A' + (n - 1) % 26);
            str.insert(0, c);
            n = (n - 1) / 26;
        }
        return str.toString();
    }
}
