package life.runfast.algorithm;

import java.util.Stack;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/24 10:12
 */
public class Draft {
    public boolean parentheses(String s) {
        if(s == null || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && isParent(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    boolean isParent(Character a, Character b) {
        return (a == '(' && b == ')') ||
                (a == '[' && b == ']') ||
                (a == '{' && b == '}');
    }

    boolean isParent2(Character a, Character b) {
        return !((a == '(' && b != ')') ||
                (a == '[' && b != ']') ||
                (a == '{' && b != '}'));
    }
    public boolean parentheses1(String s) {
        if(s == null || s.length() % 2 != 0 || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c == ']' || c == ')' || c == '}') {
                if(stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if(!isParent(pop, c)) {
                    return false;
                }
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
