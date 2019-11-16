package org.jys.learn.leetcode;

/**
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (26.36%)
 * Likes:    4421
 * Dislikes: 606
 * Total Accepted:    447.1K
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 *
 * Example 2:
 *
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
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
            if (m > n) { // to ensure m<=n
                int[] temp = nums1; nums1 = nums2; nums2 = temp;
                int tmp = m; m = n; n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                //i<iMax to prevent i==iMax, same as flow,
                //j get from calculate, so no need to care
                if (i < iMax && nums2[j-1] > nums1[i]){
                    iMin = i + 1; // i is too small
                }
                else if (i > iMin && nums1[i-1] > nums2[j]) {
                    iMax = i - 1; // i is too big
                }
                else { // i is perfect
                    int maxLeft = 0;
                    //process left bandage situation
                    if (i == 0) { maxLeft = nums2[j-1]; }
                    else if (j == 0) { maxLeft = nums1[i-1]; }
                    else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }


                    int minRight = 0;
                    //process right bandage situation
                    if (i == m) { minRight = nums2[j]; }
                    else if (j == n) { minRight = nums1[i]; }
                    else { minRight = Math.min(nums2[j], nums1[i]); }


                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }
    }

}
