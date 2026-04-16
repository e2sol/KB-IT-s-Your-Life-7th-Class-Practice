package main.java.ch01_variable_type_operator.basic.ch02.sec06;

public class StringExample {
    public static void main(String[] args) {
        // escape 문자 : 일반 문자가 아닌 특수 문자 표현
        // 문자열 내에서 탭, 백슬레쉬, 작은 따옴표 등을
        // 코드로 사용하기 위한 방식

        System.out.println("a\tb\tc"); // tab 출력
        System.out.println("\\"); // \(백 슬래쉬) 출력
        System.out.println("\""); // 쌍 따옴표 단순 문자 출력
        System.out.println('\''); // 홑 따옴표 단순 문자 출력
        System.out.println("\n"); // 개행 문자(줄바꿈) 출력
        System.out.println("\u0041"); // 유니코드(16진수)번호로 출력

        // 문자형과 문자열
        // 문자형(char) : 한 글자, 표기법 : ''
        // 문자열(String) : 한 글자 이상, 표기법 : ""

        String name = "홍길동";
        String job = "프로그래머";

        System.out.println(name);
        System.out.println(job);
        System.out.println("나는 \"자바\"를 배웁니다.");
        System.out.println("번호 \t이름 \t직업");
        System.out.println("나는\n자바를\n배웁니다.");
    }
}
