package main.java.ch03_class.basic.ch06.sec08.exam04;

public class Calculator {
    // 메소드
    // 매개변수가 1개인 경우(정사각형 넓이 구하기)
    public double areaRectangle(int x) {
        return (double) x * x;
    }
    // 매개변수가 2개인 경우(직사각형 넓이 구하기)
    public double areaRectangle(int x, int y){
        return (double) x * y;
    }
}
