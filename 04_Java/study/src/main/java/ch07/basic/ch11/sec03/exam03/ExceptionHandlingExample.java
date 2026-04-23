package main.java.ch07.basic.ch11.sec03.exam03;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        String[] array = {"100", "1oo", null, "200"};

        for (int i = 0; i <= array.length; i++) {
            try {
                int value = Integer.parseInt(array[i]);
                System.out.printf("array[%d] : %d\n", i, value);
            } catch (ArrayIndexOutOfBoundsException err) {
                System.out.println("배열의 인덱스 초과 "+ err.getMessage());
            } catch (NullPointerException | NumberFormatException err) {
                System.out.println("데이터 이상 발생 " + err.getMessage());
            }
        }
    }
}
