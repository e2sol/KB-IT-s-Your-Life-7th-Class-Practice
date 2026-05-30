# 문제 7.
-- 다음과 같이 실습 데이터베이스 및 사용자 생성
-- 해당 데이터베이스에 대해 모든 권한을 부여
create database scoula_db;
create user 'scoula'@'%' identified by '1234'; -- user : scoula, pw : 1234
grant all privileges on scoula_db.* to 'scoula'@'%'; -- 권한 부여
flush privileges;