package com.barackbao.eyeread;

/**
 * Created by BarackBao on 2018/1/29.
 */


public class FanxingDemo {

    public static <E> void printArray(E[] inputArray) {
        for (E ele :
                inputArray) {
            System.out.println(ele);
        }
    }



    public static void test() {

    }

    public static void main(String args[]) {
        Integer[] array = {1, 3, 4, 545};
        Double[] arr = {2.4, 54.6};
        test();
        printArray(arr);
        printArray(array);

    }
}
