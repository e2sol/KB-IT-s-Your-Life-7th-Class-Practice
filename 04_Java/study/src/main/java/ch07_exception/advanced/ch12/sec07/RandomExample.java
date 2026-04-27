package main.java.ch07_exception.advanced.ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        // 선택 번호
        int[] selectNum = new int[6];
        Random random = new Random(3);
        System.out.print("선택 번호 : ");
        for (int i = 0; i < 6; i++) {
            selectNum[i] = random.nextInt(45) + 1;
            System.out.print(selectNum[i] + " ");
        }
        System.out.println();

        // 당첨 번호
        int[] winningNum = new int[6];
        random = new Random(5);
        System.out.print("당첨 번호 : ");
        for (int i = 0; i < 6; i++) {
            winningNum[i] = random.nextInt(45) + 1;
            System.out.print(winningNum[i] + " ");
        }
        System.out.println();

        // 당첨여부, 비교하기 전에 배열 항목을 정렬
        Arrays.sort(selectNum);
        Arrays.sort(winningNum);
        boolean result = Arrays.equals(selectNum, winningNum); // 배열 항목 비교
        System.out.print("당첨 여부 : ");
        if(result) {
            System.out.println("1등 당첨");
        } else {
            System.out.println("미당첨");
        }
    }
}
