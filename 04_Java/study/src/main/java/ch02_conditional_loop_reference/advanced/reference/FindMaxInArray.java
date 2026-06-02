package main.java.ch02_conditional_loop_reference.advanced.reference;

public class FindMaxInArray {
    public static void main(String[] args) {
        // 주어진 배열 항목에서 최대값을 출력
        int[] array = {1, 5, 3, 8, 2};
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            if (max <= array[i]){
                max = array[i];
            }
        }
        System.out.printf("array의 요소 중 최대값 : %d", max);
    }
}
