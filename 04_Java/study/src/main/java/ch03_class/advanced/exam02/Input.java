package main.java.ch03_class.advanced.exam02;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    // 정적 메서드
    // 문자열 입력
    public static String read(String title){
        System.out.printf("%s: ", title);
        String str = scanner.nextLine();
        return str;
    }
    public static String read(String title, String defaultValue){
        System.out.printf("%s(%s): ", title, defaultValue);
        String str = scanner.nextLine();
        if (str.trim().length() == 0){
            return defaultValue;
        } else {
            return str;
        }
    }

    // 정수 입력
    public static int readInt(String title){
        System.out.printf("%s: ", title);
        int value = Integer.parseInt(scanner.nextLine());
        return value;
    }

    // yes/no 확인
    public static boolean confirm(String title, boolean defaultValue){
        if (defaultValue == true){
            System.out.printf("%s (Y/n): ", title);
        } else {
            System.out.printf("%s (y/N): ", title);
        }
        String str = scanner.nextLine();
        if (str.trim().length()==0){
            return defaultValue;
        } else if (str.equals("Y") || str.equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean confirm(String title){
        return confirm(title, true);
    }

}
