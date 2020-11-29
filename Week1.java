package com.minion.demo.homework;

/**
 * @author zev
 * @Title:
 * @Description: 第一周作业
 * @date 2020/11/2915:03
 */
public class Week1 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        Week1 w = new Week1();
        w.moveZeroes(nums);
    }

    /**
     * 旋转数组
     *  https://leetcode-cn.com/problems/rotate-array/
     * @param nums
     * @param k
     */
   public void rotate(int[] nums, int k) {
       int length = nums.length;
       if(length > 1){
           if (k > length){
               k  = k - length;
           }
           int[] result = new int[length];
           System.arraycopy(nums,length-k,result,0,k);
           System.arraycopy(nums,0,result,k,length-k);
           System.arraycopy(result,0,nums,0,length);
       }
    }

    /**
     * 旋转数组
     * 暴力求解
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int b = 0;
        for(int n = 1; n <= k;n++){
            b = nums[nums.length-1];
            System.arraycopy(nums,0,nums,1,nums.length-1);
            nums[0] = b;
        }
    }

    /**
     * https://leetcode-cn.com/problems/move-zeroes/
     * 移动0
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums != null && nums.length>1) {
            int m = 0;
            for (int n = 0; n < nums.length; n++) {
                if(nums[n]!=0) {
                    int tmp = nums[n];
                    nums[n] = nums[m];
                    nums[m++] = tmp;
                }
            }
        }
    }
}
