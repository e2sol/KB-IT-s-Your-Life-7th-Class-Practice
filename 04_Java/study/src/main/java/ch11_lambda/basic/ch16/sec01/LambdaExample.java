package main.java.ch11_lambda.basic.ch16.sec01;

public class LambdaExample {
    public static void main(String[] args) {
        // 익명 클래스 사용 시
        action(new Calculable() {
            @Override
            public void calculate(int x, int y) {
                // x + y 계산
                int result = x + y;
                System.out.println("x + y = " + result);
            }
        });

        // 람다 식
        // - 인터페이스 구현 코드를 한 줄로 넘기는 문법
        // - (x, y) -> { ... }
        action((x, y) -> {
            // x + y 계산
            int result = x + y;
            System.out.println("x + y = " + result);
        });

        action((x, y) -> {
            // x - y 계산
            int result = x - y;
            System.out.println("x - y = " + result);
        });
    }

    // action 메서드 정의
    // -> Calculable(인터페이스)을 매개변수로 받음
    // 비 static 메서드 'action(main.java.ch11_lambda.basic.ch16.sec01.Calculable)'은(는) static 컨텍스트에서 참조할 수 없습니다
    public static void action(Calculable calculable) {
        int x = 10;
        int y = 4;
        calculable.calculate(x, y);
    }
}
