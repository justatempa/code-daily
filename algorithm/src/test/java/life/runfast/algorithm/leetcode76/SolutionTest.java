package life.runfast.algorithm.leetcode76;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/27 20:25
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Test
    public void mergeAlternately() {

        System.out.println(solution.mergeAlternately("", ""));
        System.out.println(solution.mergeAlternately("aa", ""));
        System.out.println(solution.mergeAlternately("a", "b"));
        System.out.println(solution.mergeAlternately("abc", "defhij"));
        System.out.println(solution.mergeAlternately("123", "1"));
    }

    @Test
    public void gcdOfStrings(){
        System.out.println(solution.gcdOfStrings("", ""));
        System.out.println(solution.gcdOfStrings("a", ""));
        System.out.println(solution.gcdOfStrings("aaa", "a"));
        System.out.println(solution.gcdOfStrings("a", "b"));
        System.out.println(solution.gcdOfStrings("abab", "abb"));
    }
}
