package main.java.ch04_inheritance_polymorphism.basic.ch07.sec07.exam01;

public class PromotionExample {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        A a1 = b; // a는 b의 부모클래스. 자식>부모 자동 형변환 가능
        A a2 = c; // a는 c의 부모클래스. 자식>부모 자동 형변환 가능
        A a3 = d; // b는 d의 부모 클래스. a는 b의 부모클래스. 자식>부모 자동 형변환 가능
        A a4 = e; // c는 e의 부모 클래스. a는 c의 부모클래스. 자식>부모 자동 형변환 가능

        B b1 = d; // b는 d의 부모 클래스. 자동 형변환 가능
        C c1 = e; // c는 e의 부모 클래스. 자동 형변환 가능

        // B b3 = e; // b와 e는 상속관계로 이뤄져있지 않음 > 형변환 불가
        // C c2 = d; // c와 d는 상속관계로 이뤄져있지 않음 > 형변환 불가
    }
}
