package main.java.ch02_conditional_loop_reference.advanced.reference;

public class SumAndAverageOf2DArray {
    public static void main(String[] args) {
        // 주어진 배열 항목의 전체 합과 평균을 구해 출력
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };
        int sum = 0;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            count += array[i].length;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }

        System.out.printf("배열 항목의 전체 합 : %d\n", sum);
        System.out.printf("배열 항목의 평균 : %.2f", sum/(double)count);
    }
}
