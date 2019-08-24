package com.ysh.web.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author ysh
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] num = new int[]{66,2,6,1,4,5,55};
        for (int i=0,lent = num.length-1;i<lent;i++){
            for (int j=0;j<lent-i;j++){
                if (num[j]>num[j+1]) {
                    int temp = num[j];
                    num[j]=num[j+1];
                    num[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(num));
    }
}
