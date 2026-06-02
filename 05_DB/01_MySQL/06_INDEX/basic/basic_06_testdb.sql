create database testdb;
use testdb;

# 문제 6.
-- 다음 컬럼 목록을 가지는 usertbl을 정의
create table usertbl (
    userID char(8) not null primary key ,
    name varchar(10) not null ,
    birthYear int not null ,
    addr nchar(2) not null
);

# 문제 7.
-- 아래 데이터를 추가 후 클러스터 형 인덱스의 테이블 내용을 확인
insert usertbl values
                   ('LSG', '이승기', 1987, '서울'),
                   ('KBS', '김범수', 1979, '경남'),
                   ('KKH', '김경호', 1971, '전남'),
                   ('JYP', '조용필', 1950, '경기'),
                   ('SSK', '성시경', 1979, '서울');

select * from usertbl;

# 문제 8.
-- ALTER를 이용하여 usertbl에서 PRIMARY KEY 제약조건 제거
-- name컬럼에 pk_name이라는 제약조건 명으로 기본 키 설정
-- 새로운 클러스터형 인덱스 확인
alter table usertbl drop primary key ;
alter table usertbl add constraint pk_name primary key (name);

select * from usertbl;

commit;