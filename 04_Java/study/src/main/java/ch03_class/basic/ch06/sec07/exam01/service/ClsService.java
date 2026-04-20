package main.java.ch03_class.basic.ch06.sec07.exam01.service;

import main.java.ch03_class.basic.ch06.sec07.exam01.vo.People;
import main.java.ch03_class.basic.ch06.sec07.exam01.vo.Student;
// import main.java.ch03_class.basic.ch06.sec07.exam01.vo.TestVO;
// 외부 패키지에서 액세스할 수 없습니다.

// Service : 특정 기능(비즈니스 로직)을 제공하는 클래스
public class ClsService extends Student{

    public void ex1() {
        // 클래스 접근 제한자 확인하기

        Student student = new Student();
        // public class인 Student는 import 가능하다.

        // TestVO test = new TestVO();
        // (default) class인 TestVO는 다른 패키지에서 import 불가

        System.out.println("다른 패키지");
        System.out.println(student.v1);
        // 다른 패키지에서도 접근 가능한 public만 에러 x

        // System.out.println(student.v2);
        // System.out.println(student.v3);
        // System.out.println(student.v4);

        System.out.println("상속 관계");
        System.out.println(v1);
        System.out.println(v2);
        // 상속 관계 : protected 직접 접근 가능

        // System.out.println(v3);
        // System.out.println(v4);
    }

    public void ex2(){
        // static 필드 확인 예제

        // 학생객체 2개 생성
        Student std1 = new Student();
        Student std2 = new Student();

        // 학생 객체에 name 세팅
        // std1.name = "임태현"; // 직접 접근

        // 간접 접근 방법 setter
        std1.setName("임태현");
        std2.setName("김찬종");

        // 정보 출력
        System.out.println(std1.getName());
        System.out.println(std1.schoolName);
        // ** static이 붙은 필드(변수)는 클래스명.변수명으로 작성!
        // public이기 때문에 직접 접근 가능

        System.out.println(std2.getName());
        System.out.println(std2.schoolName);
        // System.out.println(Student.schoolName);

        // schoolName 변경
        std1.schoolName = "KB유치원";
        System.out.println("변경 후 std1의 학교 : " + std1.schoolName);
        System.out.println("std2의 학교 : " + std2.schoolName);
        // KB대학원 X -> KB유치원

        Student std3 = new Student();
        System.out.println("std3의 이름 : " + std3.getName()); // null
        System.out.println("std3의 학교 : " + std3.schoolName); // KB유치원
    }

    public void ex3(){
        People p = new People("임태현", '남', 33);
        System.out.println("이름 : " + p.getName());
        System.out.println("성별 : " + p.getGender());
        System.out.println("나이 : " + p.getAge());

        // 성별 '남' -> '여'로 변경
        p.setGender('여');
        System.out.println("변경된 성별 : " + p.getGender());

        // ---------------------------------------------
        // 1. People 클래스의 toString() 오버라이딩 전
        // -> Object의 toString()이 호출
        System.out.println(p);
        System.out.println(p.toString());
        // print 수행 시 참조변수명만 작성하는 경우
        // 자동으로 toString() 메서드를 호출해서 출력

        // 2. People 클래스의 toString() 오버라이딩 후
        // -> 오버라이딩된 자식(People)의 toString() 호출
    }
}
