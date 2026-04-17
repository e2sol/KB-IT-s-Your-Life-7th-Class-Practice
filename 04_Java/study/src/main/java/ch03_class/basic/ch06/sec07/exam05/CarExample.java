package main.java.ch03_class.basic.ch06.sec07.exam05;

public class CarExample {
    public static void main(String[] args) {
        Car car1 = new Car(null);
        Car car2 = new Car("자가용");
        Car car3 = new Car("자가용", "빨강");
        Car car4 = new Car("택시", "검정", 200);

        // 출력
        System.out.println("\ncar1.company : " + car1.company);

        System.out.println("\ncar2.company : " + car2.company);
        System.out.println("car2.model : " + car2.model);

        System.out.println("\ncar3.company : " + car3.company);
        System.out.println("car3.model : " + car3.model);
        System.out.println("car3.color : " + car3.color);

        System.out.println("\ncar4.company : " + car4.company);
        System.out.println("car4.model : " + car4.model);
        System.out.println("car4.color : " + car4.color);
        System.out.println("car4.maxSpeed : " + car4.maxSpeed);
    }
}
