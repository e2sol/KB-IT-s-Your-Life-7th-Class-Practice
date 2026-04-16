package main.java.ch02_conditional_loop_reference.basic.ch04.sec03;

public class SwitchNoBreakCaseExample {
    public static void main(String[] args) {
        int time = 9;   // 10, 11 인 경우
        System.out.println("[현재시간: " + time + " 시]");
        switch (time) { // break문이 없기에, 해당하는 케이스 이후 모든 실행문 실행
            case 8:
                System.out.println("출근합니다.");
            case 9:
                System.out.println("회의를 합니다.");
            case 10:
                System.out.println("업무를 봅니다.");
            default:
                System.out.println("외근을 나갑니다.");
        }
    }
}
