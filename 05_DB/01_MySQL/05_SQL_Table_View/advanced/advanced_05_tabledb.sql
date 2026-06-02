# 문제 1.
-- 문제 조건에 맞는 usertbl과 buytbl을 정의하라.
-- 기존에 테이블이 존재한다면 삭제

-- usertbl
DROP TABLE IF EXISTS usertbl;
CREATE TABLE usertbl (
    userID CHAR(8) NOT NULL PRIMARY KEY ,
    name VARCHAR(10) NOT NULL ,
    birthyear INT NOT NULL
);

-- buytbl
DROP TABLE IF EXISTS buytbl;
CREATE TABLE buytbl (
    num INT AUTO_INCREMENT NOT NULL PRIMARY KEY ,
    userID CHAR(8) NOT NULL,
    prodName CHAR(6) NOT NULL ,

    CONSTRAINT FK_buytbl_usertbl
    FOREIGN KEY (userID) REFERENCES usertbl(userID)
);

# 문제 2.
-- 다음 조건을 만족하는 usertbl을 정의
-- 기존 buytbl, usertbl을 삭제

DROP TABLE buytbl;
DROP TABLE usertbl;

CREATE TABLE usertbl (
    userID CHAR(8) NOT NULL PRIMARY KEY ,
    name VARCHAR(10) NOT NULL ,
    birthyear INT NOT NULL ,
    email CHAR(30) NULL UNIQUE
);

# 문제 3.
-- 다음 조건을 만족하는 usertbl을 정의
-- 기존 usertbl을 삭제

Drop TABLE usertbl;

CREATE TABLE usertbl (
    userID CHAR(8) NOT NULL PRIMARY KEY ,
    name VARCHAR(10) NULL ,
    birthYear INT check ( birthYear between 1900 and 2023) NULL ,
    mobile CHAR(3) NOT NULL
);

# 문제 4.
-- 다음 조건을 만족하는 usertbl을 정의
-- 기존 usertbl을 삭제
-- 기본값 추가를 확인할 수 있는 데이터를 추가

DROP TABLE usertbl;

CREATE TABLE usertbl (
    userID CHAR(8) NOT NULL PRIMARY KEY ,
    name VARCHAR(10) NOT NULL ,
    birthYear INT DEFAULT -1 ,
    addr CHAR(2) NOT NULL DEFAULT '서울' ,
    mobile1 CHAR(3) NULL ,
    mobile2 CHAR(8) NULL ,
    height SMALLINT NULL DEFAULT 170 ,
    mDate DATE NULL
);

INSERT INTO usertbl (userID, name) VALUES ('TEST', '테스트');

select * from usertbl;

# 문제 4-1.
-- 앞서 만든 usertbl에 대해 다음 조건을 처리하도록 수정
-- mobile1 컬럼 삭제
-- name 컬럼명을 uName으로 변경
-- 기본키 제거

ALTER TABLE usertbl DROP COLUMN mobile1;
ALTER TABLE usertbl CHANGE COLUMN name uName VARCHAR(10) NOT NULL;
ALTER TABLE usertbl DROP PRIMARY KEY;

desc usertbl;


COMMIT;