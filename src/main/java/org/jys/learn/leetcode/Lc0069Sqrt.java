package org.jys.learn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YueSong Jiang
 * @date 2020/3/19
 *
 *
 */
public class Lc0069Sqrt {

    public static void main(String[] args) {
        Solution solution=new Solution();
        for (int i = 0; i < 1000; i++) {
            if(solution.sqrt(i)!=(int)(Math.sqrt(i))){
                System.out.println("wrong answer with "+i);
            }
        }
    }

    static class Solution {
        public int sqrt(int x){
            if (x < 0) {
                throw  new RuntimeException("not valid num");
            }
            if(x<=1){
                return x;
            }
            int left=1;
            int right=x-1;
            while (left<=right){
                int mid=left+((right-left)>>1);
                if(mid<=x/mid && (mid+1)>x/(mid+1)){
                    //判断命中条件
                    return mid;
                }else if(mid<x/(mid)){
                    //其他条件，注意这里要使用mid进行判断，之前使用mid+1导致判断出错了
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }

            return -1;
        }
    }
}
