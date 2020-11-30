package com.minion.demo.homework;

import java.util.*;

import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 * @author zev
 * @Title:
 * @Description: 二周
 * @date 2020/11/2920:23
 */
public class Week2 {
    public static void main(String[] args) {
        String[] test = {"eat", "tea", "tan", "ate", "nat", "bat"};
        int[] test2 = {2, 7, 11, 15};
        Week2 week2 = new Week2();
//        week2.groupAnagrams(test);
        week2.twoSum(test2,9);
    }


    /**
     * 字母异位词
     * https://leetcode-cn.com/problems/valid-anagram/description/
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        List n = new ArrayList();
        char[] charsS = s.toCharArray();
        for (char aChar : charsS) {
            n.add(aChar);
        }
        char[] charsT = t.toCharArray();
        for (char c : charsT) {
            if (n.contains(c)){
                n.remove(n.indexOf(c));
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * 字母异位词
     * 排序解法
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramAlter(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        return Arrays.equals(charsS,charsT);
    }

    /**
     *  字母异位词分组
     * https://leetcode-cn.com/problems/group-anagrams/
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap();
        char[] c ;
        for (String str : strs) {
            c = str.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            List<String> stringList = map.getOrDefault(s,new ArrayList<>());
            stringList.add(str);
            map.put(s,stringList);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int next = target - nums[i];
            ints.add(nums[i]);
            int ishas = ints.indexOf(next);
            if(ishas != -1 && ishas != i){
                index[0] = i;
                index[1] = ishas;
            }
        }
        return index;
    }

}
