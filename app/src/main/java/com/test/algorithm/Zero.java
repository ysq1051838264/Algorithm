package com.test.algorithm;

/**
 * author:YanYang
 * date:2022/10/20 01:30
 */
class Zero {

   public static void main(String[] args) {
      int[] nums = new int[]{0,1,0,3,12};
      moveZeroes(nums);
   }

   public static void moveZeroes(int[] nums) {
      int[] a = new int[nums.length];
      int j =0;
      for(int i =0;i<nums.length;i++){
         if(nums[i] !=0){
            a[j]=nums[i];
            j++;
         }
      }

      for(int i =j;i<nums.length;i++){
         a[i]=0;
      }

      for(int i =0;i<nums.length;i++){
         System.out.print(a[i]);
      }

   }
}
