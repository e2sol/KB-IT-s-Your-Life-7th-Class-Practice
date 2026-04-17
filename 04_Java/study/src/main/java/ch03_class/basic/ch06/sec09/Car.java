package main.java.ch03_class.basic.ch06.sec09;

public class Car {
    //필드 선언
    String model;
    int speed;

    // 생성자를 통해 model 필드 초기화
    public Car(String model) {
        this.model = model;
    }

    // speed 필드의 getter / setter 메서드 정의
    public int getter() {
        return speed;
    }

    public void setter(int speed) {
        this.speed = speed;
    }

    // run 메서드
    public void run() {
        System.out.printf("%s(이/가) 달립니다. (시속 : %dkm/h)\n", model, speed);
    }
}
