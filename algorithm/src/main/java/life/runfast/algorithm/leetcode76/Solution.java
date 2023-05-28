package life.runfast.algorithm.leetcode76;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
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
     * <p>
     * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
     *
     * @param str1:
     * @param str2:
     * @author justatempa
     * @date 2023/5/27
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

    /**
     * 1431. 拥有最多糖果的孩子
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     *
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     *
     *https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
     * @param candies:
     * @param extraCandies:
     * @author justatempa
     * @date 2023/5/28
     * @return: java.util.List<java.lang.Boolean>
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if(candies == null || candies.length == 0) {
            return new ArrayList<>();
        }
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }
    /**
     * 605. 种花问题
     * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     *
     * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
     * https://leetcode.cn/problems/can-place-flowers/
     * @author justatempa
     * @date 2023/5/28
     * @param flowerbed:
     * @param n:
     * @return: boolean
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeroCount = 1;
        int flower = 0;
        for (int i : flowerbed) {
            if(i == 0) {
                zeroCount++;
            } else {
                flower += (zeroCount - 1) / 2;
                if(flower >= n) {
                    return true;
                }
                zeroCount = 0;
            }
        }
        zeroCount++;
        flower += (zeroCount - 1) / 2;
        return flower >= n;
    }
}
