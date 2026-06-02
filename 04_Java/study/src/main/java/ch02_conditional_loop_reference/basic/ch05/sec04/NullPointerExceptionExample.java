package main.java.ch02_conditional_loop_reference.basic.ch05.sec04;

import java.util.Arrays;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        // int[] intArray = null;
        // intArray[0] = 10;
        // 위의 경우 배열의 길이가 지정되지 않았는데 0번에 값을 대입해서 오류 발생

        int[] intArray = new int[]{10};
        System.out.println(Arrays.toString(intArray));

        // String str = null;
        String str = "";
        System.out.println("총문자수: " + str.length()); // str이 null이기에 오류 발생
    }
}
