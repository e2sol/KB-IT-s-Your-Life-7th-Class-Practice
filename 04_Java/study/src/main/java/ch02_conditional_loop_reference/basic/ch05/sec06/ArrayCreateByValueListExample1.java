package main.java.ch02_conditional_loop_reference.basic.ch05.sec06;

public class ArrayCreateByValueListExample1 {
    public static void main(String[] args) {
        String[] season = {"Spring", "Summer", "Fall", "Winter"};
        for (int i = 0; i < season.length; i++) {
            System.out.printf("season[%d] : %s\n", i, season[i]);
        }

        int[] scores = {83, 90, 87};
        int sum = 0;
        for (int x : scores){
            sum += x;
        }
        System.out.printf("\n총합 : %d", sum);
        System.out.printf("\n평균 : %f", (double)sum/scores.length);
    }
}
