package main.java.ch03_class.basic.ch06.sec07.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car("그랜저", "검정", 250);

        // 매개변수 2개짜리 생성자(String, int)를 이용하여 객체 생성 후
        // car 참조 변수에 대입
        Car car = new Car("자가용", 250);

        // myCar 객체 필드값 출력
        // 값이 안 담긴 이유 : Car 필드에 초기화 하지 않았기 때문에
        System.out.println("-----------------------------------");
        System.out.println("model : "+ myCar.model);
        System.out.println("color : "+ myCar.color);
        System.out.println("maxSpeed : "+ myCar.maxSpeed);
    }
}
