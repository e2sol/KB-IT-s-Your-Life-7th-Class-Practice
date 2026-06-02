# 문제 1.
-- 다음과 같은 컬럼을 가지는 tbl1을 생성
-- 자동으로 생성된 인덱스 목록 확인
create table tbl1 (
    a int primary key ,
    b int ,
    c int
);

show index from tbl1;

# 문제 2.
-- 다음과 같은 컬럼을 가지는 tbl2를 생성
-- 자동으로 생성된 인덱스 목록 확인
create table tbl2 (
    a int primary key ,
    b int unique ,
    c int unique ,
    d int
);

show index from tbl2;

# 문제 3.
-- 다음과 같은 컬럼을 가지는 tbl3를 생성
-- 자동으로 생성된 인덱스 목록 확인
create table tbl3 (
    a int unique ,
    b int unique ,
    c int unique ,
    d int
);

show index from tbl3;

# 문제 4.
-- 다음과 같은 컬럼을 가지는 tbl4를 생성
-- 자동으로 생성된 인덱스 목록 확인
create table tbl4 (
    a int unique not null ,
    b int unique ,
    c int unique ,
    d int
);

show index from tbl4;

# 문제 5.
-- 다음과 같은 컬럼을 가지는 tbl5를 생성
-- 자동으로 생성된 인덱스 목록 확인
create table tbl5 (
    a int unique not null ,
    b int unique ,
    c int unique ,
    d int primary key
);

show index from tbl5;

commit;