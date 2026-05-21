package main.java.ch13_IO.basic.ch18.sec11;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileExample {
    public static void main(String[] args) throws Exception{
        // File 객체 생성
        File file = new File("C:/Temp/file1.txt");

        if (!file.exists()) {
            System.out.println("해당 파일은 없는 파일입니다.");
            file.createNewFile();
        }

        if (file.isFile()) {
            System.out.println(file.length() + "\t" + file.getPath());
        }

        if (file.isDirectory()) {
            System.out.println("<DIR>" + file.getPath());
        }
    }
}
