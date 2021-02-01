package org.jys.learn.leetcode;

/**
 * @author jiangyuesong
 * @date 2021/2/1
 * @tag array
 * @tag two=pointers
 * @tag stack
 */
public class Lc0042TrappingRainWater {

    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] arr2=new int[]{4,2,0,3,2,5};
        Solution solution=new Solution();
        System.out.println(solution.trap(arr1));
        System.out.println(solution.trap(arr2));
    }

    static class Solution {
        public int trap(int[] height) {
            int ans=0;
            int leftMax=0;
            int rightMax=0;
            int left=0;
            int right=height.length-1;
            while(left<right){
                if(height[left]<height[right]){
                    if(height[left]>leftMax){
                        leftMax=height[left];
                    }else{
                        ans+=leftMax-height[left];
                    }
                    left++;
                }else{
                    if(height[right]>rightMax){
                        rightMax=height[right];
                    }else{
                        ans+=rightMax-height[right];
                    }
                    right--;
                }
            }
            return ans;
        }
    }
}
