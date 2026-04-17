package main.java.ch03_class.basic.ch06.sec07.exam02;

public class Korean {
    // 필드 선언
    String nation = "대한민국";
    String name;
    String ssn;

    // 생성자 선언
    // 매개변수를 받는 생성자의 경우 void 작성 시 오류
    public Korean(String name, String ssn){
        // 매개변수로 name, ssn 필드를 초기화하는 생성자를 정의
        this.name = name;
        this.ssn = ssn;
    }
}
