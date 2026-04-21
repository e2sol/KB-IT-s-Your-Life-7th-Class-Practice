package main.java.ch04_inherit.advanced.point.controller;

import main.java.ch04_inherit.advanced.point.model.vo.Circle;

public class CircleController {
    // 필드
    private Circle c = new Circle();

    // 메서드
    public String calcArea(int x, int y, int radius) {
        // 받은 매개변수를 이용하여 필드를 초기화
        c.setX(x);
        c.setY(y);
        c.setRadius(radius);

        // 초기화한 정보와 면적 반환
        return c.toString() + " / " + (Math.PI * c.getRadius() * c.getRadius());
    }

    public String calcCircum(int x, int y, int radius) {
        // 받은 매개변수를 이용하여 필드를 초기화
        c.setX(x);
        c.setY(y);
        c.setRadius(radius);

        // 초기화한 정보와 둘레 반환
        return c.toString() + " / " + (Math.PI * 2 * c.getRadius());
    }
}
