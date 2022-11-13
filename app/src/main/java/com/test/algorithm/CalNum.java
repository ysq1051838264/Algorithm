package com.test.algorithm;

import java.util.Locale;
import java.util.Scanner;

/**
 * author:YanYang
 * date:2022/10/16 00:30
 *
 * 计算某个字符出现出现的次数
 */
public class CalNum {

   public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      String str = scanner.nextLine().toLowerCase(Locale.ROOT);
      String s = scanner.nextLine().toLowerCase(Locale.ROOT);
      int le = str.length();
      System.out.println(str.length() -str.replaceAll(s,"").length());
   }

}
