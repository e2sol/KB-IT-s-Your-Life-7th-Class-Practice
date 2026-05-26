-- sql database 이용
select * from usertbl where name = '김경호';

select * from usertbl where birthYear >= 1970 and height >= 182;

select * from usertbl where height between 180 and 183;

select * from usertbl where addr = '경남' or addr = '전북' or addr = '경북';

select * from usertbl where name like '김%'; -- 등호가 아니라 like를 사용해야 한다!

select * from usertbl where height >= (select height from usertbl where name = '김경호');

select * from usertbl order by mDate;

select * from usertbl order by mDate desc;

select * from usertbl order by height desc, name desc;

select distinct addr from usertbl order by addr;