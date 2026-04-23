package main.java.ch05_abstract_interface.basic.ch08.sec10.exam02;

public class CastingExample {
    public static void main(String[] args) {
        Vehicle vehicle = new Bus();

        vehicle.run();
        // vehicle.checkFare();
        // 인터페이스 타입으로 형변환이 되었기에 자식 클래스에서 선언한 메서드 사용 불가

        Bus bus = (Bus) vehicle;
        bus.run();
        bus.checkFare();
    }
}
