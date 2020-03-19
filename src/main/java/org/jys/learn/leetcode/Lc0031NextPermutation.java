package org.jys.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YueSong Jiang
 * @date 2020/3/19
 */
public class Lc0031NextPermutation {

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{1,1,2,3,3,4,5,6};
        List<int[]> orderedNums=new ArrayList<>();
        while (getNum(nums)!=65433211){
            solution.nextPermutation(nums);
            System.out.println(Arrays.toString(nums));
            orderedNums.add(nums);
        }
        for (int i = 1; i < orderedNums.size(); i++) {
            if(getNum(orderedNums.get(i))<getNum(orderedNums.get(i-1))){
                System.out.println("error");
                break;
            }
        }
    }

    private static int getNum(int[] nums){
        int m=1;
        int ret=0;
        for (int i = nums.length-1; i >=0; i--) {
            ret+=m*nums[i];
            m*=10;
        }
        return ret;
    }

    static class Solution {
        public void nextPermutation(int[] nums) {

            int len=nums.length;
            for(int i=len-1; i>0;i--){
                if(nums[i]>nums[i-1]){
                    //i-1 is the desc value
                    for(int j=i;j<len;j++){
                        //attention: >=
                        if(nums[i-1]>=nums[j]){
                            swap(nums, i-1, j-1);
                            reverse(nums, i, len-1);
                            return;
                        }
                        //all after i-1 is bigger than i-1
                        if(j==len-1){
                            swap(nums, i-1, j);
                            reverse(nums, i, len-1);
                            return;
                        }
                    }
                }
            }

            //all is asc
            reverse(nums, 0, len-1);

        }

        public void swap(int[] nums, int i, int j){
            int tmp=nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
        }

        public void reverse(int[] nums, int i, int j){
            while(i<j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }
    }
}
