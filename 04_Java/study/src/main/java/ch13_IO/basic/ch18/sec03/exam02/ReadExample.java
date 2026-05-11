package main.java.ch13_IO.basic.ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("C:/temp/test2.db")) {
            byte[] data = new byte[100];

            // 배열로 데이터를 읽는 경우 while문을 사용하지 않아도 괜찮음
            int num = is.read(data); // 읽어올 data의 개수 저장
            // System.out.println("num : " + num);
            for (int i = 0; i < num; i++) {
                System.out.println(data[i]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
