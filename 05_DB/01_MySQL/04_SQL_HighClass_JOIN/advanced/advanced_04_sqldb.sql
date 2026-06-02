# sqldb 데이터베이스 이용

# 문제 01
-- 학생 테이블, 동아리 테이블, 학생 동아리 테이블을 이용해서 학생을 기준으로
-- 학생 이름/지역/가입한 동아리/동아리방을 출력
select stdtbl.stdName, stdtbl.addr, clubtbl.clubName, clubtbl.roomNo
from stdtbl
join stdclubtbl
on stdtbl.stdName = stdclubtbl.stdName
join clubtbl
on stdclubtbl.clubName = clubtbl.clubName;

# 문제 01-1
-- 동아리를 기준으로 가입한 학생의 목록을 출력
select clubtbl.clubName, clubtbl.roomNo, stdtbl.stdName, stdtbl.addr
from clubtbl
join stdclubtbl
on clubtbl.clubName = stdclubtbl.clubName
join stdtbl
on stdclubtbl.stdName = stdtbl.stdName;

# 문제 02
-- '우대리'의 상관 연락처 정보를 확인
-- 출력할 정보 : 부하직원, 직속상관, 직속상관 연락처
select e1.emp, e1.manager, e2.empTel
from emptbl e1
join emptbl e2
on e1.manager = e2.emp
where e1.emp = '우대리';
