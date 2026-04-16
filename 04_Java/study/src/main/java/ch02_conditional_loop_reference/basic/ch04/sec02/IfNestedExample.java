package main.java.ch02_conditional_loop_reference.basic.ch04.sec02;

public class IfNestedExample {
    public static void main(String[] args) {
        int score = (int) ((Math.random() * 20) + 81);
        System.out.println("점수: " + score);

        String grade;
        // 학점을 출력하는 if문
        if (score < 85) {
            grade = "B";
        } else if (score < 90) {
            grade = "B+";
        } else if (score < 95) {
            grade = "A";
        } else {
            grade = "A+";
        }
        System.out.println("학점: " + grade);
    }
}
