# sqldb 데이터 베이스에서 진행

# 문제 01
-- 사용자 별로 구매이력 출력
-- 모든 컬럼 출력
-- 구매이력이 없는 정보는 출력하지 않음
select *
from usertbl
join buytbl
on usertbl.userID = buytbl.userID;

# 문제 01-1
-- 앞선 결과에서 userID가 'JYP'인 데이터만 출력
select *
from usertbl
join buytbl
on usertbl.userID = buytbl.userID
where usertbl.userID = 'JYP';

# 문제 02
-- 각 사용자 별 구매 이력 출력
-- 연결 컬럼은 userID로 함
-- 결과를 userID를 기준으로 오름차순 정렬
-- 구매 이력이 없는 사용자도 출력
-- 출력 결과는 문제의 이미지 참고
select
    usertbl.userID, usertbl.name, buytbl.prodName, usertbl.addr,
    concat(usertbl.mobile1, usertbl.mobile2) as 연락처
from usertbl
left join buytbl
on usertbl.userID = buytbl.userID
order by userID;

# 문제 03
-- sqldb 사용자를 모두 출력하되, 연락처가 없는 사람 제외
select * from usertbl where mobile1 is not null and mobile2 is not null;

# 문제 03-1
-- sqldb 사용자 중 연락처가 없는 사람만 출력
select * from usertbl where mobile1 is null or mobile2 is null;