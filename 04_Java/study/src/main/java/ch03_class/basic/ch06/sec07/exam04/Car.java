package main.java.ch03_class.basic.ch06.sec07.exam04;

public class Car {
    // 필드 선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    // 매개변수가 없는 생성자 (디폴트 생성자)
    public Car(){ // 다른 생성자가 있는 경우 void 작성 안함
        System.out.println("매개변수가 없는 생성자");
    }

    // 매개변수로 model만 가지는 생성자
    public Car(String model){
        System.out.println("매개변수로 model만 가지는 생성자");
        this.model = model;
    }

    // 매개변수로 model과 color를 가지는 생성자
    public Car(String model, String color){
        System.out.println("매개변수로 model과 color를 가지는 생성자");
        this.model = model;
        this.color = color;
    }

    // 매개변수로 model, color, maxSpeed를 가지는 생성자
    public Car(String model, String color, int maxSpeed){
        System.out.println("매개변수로 model, color, maxSpeed를 가지는 생성자");
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
