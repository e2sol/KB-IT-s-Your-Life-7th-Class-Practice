package main.java.ch13_IO.basic.ch18.sec03.exam03;

import java.io.*;

public class CopyExample {
    public static void main(String[] args) {
        String originalFileName = "C:/Temp/test.jpg";
        String targetFileName = "C:/Temp/test2.jpg";

        try (
                InputStream is = new FileInputStream(originalFileName);
                OutputStream os = new FileOutputStream(targetFileName)
        ) {
            /*
            while (true) {
                int data = is.read();
                if (data == -1) break;
                os.write(data);
             */

            // 정답 코드
            byte[] data = new byte[1024]; // 버퍼 설정
            while (true) {
                int num = is.read(data);
                if (num == -1) break;
                os.write(data,0,num); // 읽은 데이터 파일에 쓰기
            }
            os.flush(); // 내부 버퍼 잔류 바이트를 출력하고 버퍼를 비움
            System.out.println("복사가 완료되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

