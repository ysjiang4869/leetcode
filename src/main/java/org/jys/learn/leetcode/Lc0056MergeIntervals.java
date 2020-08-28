package org.jys.learn.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author YueSong Jiang
 * @date 2020/6/19
 */
public class Lc0056MergeIntervals {

    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Solution solution=new Solution();
        System.out.println(Arrays.deepToString(solution.merge(arr)));
        arr=new int[][]{{1,4},{0,4}};
        System.out.println(Arrays.deepToString(solution.merge(arr)));
    }

    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            if(intervals.length<=1){
                return intervals;
            }
            int index=0;

            for(int i=1;i<intervals.length;i++){
                int[] pre=intervals[index];
                if(intervals[i][0]>pre[1]){
                    intervals[++index]=intervals[i];
                }else{
                    pre[1]=Math.max(intervals[i][1],pre[1]);
                }
            }

            return Arrays.copyOfRange(intervals,0,index+1);
        }
    }
}
