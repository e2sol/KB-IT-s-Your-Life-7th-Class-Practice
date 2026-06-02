package main.java.ch13_IO.basic.ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineExample {
    public static void main(String[] args) {
        String path  = "src/main/java/ch13_IO/basic/ch18/sec07/exam02/ReadLineExample.java";
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            int lineNo = 1;

            while (true) {
                String str = br.readLine();
                if (str == null) break;

                System.out.println(lineNo + "\t" + str);
                lineNo++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
