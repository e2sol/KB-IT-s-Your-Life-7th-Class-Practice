package main.java.ch08_multithread.basic.ch14.sec03.exam02;

import java.awt.*;

public class BeepPrintExample {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit(); // 비프음 출력을 위한 객체 선언
                for (int i = 0; i < 5; i++) {
                    try {
                        toolkit.beep();
                        Thread.sleep(500); // 0.5초 간격 설정
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        // 작업 스레드 실행
        thread.start();

        // 메인 스레드 작업
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("띵");
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}
