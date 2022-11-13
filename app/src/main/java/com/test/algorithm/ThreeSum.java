package com.test.algorithm;

import android.os.Handler;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.Scanner;

/**
 * author:YanYang
 * date:2022/10/16 00:17
 *
 * 三数之和
 */
public class ThreeSum {

   public static void main(String[] args) {
      int[] nums =new int[]{-1,0,1,2,-1,-4};

      Scanner scanner = new Scanner(System.in);
      String  s = scanner.nextLine();


      three(nums);
   }

   public static void three(int[] nums){
      if(nums.length<3){
          System.out.println("长度不够");
          return;
      }

   }




}
