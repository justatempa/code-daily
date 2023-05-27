package life.runfast.algorithm.leetcode76;

import java.util.function.Function;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/27 20:15
 */
public class Solution {
    /**
     * 1768. 交替合并字符串
     * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
     * <p>
     * 返回 合并后的字符串 。
     *
     * @author justatempa
     * @date 2023/5/27
     * @param word1:
     * @param word2:
     * @return: java.lang.String
     */
    Function<String, String> format = a -> a == null ? "" : a;

    public String mergeAlternately(String word1, String word2) {
        word1 = format.apply(word1);
        word2 = format.apply(word2);
        int a = word1.length();
        int b = word2.length();
        char[] sb = new char[a + b];
        int i = 0;
        int index = 0;
        while (i < a && i < b) {
            sb[index] = word1.charAt(i);
            sb[index + 1] = word2.charAt(i);
            i++;
            index += 2;
        }
        while (i < a) {
            sb[index] = word1.charAt(i);
            i++;
            index++;
        }
        while (i < b) {
            sb[index] = word2.charAt(i);
            i++;
            index++;
        }
        return new String(sb);
    }

    /**
     * https://leetcode.cn/problems/greatest-common-divisor-of-strings/
     * 1071. 字符串的最大公因子
     * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
     *
     * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
     * @author justatempa
     * @date 2023/5/27
     * @param str1:
     * @param str2:
     * @return: java.lang.String
     */
    public String gcdOfStrings(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int i = 0;
        while (i < length && (str1.charAt(i) == str2.charAt(i))) {
            i++;
        }
        while (i > 0) {
            String sbuStr = str1.substring(0, i);
            if (sub(str1, sbuStr) && sub(str2, sbuStr)) {
                return sbuStr;
            }
            i--;
        }
        return "";
    }

    private boolean sub(String str, String subStr) {
        int subLen = subStr.length();
        int start = 0;
        boolean flag = false;
        while (subLen > 0 && str.length() % subLen == 0 && start < str.length()) {
            if (!subStr.equals(str.substring(start, start + subLen))) {
                return false;
            }
            flag = true;
            start += subLen;
        }
        return flag;
    }
}
