package main.java.ch03_class.advanced.exam02;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    // 정적 메서드
    public static String read(String title){
        System.out.print(title + ": ");
        String input = scanner.nextLine();
        return input;
    }
}
