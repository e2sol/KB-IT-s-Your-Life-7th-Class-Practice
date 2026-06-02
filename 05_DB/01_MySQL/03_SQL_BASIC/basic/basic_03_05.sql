-- world database 이용 문제
select * from city where CountryCode = 'KOR' order by Population desc;

select CountryCode, Population from city order by CountryCode, Population desc;

select count(ID) from city where CountryCode = 'KOR';

select * from city where CountryCode = 'KOR' or CountryCode = 'CHN' or CountryCode = 'JPN';

select * from city where CountryCode = 'KOR' and Population >= 1000000;

select * from city where CountryCode = 'KOR' order by Population desc limit 10;

select * from city where CountryCode = 'KOR' and Population between 1000000 and 5000000;