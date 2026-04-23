package main.java.ch04_inheritance_polymorphism.basic.ch07.practice.point.controller;

import main.java.ch04_inheritance_polymorphism.basic.ch07.practice.point.model.vo.Rectangle;

public class RectangleController {
    // 필드
    private Rectangle r = new Rectangle();

    // 메서드
    public String calcArea(int x, int y, int height, int width) {
        // 받은 매개변수를 이용하여 필드들을 초기화
        r.setX(x);
        r.setY(y);
        r.setHeight(height);
        r.setWidth(width);

        // 초기화한 정보와 면적 반환
        return r.toString() + " / " + (r.getHeight() * r.getWidth());
    }

    public String calcPerimeter(int x, int y, int height, int width) {
        // 받은 매개변수를 이용하여 필드들을 초기화
        r.setX(x);
        r.setY(y);
        r.setHeight(height);
        r.setWidth(width);

        // 초기화한 정보와 면적 반환
        return r.toString() + " / " + (2 * (r.getHeight() + r.getWidth()));
    }
}
