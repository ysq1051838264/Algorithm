package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * author:YanYang
 * date:2022/10/30 00:19
 * <p>
 * * 合并两个有序数组并去重
 * * 思路是双指针
 */
class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 5, 6, 7, 8};
        int[] nums2 = new int[]{1, 3, 5, 7, 9, 10, 11, 123};

        merge(nums1, nums2);
//        merge2(nums1, nums1.length, nums2, nums2.length);

        LinkedHashMap<Integer,Integer> cache = new LinkedHashMap<>();
        cache.keySet().iterator().next();
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }

        for (int i = 0; i != m + n; ++i) {
            System.out.print("   " + sorted[i]);
//            nums1[i] = sorted[i];
        }
    }

    public static int[] merge(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while (p1 < n1 || p2 < n2) {
            if (p1==n1){
                list.add(nums2[p2++]);
            }else if (p2 == n2){
                list.add(nums1[p1++]);
            }else if (nums1[p1] > nums2[p2]) {
                list.add(nums2[p2++]);
            } else if (nums1[p1] < nums2[p2]) {
                list.add(nums1[p1++]);
            }else
                p1++;

//            else
//                p1++;
        }

//        //有可能p1或者p2,终止了； 数组 最后的元素没加上，所以要判断一下，是不是与最后一个元素相等
//        while (p1<n1){
//            if(list.size()>0 && nums1[p1]!=list.get(list.size()-1)){
//                list.add(nums1[p1]);
//            }
//          p1++;
//        }
//
//        while (p2<n2){
//            if(list.size()>0 && nums2[p2]!=list.get(list.size()-1)){
//                list.add(nums2[p2]);
//            }
//            p2++;
//        }


        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
            System.out.print("   " + res[i]);
        }

        return res;

    }

}
