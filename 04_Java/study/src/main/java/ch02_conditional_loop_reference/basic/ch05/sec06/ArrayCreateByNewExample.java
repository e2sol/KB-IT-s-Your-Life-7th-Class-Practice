package main.java.ch02_conditional_loop_reference.basic.ch05.sec06;

import java.util.Arrays;

public class ArrayCreateByNewExample {
    public static void main(String[] args) {
        // 정수 요소 3개를 가지는 정수 배열 arr1을 선언 및 생성(초기화X) 후 arr1 출력
        int[] arr1 = new int[3];
        System.out.println("arr1의 내용 : "+ Arrays.toString(arr1));

        // 문자열 요소 3개를 가지는 문자여 배열 arr2를 선언 및 생성(초기화X) 후 arr2 출력
        String[] arr2 = new String[3];
        System.out.println("arr2의 내용 : "+Arrays.toString(arr2));
    }
}
