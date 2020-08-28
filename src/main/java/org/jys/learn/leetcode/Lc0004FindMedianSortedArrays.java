package org.jys.learn.leetcode;

/**
 * [4] Median of Two Sorted Arrays
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * <p>
 * algorithms
 * Hard (26.36%)
 * Likes:    4421
 * Dislikes: 606
 * Total Accepted:    447.1K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,3]\n[2]'
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 *
 * @author YueSong Jiang
 * @date 2019/11/16
 */
public class Lc0004FindMedianSortedArrays {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;

            //假设m<=n
            //为什么这么假设？遍历比较小的数组可以节省时间
            if (m > n) {
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
                m = nums1.length;
                n = nums2.length;
            }

            //按照标准二分法来写
            int left = 0;
            int right = m;
            int half = (m + n + 1) / 2; //如果是奇数个，中位数应该在左侧
            while (left <= right) {
                int i = left + ((right - left) >> 1);
                int j = half - i;
                if (i > 0 && nums1[i - 1] > nums2[j]) {
                    //i太大了
                    right = i - 1;
                } else if (j > 0 && nums2[j - 1] > nums1[i]) {
                    //j太大了，即i太小了
                    left = i + 1;
                } else {
                    //nums2[j-1]<nums1[i]&& nums1[i-1]<nums2[j]
                    //or j==0 or i==0
                    //左边两遍的最大值
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums2[j - 1], nums1[i - 1]);
                    }

                    //如果是奇数个数字，maxLeft就是medium
                    if ((m + n) % 2 == 0) {
                        return maxLeft;
                    }

                    //寻找右侧最小值
                    int minRight;
                    //处理越界的情况
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums2[j], nums1[i]);
                    }
                    return (maxLeft + minRight) / 2.0;
                }
            }

            return 0.0;
        }
    }
}
