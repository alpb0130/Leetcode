import java.util.Stack;

/**
 * Created by alpb0130 on 9/24/16.
 * <p>
 * 20. Valid Parentheses  QuestionEditorial Solution
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not
 */
public class ValidParentheses {
    // Time: O(n)
    // Space: O(n)
    // Use stack. Be careful about stack empty.
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')') {
                // Be careful
                if (stack.isEmpty()) return false;
                char p = stack.pop();
                if (p == '{' && s.charAt(i) != '}') return false;
                if (p == '[' && s.charAt(i) != ']') return false;
                if (p == '(' && s.charAt(i) != ')') return false;
            }
        }
        // Be careful
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
