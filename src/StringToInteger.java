/**
 * Created by alpb0130 on 1/18/16.
 * <p>
 * 8. String to Integer (atoi)
 * <p>
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a
 * challenge, please do not see below and ask yourself what are the possible input cases.
 * <p>
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 * <p>
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature
 * accepts a const char * argument, please click the reload button  to reset your code definition.
 * <p>
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional
 * initial plus or minus sign followed by as many numerical digits as possible, and interprets
 * them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which
 * are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace
 * characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned. If the correct value
 * is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class StringToInteger {
    // My version
    public int myAtoi(String str) {
        str = str.trim();
        boolean flag = false;
        long sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                sum = sum * 10 + Character.getNumericValue(c);
                if (sum > Integer.MAX_VALUE && !flag)
                    return Integer.MAX_VALUE;
                if (sum > Math.abs(new Long(Integer.MIN_VALUE)) && flag)
                    return Integer.MIN_VALUE;
            } else if (i == 0) {
                if (c == '-')
                    flag = true;
                else if (c == '+')
                    flag = false;
                else
                    return 0;

            } else
                break;
        }
        if (flag) sum = -sum;
        return Math.toIntExact(sum);
    }
    // More clean version
    public int myAtoi1(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;
    }
}
