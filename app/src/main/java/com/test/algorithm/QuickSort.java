package com.test.algorithm;

/**
 * author:YanYang
 * date:2022/10/19 01:04
 * <p>
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, -9, 2, 34, 111, -4, 19,-2,88,32};

        quickSort(nums, 0, nums.length - 1);

        for (int i : nums)
            System.out.print(i + ">");
    }

    private static void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);

    }

    private static int partition(int[] nums, int begin, int end) {
        //标杆
        int pivot = end;

        //小于标杆的个数
        int counter = begin;

        for (int i = begin; i < end; i++) {
            //从小到大排.如果 要大到小的话，就改 >
            if (nums[i] < nums[pivot]) {
                //小于的话，元素与 统计元素 替换
                int temp = nums[counter];
                nums[counter] = nums[i];
                nums[i] = temp;

                counter++;
            }
        }

        //将标杆元素 与 counter 替换
        int temp = nums[pivot];
        nums[pivot] = nums[counter];
        nums[counter] = temp;

        return counter;
    }

    //找中间元素， 1.循环；如 小于标杆end，当前数 跟统计元素start互换；2。将标杆元素point 与 统计元素counter 替换，返回统计元素
    // 排左边，在排右边

}
