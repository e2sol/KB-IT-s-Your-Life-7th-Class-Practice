-- =====================================================
-- 1. DATABASE 생성
-- =====================================================

DROP DATABASE IF EXISTS tableDB;
CREATE DATABASE tableDB;
USE tableDB;

-- =====================================================
-- 2. usertbl 생성
-- =====================================================

DROP TABLE IF EXISTS usertbl;

CREATE TABLE usertbl (
                         userID CHAR(8) NOT NULL PRIMARY KEY,
                         name VARCHAR(10) NOT NULL,
                         birthYear INT NOT NULL,
                         addr CHAR(2) NOT NULL,
                         mobile1 CHAR(3) NULL,
                         mobile2 CHAR(8) NULL,
                         height SMALLINT NULL,
                         mDate DATE NULL
);

-- =====================================================
-- 3. buytbl 생성 (외래키 포함)
-- =====================================================

DROP TABLE IF EXISTS buytbl;

CREATE TABLE buytbl (
                        num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
                        userID CHAR(8) NOT NULL,
                        prodName CHAR(6) NOT NULL,
                        groupName CHAR(4) NULL,
                        price INT NOT NULL,
                        amount SMALLINT NOT NULL,

                        CONSTRAINT FK_buytbl_usertbl
                            FOREIGN KEY(userID)
                                REFERENCES usertbl(userID)
);

-- =====================================================
-- 4. 데이터 입력
-- =====================================================

INSERT INTO usertbl VALUES
                        ('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-08-08'),
                        ('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-04-04'),
                        ('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-07-07');

INSERT INTO buytbl(userID, prodName, groupName, price, amount) VALUES
                                                                   ('KBS', '운동화', NULL, 30, 2),
                                                                   ('KBS', '노트북', '전자', 1000, 1),
                                                                   ('LSG', '모니터', '전자', 200, 1);

# 문제 5.
-- 기존 usertbl 삭제 후 조건에 따른 usertbl 정의

-- 기존 usertbl 삭제를 위해 연결되어있는 왜래키 먼저 삭제
ALTER TABLE buytbl
DROP FOREIGN KEY FK_buytbl_usertbl;

DROP TABLE usertbl;

CREATE TABLE usertbl (
    userID CHAR(8) NOT NULL PRIMARY KEY ,
    name VARCHAR(10) NOT NULL ,
    birthyear INT NOT NULL
);

# 문제 6.
-- prodtbl이 있는 경우 기존 테이블 삭제 후 문제 요구사항대로 재정의
DROP TABLE IF EXISTS prodtbl;

CREATE TABLE prodtbl (
    prodCode CHAR(3) NOT NULL ,
    prodID CHAR(4) NOT NULL ,
    prodDate DATETIME NOT NULL ,
    proCur CHAR(10) NULL ,

    PRIMARY KEY (prodCode, prodID)
);

COMMIT;

# 문제 7.
-- usertbl과 buytbl을 바탕으로 다음 결과가 나오는 뷰를 정의
drop view exam06;
create view exam06 as (
                      select u.userID, name, prodName, addr , concat(mobile1, mobile2) 연락처
                      from usertbl u join buytbl b on u.userID = b.userID
                      );

# 문제 7-1.
-- 위에서 정의한 뷰에서 userID가 '김범수'인 데이터만 출력
select * from exam06 where name = '김범수';