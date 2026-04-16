package main.java.ch02_conditional_loop_reference.advanced.conditional_loop;

public class SumOfThreeMultiplesFrom1To100 {
    public static void main(String[] args) {
        // for 문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 출력
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                sum += i;
            }
        }
        System.out.printf("1부터 100까지의 정수 중 3의 배수의 총합 : %d", sum);
    }
}
