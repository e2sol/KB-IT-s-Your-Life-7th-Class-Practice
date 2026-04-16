package main.java.ch02_conditional_loop_reference.basic.ch04.sec03;

public class SwitchExample {
    public static void main(String[] args) {
        int num = (int)((Math.random()*6)+1);
        switch (num){
            case 1: // num == 1;
                System.out.println(num+"번이 나왔습니다.");
                break;
            case 2:
                System.out.println(num+"번이 나왔습니다.");
                break;
            case 3:
                System.out.println(num+"번이 나왔습니다.");
                break;
            case 4:
                System.out.println(num+"번이 나왔습니다.");
                break;
            case 5:
                System.out.println(num+"번이 나왔습니다.");
                break;
            default: // 변수값과 동일한 값을 갖는 case가 없으면 default로 가서 실행문 실행. 생략가능
                System.out.println(num+"번이 나왔습니다.");
                break;
        }
    }
}
