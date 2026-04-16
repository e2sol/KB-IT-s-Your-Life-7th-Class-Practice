package main.java.ch02_if_else_for_while.basic.ch04.sec04;

public class SumFrom1To100Example2 {
    public static void main(String[] args) {// while문을 이용한 1-100 총 합 구하기
        int sum = 0;
        int j = 1;
        while (j<=100){
            sum += j;
            j++;
        }
        System.out.printf("1~100 합 : %d", sum);
    }
}
