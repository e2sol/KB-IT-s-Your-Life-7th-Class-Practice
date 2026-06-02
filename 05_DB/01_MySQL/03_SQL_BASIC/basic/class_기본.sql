show databases ;

-- sqldb 데이터 베이스로 전환
use sqldb;

-- usertbl에서 김경호보다 큰 사람들의 이름과 키 조회
select name, height from usertbl where height > (select height from usertbl where name = '김경호');

-- 김경호의 키 조회
select name, height from usertbl where name = '김경호';

-- 키가 177보다 큰 사람들의 이름과 키 조회
select name, height from usertbl where height > 177;