package main.java.ch03_class.basic.ch06.sec14;

public class Car {
    //필드 선언
    private int speed;
    private boolean stop;

    // 메서드 설정
    // 설정된 현재 속도 출력
    public void getting() {
        System.out.println("현재 속도 : " + speed);
    }

    // 속도만 설정하는 경우
    public void setting(int speed) {
        setting(speed, false);
    }

    // 운동, 정지 여부만 설정하는 경우
    public void setting(boolean stop) {
        setting(this.speed, stop);
    }

    // speed 필드와 stop 필드 모두 설정하는 경우
    public void setting(int speed, boolean stop) {
        if (speed <= 0) {
            this.speed = 0;
        } else {
            this.speed = speed;
        }
        if (stop == true) {
            this.speed = 0;
        }
    }
}
