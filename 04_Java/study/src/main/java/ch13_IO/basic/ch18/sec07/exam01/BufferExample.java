package main.java.ch13_IO.basic.ch18.sec07.exam01;

import java.io.*;

public class BufferExample {
    public static void main(String[] args) throws Exception{

        // 파일 경로 설정
        String originalFilePath1 = BufferExample.class.getResource("originalFile1.jpg").getPath();
        String targetFilePath1 = "C:/Temp/targetFile1.jpg";

        // 입출력 스트림 생성
        FileInputStream fis = new FileInputStream(originalFilePath1);
        FileOutputStream fos = new FileOutputStream(targetFilePath1);

        // 기본 입출력 스트림 + 버퍼 스트림 생성
        String originalFilePath2 = BufferExample.class.getResource("originalFile2.jpg").getPath();
        String targetFilePath2 = "C:/Temp/targetFile2.jpg";

        FileInputStream fis2 = new FileInputStream(originalFilePath2);
        FileOutputStream fos2 = new FileOutputStream(targetFilePath2);

        // 버퍼 스트림
        BufferedInputStream bis = new BufferedInputStream(fis2);
        BufferedOutputStream bos = new BufferedOutputStream(fos2);

        // 각 스트림을 이용하여 복사 후 걸린 시간 출력
        long nonBufferTime = copy(fis, fos);
        System.out.println("버퍼 미사용 :\t" + nonBufferTime + "ns");

        long bufferTime = copy(bis, bos);
        System.out.println("버퍼 사용:\t" + bufferTime + "ns");

        // 스트림 닫기
        fis.close();
        fos.close();
        bis.close();
        bos.close();
    }

    public static long copy(InputStream is, OutputStream os) throws Exception{
        // 시작 시간 저장
        long start = System.nanoTime();

        // 1 바이트를 읽고 1 바이트 출력
        while (true) {
            int data = is.read();
            if (data == -1) break;
            os.write(data);
        }
        os.flush();

        // 끝 시간 저장
        long end = System.nanoTime();

        // 복사동안 걸린 시간 리턴
        return end - start;
    }
}
