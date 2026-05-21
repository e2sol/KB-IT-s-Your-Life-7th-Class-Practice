package main.java.ch13_IO.advanced.ch18.sec11;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample2 {
    public static void main(String[] args) {
        File images = new File("C:/Temp/images");

        if (!images.exists()) images.mkdir(); // 상위폴더가 있어야만 생성 가능
        // mkdirs() : 상위폴더가 없다면 상위폴더 생성 후 하위 폴더 마저 생성
        // 두 메서드 모두 성공 시 true, 실패 시 false 반환

        File temp = new File("C:/Temp");
        File[] contents = temp.listFiles();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
        for (File file : contents) {
            System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
            if (file.isDirectory()) {
                System.out.printf("%-10s%-20s", "<DIR>", file.getName());
            } else {
                System.out.printf("%-10s%-20s", file.length(), file.getName());
            }
            System.out.println();
        }
    }
}
