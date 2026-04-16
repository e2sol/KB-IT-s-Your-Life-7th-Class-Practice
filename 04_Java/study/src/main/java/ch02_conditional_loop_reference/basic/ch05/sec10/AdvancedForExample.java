package main.java.ch02_conditional_loop_reference.basic.ch05.sec10;

public class AdvancedForExample {
    public static void main(String[] args) {
        int[] scores = {95, 71, 84, 93, 87};
        int sum = 0;

        for (int i : scores){
            sum += i;
        }
        System.out.printf("총합 : %d\n", sum);
        System.out.printf("평균 : %.2f", (double)sum/ scores.length);
    }
}
