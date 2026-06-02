package main.java.ch08_multithread.thread.ex1;

// 스레드 생성 방법 1 : Thread 클래스 상속
public class FirstThread extends Thread{

    // 장점 : 스레드 생성 구문이 짧아진다.
    // 단점 : 추상 메서드가 없어서 직접 오버라이딩을 해주어야 한다.
    @Override
    public void run() {
        // run() 메서드 : 스레드가 생성되어 실행(start()) 시 수행할 구문을 작성하는 메서드
        System.out.println(Thread.currentThread().getName() + "실행");

        for (int i = 0; i < 10; i++) {
            System.out.println("0번 스레드 " + i);
        }
    }
}
