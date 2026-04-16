package main.java.ch02_conditional_loop_reference.basic.ch05.sec06;

public class ArrayLengthExample {
    public static void main(String[] args) {
        int[] arr = {84, 90, 96};
        int sum = 0;

        for (int i : arr){
            sum += i;
        }
        System.out.printf("총합 : %d\n", sum);
        System.out.printf("평균 : %.1f", (double)sum/arr.length);
    }
}
