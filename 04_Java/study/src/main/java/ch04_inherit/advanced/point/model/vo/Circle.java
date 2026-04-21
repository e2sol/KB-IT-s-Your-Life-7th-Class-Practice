package main.java.ch04_inherit.advanced.point.model.vo;

public class Circle extends Point{
    // 필드
    private int radius;

    // 생성자
    public Circle() {}

    public Circle(int x, int y, int radius){
        super(x, y);
        this.radius = radius;
    }

    // getter / setter
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    // toString() 오버라이딩
    @Override
    public String toString() {
        return super.toString() + ", " + radius;
    }
}
