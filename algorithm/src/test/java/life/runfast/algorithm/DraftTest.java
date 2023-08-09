package life.runfast.algorithm;

import life.runfast.algorithm.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/24 10:25
 */
public class DraftTest {

    @Test
    public void testparentheses1() {
        Draft draft = new Draft();
        Assert.assertTrue(draft.parentheses1("()()()"));
        //Assert.assertTrue(draft.parentheses1("[{()}{([])}]{(})"));
        Assert.assertTrue(draft.parentheses1("[]{}()"));
        Assert.assertTrue(draft.parentheses1("{[()]}"));
        Assert.assertFalse(draft.parentheses1(""));
        Assert.assertFalse(draft.parentheses1("((((("));
        Assert.assertFalse(draft.parentheses1("(()]"));
        Assert.assertFalse(draft.parentheses1("(()"));
        Assert.assertFalse(draft.parentheses1("([{)])"));
    }

    @Test
    public void testSplit() {
        Arrays.stream("1    2".split(" ")).forEach(System.out::println);
    }


    @Test
    public void testGenerateInt() {
        ListNode<Integer> integerListNode = ListNode.generateInt(5);
        ListNode.print(integerListNode);
    }

    @Test
    public void findN() {
        ListNode<Integer> integerListNode = ListNode.generateInt(1);
        Draft draft = new Draft();
        ListNode<Integer> n = draft.findN(integerListNode, 1);
        System.out.println(n.getData());

        //System.out.println(draft.findN(integerListNode, 5).getData());

    }

    @Test
    public void deleteN() {
        ListNode<Integer> integerListNode = ListNode.generateInt(1);
        Draft draft = new Draft();
        ListNode<Integer> integerListNode1 = draft.deleteN(integerListNode, 1);
        ListNode.print(integerListNode1);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums1) {
            set.add(n);
        }

        for(int n : nums2) {
            if(set.add(n)) {
                set.remove(n);
            }
        }


    }

}
