package main.java.ch03_class.advanced.exam01;

public class DatabaseExample {
    public static void main(String[] args) {
        Database data =Database.getInstance();

        String str = data.connect();
        System.out.println("데이터베이스 : " + str);
        data.close();
    }
}
