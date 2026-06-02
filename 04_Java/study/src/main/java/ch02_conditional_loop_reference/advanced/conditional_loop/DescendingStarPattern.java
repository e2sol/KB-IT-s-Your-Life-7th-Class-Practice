package main.java.ch02_conditional_loop_reference.advanced.conditional_loop;

public class DescendingStarPattern {
    public static void main(String[] args) {
        // for문을 활용해 아래와 같이 출력하기
        // *****
        // ****
        // ***
        // **
        // *

        for(int i=5;i>=1;i--){
            System.out.println("*".repeat(i));
        }
    }
}
