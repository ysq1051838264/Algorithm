package com.test.algorithm;

import java.util.LinkedList;
import java.util.Stack;

/**
 * author:YanYang
 * date:2022/10/29 00:37
 * <p>
 * 接雨水问题
 */
class SolutionTrap {

    public static void main(String[] args) {
        int[] height = new int[]{1, 2, 3, 4, 5};

        int sum = 0;

        int[] maxLfet = new int[height.length];
        int[] maxRight = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) maxLfet[i] = height[i];
            else
                maxLfet[i] = Math.max(maxLfet[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >=0; i--) {
                maxRight[i] = Math.max(maxRight[i+1], height[i+1]);

            System.out.println(i+"---"+maxRight[i]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            int point = Math.min(maxLfet[i], maxRight[i]);
            if (point > height[i]) {
                sum = sum + (point - height[i]);
            }
        }

        System.out.println("雨水的和" + sum);


    }

}
