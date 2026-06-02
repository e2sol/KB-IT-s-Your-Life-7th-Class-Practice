package main.java.ch07_exception.basic.ch11.sec03.exam01;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo"};

        for (int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.println("array[" + i + "] : " + value);
            } catch (ArrayIndexOutOfBoundsException err) {
                System.out.println("배열 인덱스 초과 " + err.getMessage());
            } catch (NumberFormatException err) {
                System.out.println("숫자로 변환 불가 " + err.getMessage());
            }
        }
    }
}
