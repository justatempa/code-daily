package life.runfast.algorithm;

import life.runfast.algorithm.utils.ListNode;

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

    public ListNode<Integer> reserve(ListNode<Integer> root) {
        if(root == null) {
            return null;
        }
        ListNode<Integer> prev = null;
        ListNode<Integer> cur = root;

        while(cur != null) {
            ListNode<Integer> next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public <T> ListNode<T> deleteN(ListNode<T> root, int n) {
        ListNode<T> head = new ListNode<>(null, root);
        ListNode<T> n1 = findN(head, n + 1);
        n1.setNext(n1.getNext().getNext());
        return head.getNext();
    }

    // 找到倒数第N个
    public <T> ListNode<T> findN(ListNode<T> root, int n) {
        //ListNode<T> head = new ListNode<>(null, root);
        ListNode<T> p1 = root;
        ListNode<T> p2 = root;
        while(n-- > 0) {
            p2 = p2.getNext();
        }
        while(p2 != null) {
            p1 = p1.getNext();
            p2 =p2.getNext();
        }
        return p1;
    }
}
