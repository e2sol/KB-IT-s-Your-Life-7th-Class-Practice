package main.java.ch02_conditional_loop_reference.basic.ch05.sec06;

public class ArrayCreateByValueListExample2 {
    public static void printItem(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("score[%d]: %d\n", i, arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] scores = new int[] {83, 90, 87};
        printItem(scores);
    }
}
