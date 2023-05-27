package life.runfast.algorithm.daily;

import java.util.Arrays;

/**
 * @author justatempa
 * @description
 * @datetime 2023/5/24 9:25
 */
public class LeetcodeDaily {
    /**
     * minimum ：样本中的最小元素。
     * maximum ：样品中的最大元素。
     * mean ：样本的平均值，计算为所有元素的总和除以元素总数。
     * median ：
     * 如果样本的元素个数是奇数，那么一旦样本排序后，中位数 median 就是中间的元素。
     * 如果样本中有偶数个元素，那么中位数median 就是样本排序后中间两个元素的平均值。
     * mode ：样本中出现次数最多的数字。保众数是 唯一 的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/statistics-from-a-large-sample
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * https://leetcode.cn/problems/statistics-from-a-large-sample/
     * @author justatempa
     * @date 2023/5/27
     * @param count:
     * @return: double[]
     */
    public double[] sampleStats(int[] count) {
        int minimum = 256;
        int maxinum = 0;
        double mean = 0;
        double median = 0;
        int mode = 0;
        int total = Arrays.stream(count).sum();
        int left = (total + 1) / 2;
        int right = (total + 2) / 2;
        long sum = 0;
        int maxFreq = 0;
        int cnt = 0;

        for (int i = 0; i < count.length; i++) {
            sum += (long)i * count[i];
            if(count[i] > maxFreq) {
                maxFreq = count[i];
                mode = i;
            }

            if(count[i] > 0) {
                if(minimum == 256) {
                    minimum = i;
                }
                maxinum = i;
            }

            if(cnt < left && cnt + count[i] >= left) {
                median += i;
            }
            if(cnt < right && cnt + count[i] >= right) {
                median += i;
            }
            cnt += count[i];
        }

        mean = (double)sum / total;
        median= median / 2.0;
        return new double[]{minimum, maxinum, mean, median, mode};

    }
}

class Ld1377 {

}