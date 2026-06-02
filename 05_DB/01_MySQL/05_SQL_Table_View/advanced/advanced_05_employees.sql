# 문제 5.
-- 이미지와 같은 직원 정보를 출력하는 EMPLOYEES_INFO 뷰를 작성
drop view if exists EMPLOYEES_INFO;
create view EMPLOYEES_INFO as (
    select e.*, title, t.from_date t_from, t.to_date t_to,
           salary, s.from_date s_from, s.to_date s_to
    from employees e
    join titles t on e.emp_no = t.emp_no
    join salaries s on e.emp_no = s.emp_no
                              );

select * from EMPLOYEES_INFO;

# 문제 6.
-- EMPLOYEES_INFO 뷰에서 재직자의 현재 정보만 출력
select *
from EMPLOYEES_INFO
where s_to = '9999-01-01';

# 문제 7.
-- 이미지와 같은 부서 정보를 출력하는 EMP_DEPT_INFO 뷰를 작성
drop view if exists EMP_DEPT_INFO;
create view EMP_DEPT_INFO as (
    select emp_no, de.dept_no, dept_name, from_date, to_date
    from dept_emp de join departments d on de.dept_no = d.dept_no
                             );

select * from EMP_DEPT_INFO order by emp_no;

# 문제 8.
-- EMP_DEPT_INFO 뷰를 이용해 현재 재직자의 부서 정보를 출력
select * from EMP_DEPT_INFO where to_date = '9999-01-01' order by emp_no;