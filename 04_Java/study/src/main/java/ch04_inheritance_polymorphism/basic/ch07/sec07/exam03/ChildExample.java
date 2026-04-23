package main.java.ch04_inheritance_polymorphism.basic.ch07.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {

        Parent parent = new Child();

        parent.field1 = "data1";
        parent.method1();
        parent.method2();
        // 자식클래스 객체가 부모 클래스 객체로 형변환 되면
        // 자식 클래스에서 정의된 필드와 메서드를 활용할 수 없다.
        // parent.field2 = "data2";
        // parent.method3();

        // 부모클래스 객체가 자식클래스 객체로 강제 형변환 된 경우
        // 자식클래스에서 정의된 필드와 메서드를 활용할 수 있다.
        Child child = (Child) parent;

        child.field2 = "data2";
        child.method3();
    }
}
