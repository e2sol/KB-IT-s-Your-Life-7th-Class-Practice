package main.java.ch13_IO.basic.ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args) {
        // output 스트림 사용
        try(OutputStream os = new FileOutputStream("C:/temp/test1.db")) {
            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);
            os.write(b);
            os.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
