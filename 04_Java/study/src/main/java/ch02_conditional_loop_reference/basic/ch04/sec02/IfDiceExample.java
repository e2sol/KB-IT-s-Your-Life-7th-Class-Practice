package main.java.ch02_conditional_loop_reference.basic.ch04.sec02;

public class IfDiceExample {
    public static void main(String[] args) {
        int num = (int) ((Math.random()*6) + 1);
        if (num == 1){
            System.out.printf("%d번이 나왔습니다",1);
        } else if (num == 2){
            System.out.printf("%d번이 나왔습니다",2);
        } else if (num == 3){
            System.out.printf("%d번이 나왔습니다",3);
        } else if (num == 4){
            System.out.printf("%d번이 나왔습니다",4);
        } else if (num == 5){
            System.out.printf("%d번이 나왔습니다",5);
        } else {
            System.out.printf("%d번이 나왔습니다",6);
        }
    }
}
