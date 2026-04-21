package main.java.ch04_inherit.advanced.point.view;

import main.java.ch04_inherit.advanced.point.controller.CircleController;
import main.java.ch04_inherit.advanced.point.controller.RectangleController;

import java.util.Scanner;

public class PointMenu {
    // 필드
    private Scanner sc = new Scanner(System.in);
    private CircleController cc = new CircleController();
    private RectangleController rc = new RectangleController();

    // 메서드
    public void mainMenu() {
        // 메인메뉴 출력, 잘못 입력했을 시 다시 받도록 반복
        String input;
        while (true) {
            // 메인메뉴 출력
            System.out.println("===== 메뉴 =====");
            System.out.println("1. 원");
            System.out.println("2. 사각형");
            System.out.println("3. 끝내기");
            System.out.print("메뉴 번호 : ");
            input = sc.nextLine();

            // 입력값에 따른 처리
            if (input.equals("1")) {
                this.circleMenu();
            } else if (input.equals("2")) {
                this.rectangleMenu();
            } else if (input.equals("3")) {
                System.out.println("종료합니다. ");
                break;
            } else {
                continue;
            }
        }
    }

    public void circleMenu() {
        // 원 메뉴 출력, 잘못 입력했을 시 메인메뉴로 돌아감
        String input;

        // 원 메뉴 출력
        System.out.println("===== 원 메뉴 =====");
        System.out.println("1. 원 둘레");
        System.out.println("2. 원 넓이");
        System.out.println("3. 메인으로");
        System.out.print("메뉴 번호 : ");
        input = sc.nextLine();

        if (input.equals("1")) {
            this.calcCircum();
        } else if (input.equals("2")) {
            this.calcCircleArea();
        }
    }

    public void rectangleMenu() {
        // 사각형 메뉴 출력, 잘못 입력했을 시 메인메뉴로 돌아감
        String input;

        // 사각형 메뉴 출력
        System.out.println("===== 메뉴 =====");
        System.out.println("1. 사각형 둘레");
        System.out.println("2. 사각형 넓이");
        System.out.println("3. 메인으로");
        System.out.print("메뉴 번호 : ");
        input = sc.nextLine();

        if (input.equals("1")) {
            this.calcPerimeter();
        } else if (input.equals("2")) {
            this.calcRectArea();
        } else {
            return;
        }
    }

    public void calcCircum() {
        // x, y 좌표와 반지름을 받아 원의 정보와 원 둘레 출력

        // 각 값을 입력받기
        System.out.print("x 좌표 : ");
        int x = sc.nextInt();

        System.out.print("y 좌표 : ");
        int y = sc.nextInt();

        System.out.print("반지름 : ");
        int radius = sc.nextInt();
        sc.nextLine();

        // 데이터를 CircleController(cc)의 calcCircum()의 매개변수로 보내 반환 값 출력
        System.out.println("둘레 : " + cc.calcCircum(x, y, radius));
    }

    public void calcCircleArea() {
        // x, y 좌표와 반지름을 받아 원의 정보와 원 넓이 출력

        // 각 값을 입력받기
        System.out.print("x 좌표 : ");
        int x = sc.nextInt();

        System.out.print("y 좌표 : ");
        int y = sc.nextInt();

        System.out.print("반지름 : ");
        int radius = sc.nextInt();
        sc.nextLine();

        // 데이터를 CircleController(cc)의 calcArea()의 매개변수로 보내 반환 값 출력
        System.out.println("면적 : " + cc.calcArea(x, y, radius));
    }

    public void calcPerimeter() {
        // x, y 좌표와 높이, 너비를 받아 사각형의 정보와 사각형 둘레 출력

        // 각 값을 입력받기
        System.out.print("x 좌표 : ");
        int x = sc.nextInt();

        System.out.print("y 좌표 : ");
        int y = sc.nextInt();

        System.out.print("높이 : ");
        int height = sc.nextInt();

        System.out.print("너비 : ");
        int width = sc.nextInt();
        sc.nextLine();

        // 데이터를 RectangleController(rc)의 calcPerimeter()의 매개변수로 보내 반환 값 출력
        System.out.println("둘레 : " + rc.calcPerimeter(x, y, height, width));
    }

    public void calcRectArea() {
        // x, y 좌표와 높이, 너비를 받아 사각형의 정보와 사각형 넓이 출력

        // 각 값을 입력받기
        System.out.print("x 좌표 : ");
        int x = sc.nextInt();

        System.out.print("y 좌표 : ");
        int y = sc.nextInt();

        System.out.print("높이 : ");
        int height = sc.nextInt();

        System.out.print("너비 : ");
        int width = sc.nextInt();
        sc.nextLine();

        // 데이터를 RectangleController(rc)의 calcPerimeter()의 매개변수로 보내 반환 값 출력
        System.out.println("면적 : " + rc.calcArea(x, y, height, width));
    }
}
