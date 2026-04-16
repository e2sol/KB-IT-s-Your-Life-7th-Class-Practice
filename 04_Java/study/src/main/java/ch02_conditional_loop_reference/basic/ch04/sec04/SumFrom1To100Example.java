package main.java.ch02_conditional_loop_reference.basic.ch04.sec04;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        // for문을 이용한 1-100 총 합 구하기
        int sum = 0;
        for (int i = 1; i<=100; i++){
            sum += i;
        }
        System.out.printf("1~100 합 : %d", sum);
    }
}
