package main.java.ch03_class.advanced.exam03.service;

import main.java.ch03_class.advanced.exam03.vo.Book;

public class BookService {
    public void practice(){
        // 기본 생성자로 첫번째 book 생성
        Book book1 = new Book();
        // 매개변수 생성자로 두번째 book 생성
        Book book2 = new Book("자바의 정석", 30000, 0.2, "남궁성");

        // 객체가 가진 필드 값을 toString()을 이용하여 출력
        System.out.println(book1.toString());
        System.out.println(book2.toString());

        // 첫 번째 객체가 가진 값을 setter를 이용해 수정
        book1.setTitle("C언어");
        book1.setPrice(30000);
        book1.setDiscountRate(0.1);
        book1.setAuthor("홍길동");

        // 수정된 객체의 필드 값을 toString()을 이용하여 출력
        System.out.println("=================================");
        System.out.println("수정된 결과 확인");
        System.out.println(book1.toString());

        // 각 객체의 할인율을 적용한 책 가격을 계산해서 출력
        System.out.println("=================================");
        System.out.printf("도서명 = %s\n", book1.getTitle());
        System.out.printf("할인된 가격 = %d\n",
                book1.getPrice() - (int)(book1.getPrice()*book1.getDiscountRate()));
        System.out.printf("도서명 = %s\n", book2.getTitle());
        System.out.printf("할인된 가격 = %d",
                book2.getPrice() - (int)(book2.getPrice()*book2.getDiscountRate()));
    }
}
