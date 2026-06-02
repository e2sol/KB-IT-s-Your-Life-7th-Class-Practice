package main.java.ch02_conditional_loop_reference.advanced.reference;

import java.util.Scanner;

public class StudentScoreAnalysisSystem {
    public static void main(String[] args) {
        // 학생들의 점수를 분석하는 프로그램
        // 키보드로부터 학생 수와 각 학생들의 점수를 입력 받고
        // while문과 Scanner의 nextInt() 메서드를 이용하여 최고 점수와 평균 점수를 출력

        Scanner scanner = new Scanner(System.in);

        int select; // 메뉴 선택 값을 담을 변수
        int studentsNum = 0; // 입력받은 학생 수
        int[] scores = null; // 점수를 입력받을 정수형 배열
        int maxScore = 0; // 최고점수를 저장할 변수
        int scoreSum = 0; // 평균점수 계산을 위한 총점을 저장할 변수

        while (true) {
            // 메뉴 출력
            System.out.println("------------------------------------------------------");
            System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
            System.out.println("------------------------------------------------------");

            // 메뉴 선택
            System.out.printf("선택 > ");
            select = scanner.nextInt();

            // 각 선택 별 코드 실행
            if (select == 1) {
                System.out.printf("학생수 > ");
                studentsNum = scanner.nextInt();
                scores = new int[studentsNum];
                maxScore = 0;
                scoreSum = 0;
                System.out.println(); // 줄 띄우기
            } else if (studentsNum > 0 && select == 2) {
                for (int i = 0; i < studentsNum; i++) {
                    System.out.printf("scores[%d] > ", i);
                    scores[i] = scanner.nextInt();
                    if (maxScore < scores[i]) maxScore = scores[i];
                    scoreSum += scores[i];
                }
                System.out.println(); // 줄 띄우기
            } else if (scoreSum > 0 && select == 3) {
                for (int i = 0; i < studentsNum; i++) {
                    System.out.printf("scores[%d] : %d\n", i, scores[i]);
                }
                System.out.println(); // 줄 띄우기
            } else if (scoreSum > 0 && select == 4) {
                System.out.printf("최고 점수 : %d\n", maxScore);
                System.out.printf("평균 점수 : %.1f\n", scoreSum/(double)studentsNum);
            } else if (select == 5) {
                break;
            } else {
                System.out.println("학생 수 입력 후 점수를 작성해주세요");
            }
        }
        System.out.println("프로그램 종료");
    }
}
