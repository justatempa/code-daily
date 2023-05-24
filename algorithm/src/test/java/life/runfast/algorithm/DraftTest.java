package life.runfast.algorithm;

import org.junit.Assert;
import org.junit.Test;

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

}
