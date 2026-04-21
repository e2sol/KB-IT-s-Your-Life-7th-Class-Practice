package main.java.ch04_inherit.basic.ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = new Parent();

        parent.method1();
        parent.method2();
        // parent.method3(); // 자식에서 정의된 메서드는 부모 클래스 객체에서 사용 불가능
    }
}
