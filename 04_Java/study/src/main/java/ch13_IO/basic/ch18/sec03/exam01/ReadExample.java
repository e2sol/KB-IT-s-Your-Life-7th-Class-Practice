package main.java.ch13_IO.basic.ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("C:/temp/test1.db")){
            while (true) {
                int data = is.read(); // 1byte 씩 읽기
                if (data == -1) break; // 다 읽었으면 반복문 탈출
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
