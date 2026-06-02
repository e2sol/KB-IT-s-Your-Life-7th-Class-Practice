package main.java.ch02_conditional_loop_reference.basic.ch06.sec01;
// class : 설계도
public class ArrayRun { // 실행용 클래스
    public static void main(String[] args) {
        ArrayExample2 arr2 = new ArrayExample2();
//        arr2.ex1();
        // 참조 변수 arr2가 참조하는 객체의 ex1 메소드 실행
//        arr2.ex2();
//        arr2.ex3();

        ArrayExample3 arr3 = new ArrayExample3();
//        arr3.ex1();
        arr3.ex2();
    }

    public void ex2(){
        System.out.println("예제 2번");
        // 실행 안 됨.
        // 실행을 위한 공간인 main에서 호출되지 않았기 때문
    }
}
