package main.java.ch02_conditional_loop_reference.basic.ch06.sec01;
// class : 설계도
public class ArrayRun { // 실행용 클래스
    public static void main(String[] args) {
        ArrayExample2 arr2 = new ArrayExample2();
//        arr2.ex1();
        arr2.ex2();
    }

    public void ex2(){
        System.out.println("예제 2번");
        // 실행 안 됨.
        // 실행을 위한 공간인 main에서 호출되지 않았기 때문
    }
}
