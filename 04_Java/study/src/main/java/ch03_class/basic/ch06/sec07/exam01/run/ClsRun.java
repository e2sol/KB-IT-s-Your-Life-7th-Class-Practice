package main.java.ch03_class.basic.ch06.sec07.exam01.run;

import main.java.ch03_class.basic.ch06.sec07.exam01.service.ClsService;
import main.java.ch03_class.basic.ch06.sec07.exam01.vo.Student;

public class ClsRun { // 실행용 클래스ㄹ
    public static void main(String[] args) {
        Student student = new Student();
        // Student의 ex 메서드 호출
        // student.ex();

        ClsService service = new ClsService();
        // service.ex1(); // 접근제한자 예제
        // service.ex2(); // static 예제
        service.ex3();
    }
}
