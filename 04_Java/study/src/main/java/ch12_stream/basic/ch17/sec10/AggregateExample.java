package main.java.ch12_stream.basic.ch17.sec10;

import java.util.Arrays;
import java.util.OptionalInt;

public class AggregateExample {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        // 2의 배수 카운팅
        long num = Arrays.stream(arr).filter(n -> n % 2 == 0).count();
        System.out.println("2의 배수 개수 : " + num);

        // 2의 배수 총합
        int sum = Arrays.stream(arr).filter(n->n%2==0).sum();
        System.out.println("2의 배수의 합 : " + sum);

        // 2의 배수 평균
        double avg = Arrays.stream(arr).filter(n->n%2==0).average().getAsDouble();
        System.out.println("2의 배수의 평균 : " + avg);

        // 2의 배수 중 최대값
        int max = Arrays.stream(arr).filter(n->n%2==0).max().getAsInt();
        System.out.println("최대값 : " + max);

        // 2의 배수 중 최소값
        int min = Arrays.stream(arr).filter(n->n%2==0).min().getAsInt();
        System.out.println("최소값 : " + min);

        // 첫 번째 3의 배수
        int num3 = Arrays.stream(arr).filter(n->n%3==0).findFirst().getAsInt();
        System.out.println("첫 번째 3의 배수 : " + num3);
    }
}
