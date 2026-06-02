package main.java.ch13_IO.io.service;

import java.io.*;

public class IOService2 {
    // try-with-rewources
    // -> try() 안에서 생성한 스트림 객체는 try 종료 시 자동으로 close() 수행

    // 실행 순서
    // try 실행 -> catch (예외 발생 시) -> 자동 close() -> finally 실행

    // 바이트 기반 파일 출력
    public void byteOutput() {

        try (FileOutputStream fos = new FileOutputStream("src/main/java/ch13_IO/io/byte/byteTest.txt")) {

            String content = "Hello 1234 ~!@#$ ";

            for (int i = 0; i < content.length(); i++) {
                fos.write(content.charAt(i));
            }

            System.out.println("출력완료");

        } catch (IOException e) {
            System.out.println("예외 발생");
            e.printStackTrace();

        }
    }

    // 문자 기반 파일 출력
    public void charOutput() {

        try (FileWriter fw = new FileWriter("src/main/java/ch13_IO/io/char/charTest.txt")) {

            String content = "곧 조발표 합니다 ^-^ >_< ";

            fw.write(content);

            // 버퍼에 남아있는 내용을 강제로 출력
            // flush()는 선택사항
            // close() 시 자동으로 flush() 수행
            fw.flush();

            System.out.println("출력 완료");

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            System.out.println("작업 완료");
        }
    }

    // 바이트 기반 파일 입력
    public void byteInput() {

        try (FileInputStream fis = new FileInputStream("src/main/java/ch13_IO/io/byte/byteTest.txt")) {

            while (true) {
                int data = fis.read();

                if (data == -1) break;

                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 문자 기반 파일 입력
    public void charInput() {

        try (FileReader fr = new FileReader("src/main/java/ch13_IO/io/char/charTest.txt")) {

            while (true) {
                int data = fr.read();
                if (data == -1) break;
                System.out.print((char) data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
