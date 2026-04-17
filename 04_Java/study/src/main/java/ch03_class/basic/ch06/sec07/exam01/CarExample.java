package main.java.ch03_class.basic.ch06.sec07.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car("그랜저", "검정", 250);

        // myCar 객체 필드값 출력
        // 값이 안 담긴 이유 : Car 필드에 초기화 하지 않았기 때문에
        System.out.println("-----------------------------------");
        System.out.println("model : "+ myCar.model);
        System.out.println("color : "+ myCar.color);
        System.out.println("maxSpeed : "+ myCar.maxSpeed);
    }
}
