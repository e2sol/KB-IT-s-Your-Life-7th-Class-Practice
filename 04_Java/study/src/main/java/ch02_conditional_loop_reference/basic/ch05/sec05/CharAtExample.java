package main.java.ch02_conditional_loop_reference.basic.ch05.sec05;

public class CharAtExample {
    public static void main(String[] args) {
        String ssn = "9506241230123";
        char value = ssn.charAt(6);
        if (value == '1' || value == '3'){
            System.out.println("남자입니다");
        } else if (value == '2' || value == '4') {
            System.out.println("여자입니다");
        }
    }
}
