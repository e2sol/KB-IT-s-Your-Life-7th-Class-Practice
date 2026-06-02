package main.java.ch02_conditional_loop_reference.advanced.conditional_loop;

public class FindSolutionsFor4xPlus5yEquals60Within10 {
    public static void main(String[] args) {
        // 중첩 for문을 이용하여 방정식 4x + 5y = 60의 모든 해를 구해서 (x, y) 형태로 출력하는 코드를 작성
        // 단, x와 y는 10이하의 자연수

        System.out.println("4x + 5y = 60의 모든 해 (x, y)");
        for (int x = 1; x <= 10; x++) {
            for (int y = 1; y <= 10; y++) {
                if (4 * x + 5 * y == 60) {
                    System.out.printf("(%d, %d)\n", x, y);
                }
            }
        }
    }
}
