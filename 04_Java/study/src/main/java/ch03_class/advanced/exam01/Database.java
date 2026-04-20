package main.java.ch03_class.advanced.exam01;

public class Database {
    private String connection = "MySQL";

    public String connect(){
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }

    public void close(){
        System.out.println(connection + "을 닫습니다.");
    }

    // getter / setter

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }
}
