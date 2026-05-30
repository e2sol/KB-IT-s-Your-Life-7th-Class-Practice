# 문제 1.
-- usertbl의 내용 확인
-- usertbl의 인덱스 목록 확인
-- usertbl의 데이터 크기와 인덱스의 크기 확인
select * from usertbl;
show index from usertbl;
show table status like 'usertbl';

# 문제 2.
-- usertbl의 addr 컬럼을 idx_usertbl_addr이름으로 인덱스 생성
-- 인덱스 목록 확인
create index idx_usertbl_addr on usertbl(addr);
show index from usertbl;

# 문제 3.
-- usertbl의 상태를 출력하여 인덱스의 내용이 생성되었는지 확인
-- 내용이 없다면 적용 후 인덱스의 크기를 확인
show table status like 'usertbl'; -- index_length = 0

-- 생성한 인덱스를 실제 적용을 하기 위해 analyze table문으로 먼저 테이블을 분석/처리 해야함
analyze table usertbl;
show table status like 'usertbl'; -- index_length = 16384

# 문제 4.
-- usertbl 사용
-- birthYear 컬럼에 대해 idx_usertbl_birthYear 이름의 인덱스 생성
--  > 에러가 난다면 그 이유를 설명
-- name 컬럼에 대해 idx_usertbl_name 이름의 인덱스 생성
-- 생성된 인덱스 목록 확인
create index idx_usertbl_birthYear on usertbl(birthYear);
drop index idx_usertbl_birthYear on usertbl;
-- 출생년도에 중복값이 존재할 수 있으므로 제거.
-- 원래는 중복값으로 인해 에러가 나야하는데 현재 데이터에 중복값이 없어 오류 미발생

create index idx_usertbl_name on usertbl(name);
show index from usertbl;

# 문제 5.
-- name 컬럼에 대한 보조 인덱스를 삭제
-- name과 birthYear 컬럼 조합으로 idx_usertbl_name_birthYear 이름의 인덱스를 생성
-- 인덱스 목록 확인
drop index idx_usertbl_name on usertbl;

create index idx_usertbl_name_birthYear on usertbl(name, birthYear);
show index from usertbl;

# 문제 6.
-- 앞서 만든 usertbl의 인덱스를 삭제
drop index idx_usertbl_addr on usertbl;
drop index idx_usertbl_name_birthYear on usertbl;
show index from usertbl;