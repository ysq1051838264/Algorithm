package com.test.algorithm;

/**
 * author:YanYang
 * date:2022/10/27 19:36
 */
public class Sum {

    //计算两个大整数（均不超过100000位）相加，整数使用字符串表示（有时间的话可以考虑带符号的情况）。
    //Java:
    //String bigIntegerAdd(String number1, String number2)
    public static void main(String[] args) {

        bigIntegerAdd("9087848783", "-787721");
    }

    // 9087848783
    //     787721

//    结果    9088636504

    public static void bigIntegerAdd(String number1, String number2) {
        //转换成字符相加
        char[] char1 = new StringBuilder(number1).reverse().toString().toCharArray();
        char[] char2 = new StringBuilder(number2).reverse().toString().toCharArray();

        int max = Math.max(char1.length, char2.length);

        //有可能溢出
        int[] sum = new int[max + 1];

        for (int i = 0; i < sum.length; i++) {
           //都是0，除非有跨过来的
            int tmp = sum[i];
            if (i < char1.length) {
                tmp = tmp + char1[i] - '0';
            }

            if (i < char2.length) {
                tmp = tmp + char2[i] - '0';
            }

            if (tmp >= 10) {
                tmp = tmp-10;
                sum[i+1]=1;
            }

            sum[i] =tmp;
        }


        //这个是最后的值
        StringBuilder sb = new StringBuilder();
        for (int i =max;i>=0;i--){
           //要判断最前面是不是0，如果是0的话，不加
           if(i==max&& sum[i]==0){
              continue;
           }
           sb.append(sum[i]);
        }

        System.out.println(sb.toString());


    }


}
