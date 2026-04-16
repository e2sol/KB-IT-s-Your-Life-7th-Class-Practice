package main.java.ch01_variable_type_operator.advanced.ch03;

public class TrapezoidArea {
    public static void main(String[] args) {
        int upLength = 5;
        int downLength = 10;
        int height = 7;

        double area = (upLength + downLength) * (double)height / 2;
        System.out.printf("사다리꼴 넓이 : %.2f", area);
    }
}
