package main.java.ch10_collection.basic.ch15.sec03.exam02;

import java.util.Objects;

public class Member {
    private String name;
    private int age;

    public Member(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return age == member.age && Objects.equals(name, member.name);
    }
    // 객체 내부 값이 동일하면 true를 반환 > 동일한 객체를 중복 선언하지 않도록 해줌

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
