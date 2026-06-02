package main.java.ch02_conditional_loop_reference.basic.ch04.sec04;

public class PrintFrom1To10Example2 {
    public static void main(String[] args) {
        int i = 1;
        while (i<=10){
            System.out.printf("%d ", i++); // 기존 i값을 출력 후 1증가
        }
    }
}
