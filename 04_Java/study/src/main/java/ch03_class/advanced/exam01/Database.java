package main.java.ch03_class.advanced.exam01;

public class Database {
    private static Database singleton = new Database();
    private static String connection = "MySQL";

    // private 접근 권한을 가지는 생성자 선언
    private Database(){};

    // 정적 메서드 선언
    public static Database getInstance(){
        return singleton;
    }

    public String connect(){
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }

    public void close(){
        System.out.println(connection + "을 닫습니다.");
    }
}
