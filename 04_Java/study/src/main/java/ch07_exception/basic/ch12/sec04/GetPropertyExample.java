package main.java.ch07_exception.basic.ch12.sec04;

import java.util.Properties;
import java.util.Set;

public class GetPropertyExample {
    public static void main(String[] args) {
        System.out.println("운영체제 이름 : " + System.getProperty("os.name"));
        System.out.println("로그인 사용자 명 : " + System.getProperty("user.name"));
        System.out.println("홈 디렉토리 출력 : " + System.getProperty("user.home"));
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.println("---------------------------------");
        System.out.println(" key: value");
        System.out.println("---------------------------------");
        Properties props = System.getProperties();
        Set keys = props.keySet();
        for (Object objKey : keys) {
            String key = (String) objKey;
            String value = System.getProperty(key);
            System.out.printf("%-40s: %s\n", key, value);
        }
    }
}
