select sum(Population) from city where CountryCode = 'KOR';

select min(Population) '최소값' from city where CountryCode = 'KOR';

select avg(Population) from city where CountryCode = 'KOR';

select max(Population) '최대값' from city where CountryCode = 'KOR';

select char_length(Name) from country;

select concat(upper(substr(Name, 1, 3)), substr(Name, 4)) from country;

select round(LifeExpectancy) from country