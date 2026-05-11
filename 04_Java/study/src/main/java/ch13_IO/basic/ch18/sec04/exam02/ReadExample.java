package main.java.ch13_IO.basic.ch18.sec04.exam02;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
    public static void main(String[] args) {
        try {
            // 1글자 씩 처리
            Reader reader = new FileReader("C:/temp/test.txt");
            while (true) {
                int data1 = reader.read();
                if (data1 == -1) break;
                System.out.println((char) data1);
            }

            System.out.println();

            // 글자 배열로 처리
            Reader reader2 = new FileReader("C:/temp/test.txt");
            char[] data2 = new char[1024];
            while (true) {
                int num = reader2.read(data2);
                if (num == -1) break;
                for (int i = 0; i < num; i++) {
                    System.out.println(data2[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
