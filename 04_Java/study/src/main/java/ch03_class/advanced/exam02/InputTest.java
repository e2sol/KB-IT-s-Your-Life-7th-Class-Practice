package main.java.ch03_class.advanced.exam02;

public class InputTest {
    public static void main(String[] args) {

        String name = Input.read("이름");
        System.out.println("입력값: " + name);
        String name2 = Input.read("이름", "홍길동");
        System.out.println("입력값: " + name2);
        int age = Input.readInt("나이");
        System.out.println("입력값: " + age);
        boolean isClose = Input.confirm("종료할까요?", false);
        System.out.println("입력값: " + isClose);
        boolean isClose2 = Input.confirm("종료할까요?");
        System.out.println("입력값: " + isClose2);
    }
}
