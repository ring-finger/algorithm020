package com.minion.demo.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zev
 * @Title:
 * @Description:
 * @date 2020/12/1318:09
 */
public class Week4 {

    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};

        Week4 week4 = new Week4();
        week4.findContentChildren(g,s);

    }

    //455. 分发饼干
    // https://leetcode-cn.com/problems/assign-cookies/description/

    /**
     * 贪心算法
     * @param g 孩子
     * @param s 饼干
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
       if (g.length == 0 || s.length == 0)
           return 0;
       Arrays.sort(g);
       Arrays.sort(s);
       int child = 0;
       int cookie = 0;

       while (child < g.length && cookie < s.length){
           if (g[child] <= s[cookie]){
               child++;
           }
           cookie++;
       }

       return child;
    }


    //55. 跳跃游戏
    //https://leetcode-cn.com/problems/jump-game/

    /**
     * 贪心算法：计算从后往前能否走通
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0)
            return false;
        int i = nums.length-1;
        for (int j = nums.length-1; j >= 0; j--) {
           if (nums[j] + j >= i){
               i = nums[j];
           }

        }
        return i == 0;

    }

    /**
     * 126. 单词接龙 II
     * https://leetcode-cn.com/problems/word-ladder-ii/
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<String> woeds = new ArrayList<>();

        return null;
    }
}
