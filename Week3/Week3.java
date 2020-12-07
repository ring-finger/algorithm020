package com.minion.demo.homework;

import java.util.*;

/**
 * @author zev
 * @Title: 第三周作业
 * @Description:
 * @date 2020/12/620:32
 */
public class Week3 {

    public static void main(String[] args) {
        Week3 week3 = new Week3();
        week3.combine(4, 2);

        int[] nums ={1,2,3};
        week3.permute(nums);
    }


    List<List<Integer>> combineResult = new ArrayList<>();

    /**
     * 77. 组合
     * https://leetcode-cn.com/problems/combinations/
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combineMe(int n, int k) {
        if (n < 1 || k < 1)
            return null;
        combineNum(1, n, k, new ArrayList());

        return combineResult;
    }

    private void combineNum(int c, int n, int k, ArrayList ints) {
        if (ints.size() == k) {
            combineResult.add(new ArrayList<>(ints));
            return;
        }

        // 遍历可能的搜索起点
        for (int i = c; i <= n; i++) {
            // 向路径变量里添加一个数
            ints.add(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            combineNum(++i, n, k, ints);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            ints.remove(ints.size() - 1);
        }
    }
// -------------------------------------------

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    /**
     * 77. 组合 官方
     * https://leetcode-cn.com/problems/combinations/
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

//------------------------------------------------------------------------


    List<List<Integer>> permuteList = new ArrayList<>();

    //    46. 全排列
    public List<List<Integer>> permute(int[] nums) {

        if (nums.length<1){
           return permuteList;
        }
        permuteNums(0,nums,new LinkedList<Integer>());
        return permuteList;
    }

    /**
     *
     * @param start
     * @param nums
     * @param ints
     */
    private void permuteNums(int start, int[] nums, LinkedList<Integer> ints) {

        if (ints.size() == nums.length){
            permuteList.add(new LinkedList<>(ints));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if(ints.contains(nums[j])) continue;
            ints.add(nums[j]);
            permuteNums(j,nums,ints);
            ints.removeLast();
        }
    }
}
