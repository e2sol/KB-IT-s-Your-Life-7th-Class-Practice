-- 각 부서별 관리자를 출력 (단, 현 재직자만 출력)
select employees.first_name, departments.dept_name
from employees
join dept_manager
on employees.emp_no = dept_manager.emp_no
join departments
on  dept_manager.dept_no= departments.dept_no
join dept_emp
on employees.emp_no = dept_emp.emp_no and dept_manager.dept_no = dept_emp.dept_no
where dept_manager.to_date = '9999-01-01' and dept_emp.to_date = '9999-01-01';

-- 부서번호 d005 부서의 현재 관리자 정보 출력
select *
from employees
join dept_manager
on employees.emp_no = dept_manager.emp_no
where to_date='9999-01-01' and dept_no = 'd005';

-- 페이지네이션으로 페이지를 추출, 다음 조건 하에서 8번 페이지의 데이터를 출력
-- - 입사일을 내림차순으로 정렬
-- - 한 페이지 당 20명의 정보를 출력
select * from employees
order by hire_date desc
limit 20 offset 140;

-- employees db에서 재직자의 총 수를 구하시오
-- 1차 답변
select count(emp_no) from employees where emp_no in (select emp_no from dept_emp where to_date='9999-01-01');
-- 2차 답변
select count(emp_no) from dept_emp where to_date = '9999-01-01';

-- employees db에서 재직자의 평균 급여를 출력하시오.
select avg(salary)
from salaries
where to_date = '9999-01-01' and
      emp_no in (select emp_no from dept_emp where to_date = '9999-01-01');

-- 재직자 전체 평균 급여보다 급여를 더 많이 받는 재직자를 출력하세요.
select *
from employees
join salaries
on employees.emp_no = salaries.emp_no
join dept_emp
on employees.emp_no = dept_emp.emp_no
where dept_emp.to_date = '9999-01-01' and
      salary > (select avg(salary)
                from salaries
                where to_date = '9999-01-01' and
                    emp_no in (select emp_no from dept_emp where to_date = '9999-01-01'));

-- employees db에서 각 부서별 재직자의 수를 구하시오
-- - 부서 번호로 구분하고, 부서 번호 오름차순 정렬하여 출력한다
select count(emp_no)
from dept_emp
where to_date = '9999-01-01'
group by dept_no
order by dept_no;