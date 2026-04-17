package main.java.ch03_class.basic.ch06.sec14;

public class CarExample {
    public static void main(String[] args) {
        // 객체 생성
        Car myCar = new Car();

        // 잘못된 속도로 변경 (-50)
        myCar.setting(-50);
        // 현재 속도 출력
        myCar.getting();

        // 올바른 속도로 변경 (60)
        myCar.setting(60);
        // 현재 속도 출력
        myCar.getting();

        // 멈춤
        myCar.setting(true);
        // 현재 속도 출력
        myCar.getting();

    }
}
